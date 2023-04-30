package com.restapi.dummy.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static com.restapi.dummy.utils.enums.RestServiceEnum.URI_CONSULT_EMPLOYEES;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultAllEmployeesTask implements Task {

    public static ConsultAllEmployeesTask consultEmployees() {
        return instrumented(ConsultAllEmployeesTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(URI_CONSULT_EMPLOYEES.toString())
        );
    }
}
