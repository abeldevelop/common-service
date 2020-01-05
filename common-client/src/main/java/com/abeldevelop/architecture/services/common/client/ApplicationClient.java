package com.abeldevelop.architecture.services.common.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.abeldevelop.architecture.services.common.dto.ApplicationPaginationResponseResource;
import com.abeldevelop.architecture.services.common.dto.ApplicationResponseResource;
import com.abeldevelop.architecture.services.common.dto.CreateApplicationRequestResource;
import com.abeldevelop.architecture.services.common.dto.UpdateApplicationRequestResource;

@FeignClient("common-service")
public interface ApplicationClient {
    
    String V1_BASE_REQUEST_MAPPING = "/v1/applications";
    
    @PostMapping(V1_BASE_REQUEST_MAPPING)
    public ApplicationResponseResource executeCreate(@RequestBody CreateApplicationRequestResource createApplicationRequestResource);
    
    @PutMapping(V1_BASE_REQUEST_MAPPING + "/{code}")
    public ApplicationResponseResource executeUpdate(@PathVariable("code") String code, @RequestBody UpdateApplicationRequestResource updateApplicationRequestResource);
 
    @DeleteMapping(V1_BASE_REQUEST_MAPPING + "/{code}")
    public void executeDelete(@PathVariable("code") String code);
    
    @GetMapping(V1_BASE_REQUEST_MAPPING + "/{code}")
    public ApplicationResponseResource executeFindByCode(@PathVariable("code") String code);
    
    @GetMapping(V1_BASE_REQUEST_MAPPING)
    public ApplicationPaginationResponseResource executeFindAll(@RequestParam(name = "page", required = false) Integer page, @RequestParam(name = "size", required = false) Integer size, @RequestParam(name = "query", required = false) String query);

}
