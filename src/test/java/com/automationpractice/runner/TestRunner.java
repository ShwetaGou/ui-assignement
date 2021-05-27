package com.automationpractice.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Features", glue = {
		"com.automationpractice.stepdefinations" },  tags="@smoketest",monochrome = true, plugin = { "pretty",
				"html:target\\HtmlReports" , "json:target/cucumber-reports/cucumber.json"})
public class TestRunner {

}
 