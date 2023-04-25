package com.restapi.dummy.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/crud_employee.feature",
        glue = "com.restapi.dummy",
        tags = "@CasePut",
        plugin = {"pretty"},
        snippets = CucumberOptions.SnippetType.CAMELCASE)

public class CrudEmployeeRunner {
}
