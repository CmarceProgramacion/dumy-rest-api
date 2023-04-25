#Autor: Claudia Nieto
#Email: cmarce86@yahoo.es
#language: en

@All
Feature: Validate the Create, Read, Update, Delete of Api employee
  As an user
  I want to access Dummy's Rest API platform services
  for employee information management

  Background: Access the service
    Given access to the platform services

  @CasePost
  Scenario Outline: Creation an employee
    When user create an employee
      | <name> | <salary> | <age> |
    Then verify the create new record in database

    Examples:
      | name  | salary | age |
      | Julio | 1000   | 45  |

  @CaseGetAll
  Scenario: Consultation of all employee records
    When employee records are consulted
    Then verify that you get all employee data


  @CaseGet
  Scenario Outline: Consult employee
    When employee's record is consulted
      | <id> |
    Then verify that get a single employee data
      | <message> |

    Examples:
      | id | message                                |
      | 1  | Successfully! Record has been fetched. |


  @CasePut
  Scenario Outline: Modify employee record
    When employee information is modified
      | <id> | <name> | <salary> | <age> |
    Then verify the update of a record
      | <message> |
    Examples:
      | id | name  | salary | age | message                                |
      | 23  | Maria | 1000   | 45  | Successfully! Record has been updated. |


  @CaseDelete
  Scenario: Delete employee record
    When employee registration is eliminated
    Then verify the delete of a record