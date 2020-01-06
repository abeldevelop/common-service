package com.abeldevelop.architecture.services.common.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class ErrorCodesProperties {

    @Value("${error-code.paginationMinPageError}")
    private String paginationMinPageError;
    
    @Value("${error-code.paginationMinSizeError}")
    private String paginationMinSizeError;
    
    @Value("${error-code.applicationCodeExist}")
    private String applicationCodeExist;
    
    @Value("${error-code.applicationCodeNotExist}")
    private String applicationCodeNotExist;
    
    @Value("${error-code.applicationNameExist}")
    private String applicationNameExist;
    
    @Value("${error-code.applicationNotNull}")
    private String applicationNotNull;
    
    @Value("${error-code.applicationCodeNotNull}")
    private String applicationCodeNotNull;
    
    @Value("${error-code.applicationCodeSize}")
    private String applicationCodeSize;
    
    @Value("${error-code.applicationNameNotNull}")
    private String applicationNameNotNull;
    
    @Value("${error-code.applicationNameSize}")
    private String applicationNameSize;
    
    @Value("${error-code.applicationDescriptionNotNull}")
    private String applicationDescriptionNotNull;
    
    @Value("${error-code.applicationDescriptionSize}")
    private String applicationDescriptionSize;
    
}
