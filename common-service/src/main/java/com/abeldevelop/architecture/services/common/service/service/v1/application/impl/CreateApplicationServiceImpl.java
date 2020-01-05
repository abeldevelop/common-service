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
import com.abeldevelop.architecture.services.common.service.mapper.ApplicationMapper;
import com.abeldevelop.architecture.services.common.service.service.v1.application.CreateApplicationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateApplicationServiceImpl implements CreateApplicationService {

    private final ApplicationSpecifications applicationSpecifications;
    private final ErrorCodesProperties errorCodesProperties;
    private final ApplicationRepository applicationRepository;
    private final ApplicationMapper applicationMapper;
    
    @Override
    @Transactional
	public Application executeCreate(Application application) {
        checkIfApplicationExist(application);
        ApplicationEntity applicationEntity = applicationMapper.mapDomainToEntity(application);
        return applicationMapper.mapEntityToDomain(applicationRepository.executeSave(applicationEntity));
	}
	
    private void checkIfApplicationExist(Application application) {
        Optional<ApplicationEntity> findByCode = applicationRepository.executeFindByCode(application.getCode());
        if(findByCode.isPresent()) {
            throw new ApplicationExistException(errorCodesProperties.getApplicationCodeExist(), Arrays.asList(application.getCode()));
        }
        Optional<ApplicationEntity> findByName = applicationRepository.executeFindOne(applicationSpecifications.nameEquals(application.getName()));
        if(findByName.isPresent()) {
            throw new ApplicationExistException(errorCodesProperties.getApplicationNameExist(), Arrays.asList(application.getCode()));
        }
    }
    
}
