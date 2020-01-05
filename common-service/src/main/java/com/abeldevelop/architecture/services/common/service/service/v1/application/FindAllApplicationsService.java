package com.abeldevelop.architecture.services.common.service.service.v1.application;

import com.abeldevelop.architecture.library.pagination.domain.PageIn;
import com.abeldevelop.architecture.library.pagination.domain.PaginationResult;
import com.abeldevelop.architecture.services.common.service.domain.Application;

public interface FindAllApplicationsService {

    public PaginationResult<Application> executeFindAll(PageIn pageRequest, String query);
    
}
