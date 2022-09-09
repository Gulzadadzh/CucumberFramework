package com.hrms.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/", 
				glue = "com/hrms/API/Final/steps", 
				dryRun = false, 
				monochrome = true, 
				tags = "@APIworkflow", 
				//strict = false, 
				plugin = {"pretty", 
						"html:target/cucumber-default-reports", 
						"rerun:target/FailedTests.txt", 
						"json:target/cucumber.json"}) 
public class APIRunner {
	
}