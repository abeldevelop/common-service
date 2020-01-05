package com.abeldevelop.architecture.services.common.service.validation;

import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.library.common.validation.ValidationResource;
import com.abeldevelop.architecture.library.exception.client.ValidationRequestException;
import com.abeldevelop.architecture.services.common.dto.CreateApplicationRequestResource;
import com.abeldevelop.architecture.services.common.service.config.ErrorCodesProperties;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CreateApplicationRequestResourceValidator implements ValidationResource {

    private final ErrorCodesProperties errorCodesProperties;
    
    @Override
    public boolean areYouTheElement(String elementName) {
        return CreateApplicationRequestResource.class.getCanonicalName().equals(elementName);
    }

    @Override
    public void validate(Object toValidate) {
        if(toValidate == null) {
            throw new ValidationRequestException(errorCodesProperties.getApplicationNotNull());
        }
        CreateApplicationRequestResource createApplicationRequestResource = (CreateApplicationRequestResource) toValidate;
        validateCode(createApplicationRequestResource);
        validateName(createApplicationRequestResource);
        validateDescription(createApplicationRequestResource);
    }
    
    private void validateCode(CreateApplicationRequestResource createApplicationRequestResource) {
        if(createApplicationRequestResource.getCode() == null) {
            throw new ValidationRequestException(errorCodesProperties.getApplicationCodeNotNull());
        }
        int size = createApplicationRequestResource.getCode().length();
        if(size < 3 || size > 25) {
            throw new ValidationRequestException(errorCodesProperties.getApplicationCodeSize());
        }
    }
    
    private void validateName(CreateApplicationRequestResource createApplicationRequestResource) {
        if(createApplicationRequestResource.getName() == null) {
            throw new ValidationRequestException(errorCodesProperties.getApplicationNameNotNull());
        }
        int size = createApplicationRequestResource.getName().length();
        if(size < 3 || size > 25) {
            throw new ValidationRequestException(errorCodesProperties.getApplicationNameSize());
        }
    }
    
    private void validateDescription(CreateApplicationRequestResource createApplicationRequestResource) {
        if(createApplicationRequestResource.getDescription() == null) {
            throw new ValidationRequestException(errorCodesProperties.getApplicationDescriptionNotNull());
        }
        int size = createApplicationRequestResource.getDescription().length();
        if(size < 3 || size > 255) {
            throw new ValidationRequestException(errorCodesProperties.getApplicationDescriptionSize());
        }
    }
}
