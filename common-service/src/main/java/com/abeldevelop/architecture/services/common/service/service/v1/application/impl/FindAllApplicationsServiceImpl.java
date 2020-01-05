package com.abeldevelop.architecture.services.common.service.service.v1.application.impl;

import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abeldevelop.architecture.library.pagination.domain.PageIn;
import com.abeldevelop.architecture.library.pagination.domain.PaginationResult;
import com.abeldevelop.architecture.library.pagination.mapper.PaginationMapper;
import com.abeldevelop.architecture.services.common.model.ApplicationEntity;
import com.abeldevelop.architecture.services.common.repository.ApplicationRepository;
import com.abeldevelop.architecture.services.common.repository.specification.ApplicationSpecifications;
import com.abeldevelop.architecture.services.common.service.domain.Application;
import com.abeldevelop.architecture.services.common.service.mapper.ApplicationMapper;
import com.abeldevelop.architecture.services.common.service.mapper.ApplicationSortMapper;
import com.abeldevelop.architecture.services.common.service.service.v1.application.FindAllApplicationsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindAllApplicationsServiceImpl implements FindAllApplicationsService {

    private final ApplicationRepository applicationRepository;
    private final ApplicationSortMapper applicationSortMapper;
    private final ApplicationSpecifications applicationSpecifications;
    private final PaginationMapper paginationMapper;
    private final ApplicationMapper applicationMapper;
    
    @Override
    @Transactional
    public PaginationResult<Application> executeFindAll(PageIn pageIn, String query) {
        Page<ApplicationEntity> applicationEntityPage = findAll(pageIn, query);
        
        return new PaginationResult<>(
                paginationMapper.mapPageToPaginationOut(applicationEntityPage), 
                applicationEntityPage.getContent().stream().map(applicationMapper::mapEntityToDomain).collect(Collectors.toList()));
    }
    
    private Page<ApplicationEntity> findAll(PageIn pageIn, String query) {
        PageRequest pageRequest = PageRequest.of(pageIn.getPagination().getPage(), pageIn.getPagination().getSize(), applicationSortMapper.map(pageIn.getSort()));
        if(query == null || query.isEmpty()) {
            return applicationRepository.executeFindAll(pageRequest);
        } else {
            return applicationRepository.executeFindAll(applicationSpecifications.nameLike(query), pageRequest);
        }
    }
}
