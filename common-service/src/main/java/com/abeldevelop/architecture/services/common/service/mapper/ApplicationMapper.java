package com.abeldevelop.architecture.services.common.service.mapper;

import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.services.common.dto.ApplicationResponseResource;
import com.abeldevelop.architecture.services.common.dto.CreateApplicationRequestResource;
import com.abeldevelop.architecture.services.common.dto.UpdateApplicationRequestResource;
import com.abeldevelop.architecture.services.common.model.ApplicationEntity;
import com.abeldevelop.architecture.services.common.service.domain.Application;

@Component
public class ApplicationMapper {

    public Application mapResourceToDomain(CreateApplicationRequestResource createApplicationRequestResource) {
        return Application.builder()
                .code(createApplicationRequestResource.getCode())
                .name(createApplicationRequestResource.getName())
                .description(createApplicationRequestResource.getDescription())
                .build();
    }
    
    public Application mapResourceToDomain(UpdateApplicationRequestResource updateApplicationRequestResource) {
        return Application.builder()
                .code(updateApplicationRequestResource.getCode())
                .name(updateApplicationRequestResource.getName())
                .description(updateApplicationRequestResource.getDescription())
                .build();
    }
    
    public ApplicationEntity mapDomainToEntity(Application application) {
        return ApplicationEntity.builder()
                .code(application.getCode())
                .name(application.getName())
                .description(application.getDescription())
                .build();
    }
    
    public Application mapEntityToDomain(ApplicationEntity applicationEntity) {
        return Application.builder()
                .code(applicationEntity.getCode())
                .name(applicationEntity.getName())
                .description(applicationEntity.getDescription())
                .build();
    }
    
    public ApplicationResponseResource mapDomainToResource(Application application) {
        return ApplicationResponseResource.builder()
                .code(application.getCode())
                .name(application.getName())
                .description(application.getDescription())
                .build();
    }
}
