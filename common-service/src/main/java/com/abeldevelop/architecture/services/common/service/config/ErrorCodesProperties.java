package com.abeldevelop.architecture.services.common.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Getter
@Configuration
@ConfigurationProperties(prefix = "error-code")
public class ErrorCodesProperties {

    private String applicationCodeExist;
    private String applicationNameExist;
}
