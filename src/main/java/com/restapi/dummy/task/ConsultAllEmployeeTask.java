package com.restapi.dummy.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static com.restapi.dummy.utils.enums.RestServiceEnum.URI_CONSULT_USERS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultAllEmployeeTask implements Task {

    public static ConsultAllEmployeeTask consultEmployee() {
        return instrumented(ConsultAllEmployeeTask.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(URI_CONSULT_USERS.toString())
        );
    }
}
