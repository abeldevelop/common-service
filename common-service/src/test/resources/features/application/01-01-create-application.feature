Feature: Create new application
    I want to create new application

    Scenario Outline: Create application <TC>
        Given The endpoint "/v1/applications"
        And The resource com.abeldevelop.architecture.services.common.dto.CreateApplicationRequestResource
        And The input data
            | code      | name   | description   |
            | <code>    | <name> | <description> |
        When Make "POST" call
        Then I verify the <responseStatusCode> response code
        And If response code is 201 i verify the contract
        And If response code not 201 i verify the error response message <errorResponseMessage>

        Examples: 
            | TC    | code                           | name                          | description                | responseStatusCode    | errorResponseMessage                                             |
            | TC01  | blog-category-service          | Blog Category Service         | Description of the service | 201                   |                                                                  |
            | TC02  | blog-category-service          | Blog Category Service         | Description of the service | 400                   | The application with code blog-category-service already exists   |
            | TC03  | blog-category2-service         | Blog Category Service         | Description of the service | 400                   | The application with name Blog Category Service already exists   |
            | TC04  |                                | Blog Category Service         | Description of the service | 400                   | The application code is mandatory                                |
            | TC05  | bl                             | Blog Category Service         | Description of the service | 400                   | The application code must be between 3 and 25 characters         |
            | TC06  | aaaaa aaaaa aaaaa aaaaa aaaaa  | Blog Category Service         | Description of the service | 400                   | The application code must be between 3 and 25 characters         |
            | TC07  | blog-category-service          |                               | Description of the service | 400                   | The application name is mandatory                                |
            | TC08  | blog-category-service          | Bl                            | Description of the service | 400                   | The application name must be between 3 and 25 characters         |
            | TC09  | blog-category-service          | aaaaa aaaaa aaaaa aaaaa aaaaa | Description of the service | 400                   | The application name must be between 3 and 25 characters         |
            | TC10  | blog-category-service          | Blog Category Service         |                            | 400                   | The application description is mandatory                         |
            | TC11  | blog-category-service          | Blog Category Service         | De                         | 400                   | The application description must be between 3 and 255 characters |
