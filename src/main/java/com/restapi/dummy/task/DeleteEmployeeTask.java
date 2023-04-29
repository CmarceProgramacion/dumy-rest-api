package com.restapi.dummy.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static com.restapi.dummy.utils.enums.RestServiceEnum.URI_DELETE_EMPLOYEE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteEmployeeTask implements Task {
    private String idEmployee;

    public DeleteEmployeeTask(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public static DeleteEmployeeTask deleteEmployee(String idEmployee) {
        return instrumented(DeleteEmployeeTask.class, idEmployee);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(URI_DELETE_EMPLOYEE + idEmployee)
        );

    }
}
