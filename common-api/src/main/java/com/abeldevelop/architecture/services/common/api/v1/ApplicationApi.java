package com.abeldevelop.architecture.services.common.api.v1;

import com.abeldevelop.architecture.library.exception.dto.ErrorResponseResource;
import com.abeldevelop.architecture.services.common.dto.ApplicationPaginationResponseResource;
import com.abeldevelop.architecture.services.common.dto.ApplicationResponseResource;
import com.abeldevelop.architecture.services.common.dto.ApplicationSort;
import com.abeldevelop.architecture.services.common.dto.CreateApplicationRequestResource;
import com.abeldevelop.architecture.services.common.dto.UpdateApplicationRequestResource;
import com.abeldevelop.architecture.starter.api.SpringFoxConfiguration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags= {"Applications"})
public interface ApplicationApi {

	@ApiOperation(value = "Create new application")
	@ApiResponses({ 
		@ApiResponse(code = 201, response = ApplicationResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_201_MESSAGE), 
		@ApiResponse(code = 400, response = ErrorResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_400_MESSAGE),
		@ApiResponse(code = 500, response = ErrorResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_500_MESSAGE)
	})
	public ApplicationResponseResource executeCreate(@ApiParam(name="application", value="Application to create", required = true) CreateApplicationRequestResource createApplicationRequestResource);
	
	@ApiOperation(value = "Update a category")
	@ApiResponses({ 
		@ApiResponse(code = 200, response = ApplicationResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_200_MESSAGE), 
		@ApiResponse(code = 400, response = ErrorResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_400_MESSAGE),
		@ApiResponse(code = 404, response = ErrorResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_404_MESSAGE),
		@ApiResponse(code = 500, response = ErrorResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_500_MESSAGE)
	})
	public ApplicationResponseResource executeUpdate(
			@ApiParam(name="application", value="Application to updated", required = true) UpdateApplicationRequestResource updateApplicationRequestResource);
	
	@ApiOperation(value = "Delete a application")
	@ApiResponses({ 
		@ApiResponse(code = 204, response = ApplicationResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_204_MESSAGE), 
		@ApiResponse(code = 404, response = ErrorResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_404_MESSAGE),
		@ApiResponse(code = 500, response = ErrorResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_500_MESSAGE)
	})
	public void executeDelete(@ApiParam(name="code", value="Code of the application", required = true, example="blog-category-service") String code);
	
	@ApiOperation(value = "Find application by code")
	@ApiResponses({ 
		@ApiResponse(code = 200, response = ApplicationResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_200_MESSAGE), 
		@ApiResponse(code = 404, response = ErrorResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_404_MESSAGE),
		@ApiResponse(code = 500, response = ErrorResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_500_MESSAGE)
	})
	public ApplicationResponseResource executeFindByCode(@ApiParam(name="code", value="Code of the category", required = true, example="first-category") String code);
	
	@ApiOperation(value = "Find all applications")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "Number of page", required = false, example="1", defaultValue="1", dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "size", value = "Size of page", required = false, example="1", defaultValue="10", dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "sort", value = "Field and type to sort the fields", required = false, defaultValue = "NAME_DESC", example="NAME_DESC", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "query", value = "Name or part of application name to search", required = false, example="fir", dataType = "string", paramType = "query")
	})
	@ApiResponses({ 
		@ApiResponse(code = 200, response = ApplicationPaginationResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_200_MESSAGE),
		@ApiResponse(code = 400, response = ErrorResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_400_MESSAGE),
		@ApiResponse(code = 404, response = ErrorResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_404_MESSAGE),
		@ApiResponse(code = 500, response = ErrorResponseResource.class, message = SpringFoxConfiguration.API_RESPONSE_CODE_500_MESSAGE)
	})
	public ApplicationPaginationResponseResource executeFindAll(Integer page, Integer size, ApplicationSort sort, String query);
	
}
