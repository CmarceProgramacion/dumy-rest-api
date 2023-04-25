package com.restapi.dummy.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static com.restapi.dummy.utils.enums.RestServiceEnum.BASE_URL;
import static com.restapi.dummy.utils.enums.RestServiceEnum.URI_UPDATE_EMPLOYEE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UpdateEmployeeTask implements Task {

    private String employeeJson;
    private String idEmployee;

    public UpdateEmployeeTask(String employeeJson, String idEmployee) {
        this.employeeJson = employeeJson;
        this.idEmployee = idEmployee;
    }

    public static UpdateEmployeeTask updateEmployee(String employeeJson, String idEmployee) {
        return instrumented(UpdateEmployeeTask.class, employeeJson, idEmployee);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("empleado " + employeeJson + "base url" + BASE_URL.toString() + "" + URI_UPDATE_EMPLOYEE + idEmployee);
        actor.attemptsTo(
                Put.to(URI_UPDATE_EMPLOYEE + idEmployee)
                        .with(request -> request
                                .header("Content-Type", "application/json")
                                .body(employeeJson))
        );
    }
}
