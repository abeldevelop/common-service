package com.abeldevelop.architecture.services.common.service.service.impl;


import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.library.common.error.DefaultErrorMessageService;

@Component
public class ErrorMessageServiceImpl extends DefaultErrorMessageService {

    public ErrorMessageServiceImpl() {
        addMessagesToMap();
    }

	private void addMessagesToMap() {
	    addMessage("requestFieldValueNotValid", "The value {} is not one of those available");
	    addMessage("paginationMinPageError", "The page number can not be less than {}");
        addMessage("paginationMinSizeError", "The page size can not be less than {}");
	    
	    addMessage("applicationCodeExist", "The application with code {} already exists");
	    addMessage("applicationCodeNotExist", "No exist application with code: {}");
	    addMessage("applicationNameExist", "The application with name {} already exists");
	    addMessage("applicationNotNull", "The application mandatory");
	    addMessage("applicationCodeNotNull", "The application code is mandatory");
	    addMessage("applicationCodeSize", "The application code must be between 3 and 25 characters");
	    addMessage("applicationNameNotNull", "The application name is mandatory");
	    addMessage("applicationNameSize", "The application name must be between 3 and 25 characters");
	    addMessage("applicationDescriptionNotNull", "The application description is mandatory");
	    addMessage("applicationDescriptionSize", "The application description must be between 3 and 255 characters");
	}
}
