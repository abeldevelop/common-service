package com.abeldevelop.architecture.services.common.service.validation;

import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.library.common.validation.ValidationResource;

@Component
public class ExampleValidation implements ValidationResource {

    @Override
    public boolean areYouTheElement(String elementName) {
        return ExampleValidation.class.getCanonicalName().equals(elementName);
    }

    @Override
    public void validate(Object toValidate) {
        // TODO Auto-generated method stub
        
    }

}
