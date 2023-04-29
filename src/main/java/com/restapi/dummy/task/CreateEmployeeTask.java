package com.restapi.dummy.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static com.restapi.dummy.utils.enums.RestServiceEnum.URI_CREATE_EMPLOYEE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateEmployeeTask implements Task {
    private String employeeJson;

    public CreateEmployeeTask(String employeeJson) {
        this.employeeJson = employeeJson;
    }

    public static CreateEmployeeTask createEmployee(String employeeJson) {
        return instrumented(CreateEmployeeTask.class, employeeJson);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(URI_CREATE_EMPLOYEE.toString())
                        .with(request -> request
                                .header("Content-Type", "application/json")
                                .body(employeeJson))
        );
    }
}
