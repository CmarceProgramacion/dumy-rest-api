#Autor: Claudia Nieto
#Email: cmarce86@yahoo.es
#language: en

@All
Feature: Validate the Create, Read, Update, Delete of Api employee
  As an user
  I want to access Dummy's Rest API platform services
  To employee information management

  Background: Access the service
    Given access to the platform services

  @Post
  Scenario Outline: Creation an employee
    When user create an employee
      | <name> | <salary> | <age> |
    Then verify the create new record in database
      | <message> |

    Examples:
      | name  | salary | age | message                              |
      | Julio | 1000   | 45  | Successfully! Record has been added. |

  @GetAll
  Scenario Outline: Consultation of all employee records
    When employee records are consulted
    Then verify service response
      | <message> |
    Examples:
      | message                                     |
      | Successfully! All records has been fetched. |


  @Get
  Scenario Outline: Consult employee
    When employee's record is consulted
      | <id> |
    Then verify service response
      | <message> |

    Examples:
      | id | message                                |
      | 2  | Successfully! Record has been fetched. |


  @Put
  Scenario Outline: Modify employee record
    When employee information is modified
      | <id> | <name> | <salary> | <age> |
    Then verify service response
      | <message> |
    Examples:
      | id | name  | salary | age | message                                |
      | 23 | Maria | 1000   | 45  | Successfully! Record has been updated. |


  @Delete
  Scenario Outline: Delete employee record
    When employee registration is eliminated
      | <id> |
    Then verify service response
      | <message> |

    Examples:
      | id | message                               |
      | 1  | Successfully! Record has been deleted |