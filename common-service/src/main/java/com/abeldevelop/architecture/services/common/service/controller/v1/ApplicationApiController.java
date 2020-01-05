package com.abeldevelop.architecture.services.common.service.controller.v1;

import java.util.stream.Collectors;

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
import com.abeldevelop.architecture.library.pagination.domain.PageIn;
import com.abeldevelop.architecture.library.pagination.domain.PaginationResult;
import com.abeldevelop.architecture.library.pagination.mapper.PaginationMapper;
import com.abeldevelop.architecture.services.common.api.v1.ApplicationApi;
import com.abeldevelop.architecture.services.common.dto.ApplicationPaginationResponseResource;
import com.abeldevelop.architecture.services.common.dto.ApplicationResponseResource;
import com.abeldevelop.architecture.services.common.dto.ApplicationSort;
import com.abeldevelop.architecture.services.common.dto.CreateApplicationRequestResource;
import com.abeldevelop.architecture.services.common.dto.UpdateApplicationRequestResource;
import com.abeldevelop.architecture.services.common.service.domain.Application;
import com.abeldevelop.architecture.services.common.service.mapper.ApplicationMapper;
import com.abeldevelop.architecture.services.common.service.mapper.ApplicationSortMapper;
import com.abeldevelop.architecture.services.common.service.service.v1.application.CreateApplicationService;
import com.abeldevelop.architecture.services.common.service.service.v1.application.DeleteApplicationService;
import com.abeldevelop.architecture.services.common.service.service.v1.application.FindAllApplicationsService;
import com.abeldevelop.architecture.services.common.service.service.v1.application.FindApplicationByCodeService;
import com.abeldevelop.architecture.services.common.service.service.v1.application.UpdateApplicationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/applications")
public class ApplicationApiController implements ApplicationApi {
    
    private final CreateApplicationService createApplicationService;
    private final UpdateApplicationService updateApplicationService;
    private final FindApplicationByCodeService findApplicationByCodeService;
    private final FindAllApplicationsService findAllApplicationsService;
    private final DeleteApplicationService deleteApplicationService;
    
    private final ApplicationMapper applicationsMapper;
    private final PaginationMapper paginationMapper;
    private final ApplicationSortMapper applicationsSortMapper;
    
    private final ValidationFactory validationFactory;
    
    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApplicationResponseResource executeCreate(@RequestBody CreateApplicationRequestResource createApplicationRequestResource) {
        log.info("executeCreate Data IN => createApplicationRequestResource: {}", createApplicationRequestResource);
        validationFactory.validate(createApplicationRequestResource);
        ApplicationResponseResource applicationResponseResource = applicationsMapper.mapDomainToResource(createApplicationService.executeCreate(applicationsMapper.mapResourceToDomain(createApplicationRequestResource)));
        log.info("executeCreate Data OUT => applicationResponseResource: {}", applicationResponseResource);
        validationFactory.validate(applicationResponseResource);
        return applicationResponseResource;
    }

    @Override
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ApplicationResponseResource executeUpdate(@RequestBody UpdateApplicationRequestResource updateApplicationRequestResource) {
        log.info("executeUpdate Data IN => updateApplicationRequestResource: {}", updateApplicationRequestResource);
        validationFactory.validate(updateApplicationRequestResource);
        ApplicationResponseResource applicationResponseResource = applicationsMapper.mapDomainToResource(updateApplicationService.executeUpdate(applicationsMapper.mapResourceToDomain(updateApplicationRequestResource)));
        log.info("executeUpdate Data OUT => applicationResponseResource: {}", applicationResponseResource);
        validationFactory.validate(applicationResponseResource);
        return applicationResponseResource;
    }

    @Override
    @DeleteMapping("/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void executeDelete(@PathVariable("code") String code) {
        log.info("executeDelete Data IN => code:{}", code);
        deleteApplicationService.executeDeleteByCode(code);
        log.info("executeDelete Data OUT => ");
    }

    @Override
    @GetMapping("/{code}")
    @ResponseStatus(HttpStatus.OK)
    public ApplicationResponseResource executeFindByCode(@PathVariable("code") String code) {
        log.info("executeFindByCode Data IN => code:{}", code);
        ApplicationResponseResource applicationResponseResource = applicationsMapper.mapDomainToResource(findApplicationByCodeService.executeFindByCode(code));
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
        
        PageIn pageRequest = PageIn.builder()
                .pagination(paginationMapper.map(page, size))
                .sort(applicationsSortMapper.map(sort))
                .build();
        
        PaginationResult<Application> paginationResult = findAllApplicationsService.executeFindAll(pageRequest, query);
        
        ApplicationPaginationResponseResource applicationPaginationResponseResource = ApplicationPaginationResponseResource.builder()
                .pagination(paginationMapper.map(paginationResult.getPagination()))
                .applications(paginationResult.getResults().stream().map(applicationsMapper::mapDomainToResource).collect(Collectors.toList()))
                .build();
        
        log.info("executeFindAll Data OUT => applicationPaginationResponseResource: {}", applicationPaginationResponseResource);
        return applicationPaginationResponseResource;
    }
    
}
