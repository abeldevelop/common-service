package com.abeldevelop.architecture.services.common.service.controller.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.abeldevelop.architecture.library.common.validation.ValidationFactory;
import com.abeldevelop.architecture.services.common.api.v1.ApplicationApi;
import com.abeldevelop.architecture.services.common.dto.ApplicationPaginationResponseResource;
import com.abeldevelop.architecture.services.common.dto.ApplicationResponseResource;
import com.abeldevelop.architecture.services.common.dto.ApplicationSort;
import com.abeldevelop.architecture.services.common.dto.CreateApplicationRequestResource;
import com.abeldevelop.architecture.services.common.dto.UpdateApplicationRequestResource;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/applications")
public class ApplicationApiController implements ApplicationApi {
    
    private final ValidationFactory validationFactory;
    
    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApplicationResponseResource executeCreate(@RequestBody CreateApplicationRequestResource createApplicationRequestResource) {
        log.info("executeCreate Data IN => createApplicationRequestResource: {}", createApplicationRequestResource);
        validationFactory.validate(createApplicationRequestResource);
        ApplicationResponseResource applicationResponseResource = null;
        log.info("executeCreate Data OUT => applicationResponseResource: {}", applicationResponseResource);
        validationFactory.validate(applicationResponseResource);
        return applicationResponseResource;
    }

    @Override
    @PutMapping("/{code}")
    @ResponseStatus(HttpStatus.OK)
    public ApplicationResponseResource executeUpdate(@PathVariable("code") String code, @RequestBody UpdateApplicationRequestResource updateApplicationRequestResource) {
        log.info("executeUpdate Data IN => code:{}, updateApplicationRequestResource: {}", code, updateApplicationRequestResource);
        validationFactory.validate(updateApplicationRequestResource);
        ApplicationResponseResource applicationResponseResource = null;
        log.info("executeUpdate Data OUT => applicationResponseResource: {}", applicationResponseResource);
        validationFactory.validate(applicationResponseResource);
        return applicationResponseResource;
    }

    @Override
    @DeleteMapping("/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void executeDelete(@PathVariable("code") String code) {
        log.info("executeDelete Data IN => code:{}", code);
        log.info("executeDelete Data OUT => ");
    }

    @Override
    @GetMapping("/{code}")
    @ResponseStatus(HttpStatus.OK)
    public ApplicationResponseResource executeFindByCode(@PathVariable("code") String code) {
        log.info("executeFindByCode Data IN => code:{}", code);
        ApplicationResponseResource applicationResponseResource = null;
        log.info("executeFindByCode Data OUT => applicationResponseResource: {}", applicationResponseResource);
        validationFactory.validate(applicationResponseResource);
        return applicationResponseResource;
    }

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ApplicationPaginationResponseResource executeFindAll(
            @RequestParam(name = "page", required = false) Integer page, 
            @RequestParam(name = "size", required = false) Integer size, 
            @RequestParam(name = "sort", required = false) ApplicationSort sort,
            @RequestParam(name = "query", required = false) String query) {
        log.info("executeFindAll Data IN => page:{}, size:{}, sort:{}, query:{}", page, size, sort, query);
        
        
        ApplicationPaginationResponseResource applicationPaginationResponseResource = null;
        
        log.info("executeFindAll Data OUT => applicationPaginationResponseResource: {}", applicationPaginationResponseResource);
        return applicationPaginationResponseResource;
    }
    
}
