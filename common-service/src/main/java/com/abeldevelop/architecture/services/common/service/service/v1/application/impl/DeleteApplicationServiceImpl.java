package com.abeldevelop.architecture.services.common.service.service.v1.application.impl;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abeldevelop.architecture.services.common.model.ApplicationEntity;
import com.abeldevelop.architecture.services.common.repository.ApplicationRepository;
import com.abeldevelop.architecture.services.common.service.config.ErrorCodesProperties;
import com.abeldevelop.architecture.services.common.service.exception.ApplicationNotFoundException;
import com.abeldevelop.architecture.services.common.service.service.v1.application.DeleteApplicationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeleteApplicationServiceImpl implements DeleteApplicationService {

    private final ErrorCodesProperties errorCodesProperties;
    private final ApplicationRepository applicationRepository;
    
    @Override
    @Transactional
	public void executeDeleteByCode(String code) {
        checkIfApplicationExist(code);
        applicationRepository.executeDeleteByCode(code);
        //TODO => Send to queue the code of the deleted application. Other services need to delete data
        
    }
	
    private void checkIfApplicationExist(String code) {
        Optional<ApplicationEntity> findByCode = applicationRepository.executeFindByCode(code);
        if(!findByCode.isPresent()) {
            throw new ApplicationNotFoundException(errorCodesProperties.getApplicationCodeNotExist(), Arrays.asList(code));
        }
    }
}
