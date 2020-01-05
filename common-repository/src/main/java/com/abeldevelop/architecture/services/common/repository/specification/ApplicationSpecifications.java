package com.abeldevelop.architecture.services.common.repository.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.services.common.model.ApplicationEntity;
import com.abeldevelop.architecture.services.common.model.ApplicationEntity_;

@Component
public class ApplicationSpecifications {

    public Specification<ApplicationEntity> nameLike(String query) {
        return (root, criteriaQuery, criteriaBuilder) -> { 
            return criteriaBuilder.like(
                    criteriaBuilder.upper(root.get(ApplicationEntity_.name)), 
                    "%" + query.toUpperCase() + "%");
        };
    }
    
}
