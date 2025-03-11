package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = "com.stepdefination",
	    plugin = {"pretty", "json:target/cucumber-reports-json/Cucumber.json"},
	    tags = "@LoginTest"
	)

public class InternetLogin extends AbstractTestNGCucumberTests{

}
