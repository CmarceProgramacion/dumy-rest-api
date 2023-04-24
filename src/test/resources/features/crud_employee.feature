#Autor: Claudia Nieto
#Email: cmarce86@yahoo.es
#language: en

@All
Feature: Validate the Create, Read, Update, Delete of employee
  As an user
  I want to access Dummy's Rest API platform services
  for employee information management


  @CasePost
  Scenario: Creation an employee
    When you create an employee
    Then Create new record in database

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