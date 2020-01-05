package com.abeldevelop.architecture.services.common.service.validation;

import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.library.common.validation.ValidationResource;
import com.abeldevelop.architecture.library.exception.client.ValidationRequestException;
import com.abeldevelop.architecture.services.common.dto.UpdateApplicationRequestResource;
import com.abeldevelop.architecture.services.common.service.config.ErrorCodesProperties;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UpdateApplicationRequestResourceValidator implements ValidationResource {

    private final ErrorCodesProperties errorCodesProperties;
    
    @Override
    public boolean areYouTheElement(String elementName) {
        return UpdateApplicationRequestResource.class.getCanonicalName().equals(elementName);
    }

    @Override
    public void validate(Object toValidate) {
        if(toValidate == null) {
            throw new ValidationRequestException(errorCodesProperties.getApplicationNotNull());
        }
        UpdateApplicationRequestResource createApplicationRequestResource = (UpdateApplicationRequestResource) toValidate;
        validateCode(createApplicationRequestResource);
        validateName(createApplicationRequestResource);
        validateDescription(createApplicationRequestResource);
    }
    
    private void validateCode(UpdateApplicationRequestResource updateApplicationRequestResource) {
        if(updateApplicationRequestResource.getCode() == null) {
            throw new ValidationRequestException(errorCodesProperties.getApplicationCodeNotNull());
        }
        int size = updateApplicationRequestResource.getCode().length();
        if(size < 3 || size > 25) {
            throw new ValidationRequestException(errorCodesProperties.getApplicationCodeSize());
        }
    }
    
    private void validateName(UpdateApplicationRequestResource updateApplicationRequestResource) {
        if(updateApplicationRequestResource.getName() == null) {
            throw new ValidationRequestException(errorCodesProperties.getApplicationNameNotNull());
        }
        int size = updateApplicationRequestResource.getName().length();
        if(size < 3 || size > 25) {
            throw new ValidationRequestException(errorCodesProperties.getApplicationNameSize());
        }
    }
    
    private void validateDescription(UpdateApplicationRequestResource updateApplicationRequestResource) {
        if(updateApplicationRequestResource.getDescription() == null) {
            throw new ValidationRequestException(errorCodesProperties.getApplicationDescriptionNotNull());
        }
        int size = updateApplicationRequestResource.getDescription().length();
        if(size < 3 || size > 255) {
            throw new ValidationRequestException(errorCodesProperties.getApplicationDescriptionSize());
        }
    }
}
