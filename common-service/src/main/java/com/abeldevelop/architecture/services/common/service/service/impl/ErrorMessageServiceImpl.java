package com.abeldevelop.architecture.services.common.service.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.library.common.error.DefaultErrorMessageService;
import com.abeldevelop.architecture.services.common.service.config.ErrorCodesProperties;

@Component
public class ErrorMessageServiceImpl extends DefaultErrorMessageService {

    private final ErrorCodesProperties errorCodesProperties;
    
    @Autowired
    public ErrorMessageServiceImpl(ErrorCodesProperties errorCodesProperties) {
        addMessagesToMap();
        this.errorCodesProperties = errorCodesProperties;
    }

	private void addMessagesToMap() {
	    addMessage(errorCodesProperties.getPaginationMinPageError(), "The page number can not be less than {}");
        addMessage(errorCodesProperties.getPaginationMinSizeError(), "The page size can not be less than {}");
	    
	    addMessage(errorCodesProperties.getApplicationCodeExist(), "The application with code {} already exists");
	    addMessage(errorCodesProperties.getApplicationCodeNotExist(), "No exist application with code: {}");
	    addMessage(errorCodesProperties.getApplicationNameExist(), "The application with name {} already exists");
	    addMessage(errorCodesProperties.getApplicationNotNull(), "The application mandatory");
	    addMessage(errorCodesProperties.getApplicationCodeNotNull(), "The application code is mandatory");
	    addMessage(errorCodesProperties.getApplicationCodeSize(), "The application code must be between 3 and 25 characters");
	    addMessage(errorCodesProperties.getApplicationNameNotNull(), "The application name is mandatory");
	    addMessage(errorCodesProperties.getApplicationNameSize(), "The application name must be between 3 and 25 characters");
	    addMessage(errorCodesProperties.getApplicationDescriptionNotNull(), "The application description is mandatory");
	    addMessage(errorCodesProperties.getApplicationDescriptionSize(), "The application description must be between 3 and 255 characters");
	}
}
