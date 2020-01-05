package com.abeldevelop.architecture.services.common.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.abeldevelop.architecture.services.common.model.ApplicationEntity;

public interface ApplicationRepository {

    public ApplicationEntity executeSave(ApplicationEntity categoryEntity);
    
    public Optional<ApplicationEntity> executeFindById(String id);
    
    public Optional<ApplicationEntity> executeFindOne(Specification<ApplicationEntity> spec);
    
    public void executeDeleteById(String code);

    public Page<ApplicationEntity> executeFindAll(Pageable pageable);
    
    public Page<ApplicationEntity> executeFindAll(Specification<ApplicationEntity> spec, Pageable pageable);
    
}
