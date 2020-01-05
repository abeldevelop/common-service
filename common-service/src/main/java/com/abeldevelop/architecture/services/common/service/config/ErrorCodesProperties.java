package com.abeldevelop.architecture.services.common.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "error-code")
public class ErrorCodesProperties {

    private String paginationMinPageError;
    private String paginationMinSizeError;
    private String applicationCodeExist;
    private String applicationCodeNotExist;
    private String applicationNameExist;
    private String applicationNotNull;
    private String applicationCodeNotNull;
    private String applicationCodeSize;
    private String applicationNameNotNull;
    private String applicationNameSize;
    private String applicationDescriptionNotNull;
    private String applicationDescriptionSize;
    
}
