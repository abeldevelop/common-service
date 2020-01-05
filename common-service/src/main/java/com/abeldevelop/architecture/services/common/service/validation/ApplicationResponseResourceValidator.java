package com.abeldevelop.architecture.services.common.service.validation;

import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.library.common.validation.ValidationResource;
import com.abeldevelop.architecture.library.exception.server.ValidationResponseException;
import com.abeldevelop.architecture.services.common.dto.ApplicationResponseResource;
import com.abeldevelop.architecture.services.common.service.config.ErrorCodesProperties;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ApplicationResponseResourceValidator implements ValidationResource {

    private final ErrorCodesProperties errorCodesProperties;
    
    @Override
    public boolean areYouTheElement(String elementName) {
        return ApplicationResponseResource.class.getCanonicalName().equals(elementName);
    }

    @Override
    public void validate(Object toValidate) {
        if(toValidate == null) {
            throw new ValidationResponseException(errorCodesProperties.getApplicationNotNull());
        }
        ApplicationResponseResource applicationResponseResource = (ApplicationResponseResource) toValidate;
        validateCode(applicationResponseResource);
        validateName(applicationResponseResource);
        validateDescription(applicationResponseResource);
    }
    
    private void validateCode(ApplicationResponseResource applicationResponseResource) {
        if(applicationResponseResource.getCode() == null) {
            throw new ValidationResponseException(errorCodesProperties.getApplicationCodeNotNull());
        }
        int size = applicationResponseResource.getCode().length();
        if(size < 3 || size > 25) {
            throw new ValidationResponseException(errorCodesProperties.getApplicationCodeSize());
        }
    }
    
    private void validateName(ApplicationResponseResource applicationResponseResource) {
        if(applicationResponseResource.getName() == null) {
            throw new ValidationResponseException(errorCodesProperties.getApplicationNameNotNull());
        }
        int size = applicationResponseResource.getName().length();
        if(size < 3 || size > 25) {
            throw new ValidationResponseException(errorCodesProperties.getApplicationNameSize());
        }
    }
    
    private void validateDescription(ApplicationResponseResource applicationResponseResource) {
        if(applicationResponseResource.getDescription() == null) {
            throw new ValidationResponseException(errorCodesProperties.getApplicationDescriptionNotNull());
        }
        int size = applicationResponseResource.getDescription().length();
        if(size < 3 || size > 255) {
            throw new ValidationResponseException(errorCodesProperties.getApplicationDescriptionSize());
        }
    }
}
