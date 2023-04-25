package com.restapi.dummy.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static com.restapi.dummy.utils.enums.RestServiceEnum.URI_CONSULT_EMPLOYEE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsulEmployeeTask implements Task {
    private String idEmployee;

    public ConsulEmployeeTask(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public static ConsulEmployeeTask consultEmployee(String idEmployee) {
        return instrumented(ConsulEmployeeTask.class, idEmployee);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(URI_CONSULT_EMPLOYEE + "/" + idEmployee)
        );
    }
}