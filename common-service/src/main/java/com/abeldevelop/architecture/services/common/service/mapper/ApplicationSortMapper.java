package com.abeldevelop.architecture.services.common.service.mapper;

import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.library.pagination.domain.SortDirection;
import com.abeldevelop.architecture.library.pagination.domain.SortIn;
import com.abeldevelop.architecture.library.pagination.mapper.CommonSortDirectionMapper;
import com.abeldevelop.architecture.services.common.dto.ApplicationSort;

@Component
public class ApplicationSortMapper extends CommonSortDirectionMapper<ApplicationSort> {

    @Override
    public SortIn map(ApplicationSort enumSort) {
        if(enumSort != null) {
            if(ApplicationSort.NAME_DESC.getSort().equals(enumSort.getSort())) {
                return new SortIn(SortDirection.DESC, "name");
            }
        }
        //Default Sort
        return new SortIn(SortDirection.DESC, "name");
    }

}
