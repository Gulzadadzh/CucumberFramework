package com.hrms.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/FailedTests.txt", 
				glue = "com/hrms/stepDefinitions", 
				monochrome = true, 
				plugin = {"pretty", 
						"html:target/cucumber-default-reports", 
						"rerun:target/FailedTests.txt"}) 
public class FailedRunner {
	
}