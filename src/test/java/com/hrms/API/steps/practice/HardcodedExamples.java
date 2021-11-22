package com.hrms.API.steps.practice;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class HardcodedExamples {

	/*
	 * REST Assured - Java library specifically developed to automate REST endpoints
	 * 
	 * Given - Preparing your request Wnen - What action will you perform, what type
	 * of call are you making? Then -Verification
	 * 
	 */
	@Test
	public void sampleTest() {
		// BaseURI for all endpoints
		RestAssured.baseURI = "3.237.189.167/syntaxApi/api";

		// JWT
		String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2Mzc2MDIxNzAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYzNzY0NTM3MCwidXNlcklkIjoiMjE5OSJ9._q0QsJQDwQJbz-CIxHCTvD4VeE0UjJgxhJUXekY6jws";

		// Preparing request for /getOneEmployee.php
		//Using .log.all to print out everything being sent with the request
		RequestSpecification preparingGetOneEmployeeRequest = given().header("Authorization", token)
				.header("Content-Type", "application/json").queryParam("employee-id", "2033783320").log().all();

		//Making call to /getOneEmployee.php
		Response getOneEmployeeResponse = preparingGetOneEmployeeRequest.when().get("/getOneEmployee.php");
		
		//One way to print response object
		System.out.println(getOneEmployeeResponse.asString());
		
		//Second way using rest assured prettyPrint()
		getOneEmployeeResponse.prettyPrint();
		
		
		
	}

}
