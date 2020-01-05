package com.abeldevelop.architecture.services.common.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel(description="Create Application resource")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CreateApplicationRequestResource {

    @ApiModelProperty(notes="Application name of the service", example="blog-category-service", required = true, position = 0)
    @NotNull
    @Size(min = 3, max = 25)
    private String code;
    
    @ApiModelProperty(notes="Name of the application", example="Blog Category Service", required = true, position = 1)
    @NotNull
    @Size(min = 3, max = 25)
    private String name;
    
    @ApiModelProperty(notes="Description of the applicacion", example="Service to manage the blog categories", required = true, position = 2)
    @NotNull
    @Size(min = 3, max = 25)
    private String description;
    
}
