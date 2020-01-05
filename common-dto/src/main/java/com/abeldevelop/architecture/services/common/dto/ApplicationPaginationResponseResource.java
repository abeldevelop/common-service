package com.abeldevelop.architecture.services.common.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.abeldevelop.architecture.library.pagination.resource.PaginationResponseResource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

@ApiModel(description="Resource with pagination information")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ApplicationPaginationResponseResource {

    @ApiModelProperty(notes="Resource with pagination information", required = true, position = 0)
    @NotNull
    private PaginationResponseResource pagination;

    @ApiModelProperty(notes="List of applications", required = true, position = 1)
    @Singular
    private List<ApplicationResponseResource> applications;
    
}
