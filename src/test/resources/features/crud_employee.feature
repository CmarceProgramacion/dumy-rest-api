#Autor: Claudia Nieto
#Email: cmarce86@yahoo.es
#language: en

@All
Feature: Validate the Create, Read, Update, Delete of employee
  As an user
  I want to access Dummy's Rest API platform services
  for employee information management

  Background: Access the service
    Given Access the platform resource

  @CasePost
  Scenario Outline: Creation an employee
    When you create an employee
      | <name> | <salary> | <age> |
    Then Create new record in database

    Examples:
      | name  | salary | age |
      | Julio | 1000   | 45  |


  @CaseGetAll
  Scenario: Consultation of all employee records
    When employee records are consulted
    Then Get all employee data

  @CaseGet
  Scenario: Consult employee
    When employee's record is consulted
    Then Get a single employee data

  @CasePut
  Scenario: Modify employee record
    When employee information is modified
    Then Update an employee record

  @CaseDelete
  Scenario: Delete employee record
    When employee registration is eliminated
    Then Delete an employee record