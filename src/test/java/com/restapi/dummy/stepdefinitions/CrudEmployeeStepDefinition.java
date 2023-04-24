package com.restapi.dummy.stepdefinitions;

import com.restapi.dummy.models.EmployeeModel;
import com.restapi.dummy.task.CreateEmployeeTask;
import com.restapi.dummy.utils.ConverterJson;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.List;

import static com.restapi.dummy.utils.enums.RestServiceEnum.BASE_URL;
import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CrudEmployeeStepDefinition {


    @Before
    public void initialAutomationConfig() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActor("Employee");
    }

    @Given("Access the platform resource")
    public void accessThePlatformResource() {
        theActorInTheSpotlight().whoCan(CallAnApi.at(BASE_URL.toString()));

    }

    @When("you create an employee")
    public void youCreateAnEmployee(List<List<String>> dataEmployee) {
        EmployeeModel employee = new EmployeeModel(dataEmployee.get(0));
        theActorInTheSpotlight().attemptsTo(
                CreateEmployeeTask.createEmployee(ConverterJson.converter(employee))
        );

    }

    @Then("Create new record in database")
    public void createNewRecordInDatabase() {
        assertThat(lastResponse().getStatusCode()).isEqualTo(200);
    }
    // theActorInTheSpotlight().should(        );

    @When("employee records are consulted")
    public void employeeRecordsAreConsulted() {

    }

    @Then("Get all employee data")
    public void getAllEmployeeData() {

    }

    @When("employee's record is consulted")
    public void employeeSRecordIsConsulted() {

    }

    @Then("Get a single employee data")
    public void getASingleEmployeeData() {

    }

    @When("employee information is modified")
    public void employeeInformationIsModified() {

    }

    @Then("Update an employee record")
    public void updateAnEmployeeRecord() {

    }

    @When("employee registration is eliminated")
    public void employeeRegistrationIsEliminated() {

    }

    @Then("Delete an employee record")
    public void deleteAnEmployeeRecord() {

    }
}
