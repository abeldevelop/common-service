package com.abeldevelop.architecture.services.common.service.service.v1.application.impl;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abeldevelop.architecture.services.common.model.ApplicationEntity;
import com.abeldevelop.architecture.services.common.repository.ApplicationRepository;
import com.abeldevelop.architecture.services.common.repository.specification.ApplicationSpecifications;
import com.abeldevelop.architecture.services.common.service.config.ErrorCodesProperties;
import com.abeldevelop.architecture.services.common.service.domain.Application;
import com.abeldevelop.architecture.services.common.service.exception.ApplicationExistException;
import com.abeldevelop.architecture.services.common.service.exception.ApplicationNotFoundException;
import com.abeldevelop.architecture.services.common.service.mapper.ApplicationMapper;
import com.abeldevelop.architecture.services.common.service.service.v1.application.UpdateApplicationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UpdateApplicationServiceImpl implements UpdateApplicationService {

    private final ErrorCodesProperties errorCodesProperties;
    private final ApplicationRepository applicationRepository;
    private final ApplicationSpecifications applicationSpecifications;
    private final ApplicationMapper applicationMapper;
    
    @Override
    @Transactional
	public Application executeUpdate(Application application) {
        ApplicationEntity applicationEntity = checkIfApplicationExist(application);
        checkIfNewApplicationExist(application);
        return applicationMapper.mapEntityToDomain(applicationRepository.executeSave(applicationEntity));
    }
	
    private ApplicationEntity checkIfApplicationExist(Application application) {
        return applicationRepository.executeFindByCode(application.getCode()).orElseThrow(() -> new ApplicationNotFoundException(errorCodesProperties.getApplicationCodeNotExist(), Arrays.asList(application.getCode())));
    }
    
    private void checkIfNewApplicationExist(Application application) {
        Optional<ApplicationEntity> findByName = applicationRepository.executeFindOne(applicationSpecifications.nameEquals(application.getName()));
        if(findByName.isPresent()) {
            throw new ApplicationExistException(errorCodesProperties.getApplicationNameExist(), Arrays.asList(application.getCode()));
        }
    }
}
