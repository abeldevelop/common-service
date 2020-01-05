package com.abeldevelop.architecture.services.common.service.service.v1.application.impl;

import java.util.Arrays;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abeldevelop.architecture.services.common.model.ApplicationEntity;
import com.abeldevelop.architecture.services.common.repository.ApplicationRepository;
import com.abeldevelop.architecture.services.common.service.config.ErrorCodesProperties;
import com.abeldevelop.architecture.services.common.service.domain.Application;
import com.abeldevelop.architecture.services.common.service.exception.ApplicationNotFoundException;
import com.abeldevelop.architecture.services.common.service.mapper.ApplicationMapper;
import com.abeldevelop.architecture.services.common.service.service.v1.application.FindApplicationByCodeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindApplicationByCodeServiceImpl implements FindApplicationByCodeService {

    private final ErrorCodesProperties errorCodesProperties;
    private final ApplicationRepository applicationRepository;
    private final ApplicationMapper applicationMapper;
    
    @Override
    @Transactional
    public Application executeFindByCode(String code) {
        ApplicationEntity applicationEntity = applicationRepository.executeFindByCode(code)
                .orElseThrow(() -> new ApplicationNotFoundException(errorCodesProperties.getApplicationCodeNotExist(), Arrays.asList(code)));
        return applicationMapper.mapEntityToDomain(applicationEntity);
    }
    
}
