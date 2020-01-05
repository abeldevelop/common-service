package com.abeldevelop.architecture.services.common.repository.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import com.abeldevelop.architecture.services.common.model.ApplicationEntity;
import com.abeldevelop.architecture.services.common.repository.ApplicationRepository;
import com.abeldevelop.architecture.services.common.repository.springdata.ApplicationSpringDataRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class ApplicationRepositoryImpl implements ApplicationRepository {

    private final ApplicationSpringDataRepository applicationSpringDataRepository;

    @Override
    public ApplicationEntity executeSave(ApplicationEntity applicationEntity) {
        return applicationSpringDataRepository.save(applicationEntity);
    }

    @Override
    public Optional<ApplicationEntity> executeFindByCode(String code) {
        return applicationSpringDataRepository.findById(code);
    }

    @Override
    public Optional<ApplicationEntity> executeFindOne(Specification<ApplicationEntity> spec) {
        return applicationSpringDataRepository.findOne(spec);
    }

    @Override
    public void executeDeleteByCode(String code) {
        applicationSpringDataRepository.deleteById(code);
    }

    @Override
    public Page<ApplicationEntity> executeFindAll(Pageable pageable) {
        return applicationSpringDataRepository.findAll(pageable);
    }

    @Override
    public Page<ApplicationEntity> executeFindAll(Specification<ApplicationEntity> spec, Pageable pageable) {
        return applicationSpringDataRepository.findAll(spec, pageable);
    }
    
}
