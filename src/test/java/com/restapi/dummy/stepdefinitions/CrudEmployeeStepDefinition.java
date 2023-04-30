package com.restapi.dummy.stepdefinitions;

import com.restapi.dummy.models.EmployeeModel;
import com.restapi.dummy.task.*;
import com.restapi.dummy.utils.ConverterJson;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.List;

import static com.restapi.dummy.utils.enums.RestServiceEnum.BASE_URL;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CrudEmployeeStepDefinition {
    private EmployeeModel employee;

    @Before
    public void initialAutomationConfig() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActor("Juanito");
    }

    @Given("access to the platform services")
    public void accessToThePlatformServices() {
        theActorInTheSpotlight().whoCan(CallAnApi.at(BASE_URL.toString()));
    }

    @When("user create an employee")
    public void userCreateAnEmployee(List<List<String>> dataEmployee) {
        employee = new EmployeeModel(dataEmployee.get(0));
        theActorInTheSpotlight().attemptsTo(
                CreateEmployeeTask.createEmployee(ConverterJson.converter(employee))
        );
    }

    @Then("verify the create new record in database")
    public void verifyTheCreateNewRecordInDatabase(List<List<String>> dataEmployee) {
        JsonPath responseJson = JsonPath.given(lastResponse().getBody().asString());
        assertThat(lastResponse().getStatusCode()).isEqualTo(200);
        assertThat(responseJson.getString("message")).isEqualTo(dataEmployee.get(0).get(0));
    }

    @When("employee records are consulted")
    public void employeeRecordsAreConsulted() {
        theActorInTheSpotlight().attemptsTo(
                ConsultAllEmployeesTask.consultEmployees()
        );
    }

    @When("employee's record is consulted")
    public void employeeSRecordIsConsulted(List<List<String>> dataEmployee) {
        theActorInTheSpotlight().attemptsTo(
                ConsultEmployeeTask.consultEmployee(dataEmployee.get(0).get(0))
        );
    }

    @When("employee information is modified")
    public void employeeInformationIsModified(List<List<String>> dataEmployee) {
        employee = new EmployeeModel(dataEmployee.get(0));
        theActorInTheSpotlight().attemptsTo(
                UpdateEmployeeTask.updateEmployee(ConverterJson.converter(employee), dataEmployee.get(0).get(0))
        );
    }

    @When("employee registration is eliminated")
    public void employeeRegistrationIsEliminated(List<List<String>> dataEmployee) {
        theActorInTheSpotlight().attemptsTo(
                DeleteEmployeeTask.deleteEmployee(dataEmployee.get(0).get(0))
        );
    }

    @Then("verify service response")
    public void verifyServiceResponse(List<List<String>> dataEmployee) {
        JsonPath responseJson = JsonPath.given(lastResponse().getBody().asString());
        assertThat(lastResponse().getStatusCode()).isEqualTo(200);
        assertThat(responseJson.getString("message")).isEqualTo(dataEmployee.get(0).get(0));
    }
}
