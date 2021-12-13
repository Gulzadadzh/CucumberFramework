package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class pract {
	
	String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
	String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2Mzg1MzYzMTQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYzODU3OTUxNCwidXNlcklkIjoiMjE5OSJ9.FYMptLkSGQia4lyvGMDF7D4kKKP25c2zPUZimsVnDrM";
	static String employeeID;
	
	

	@Test
	public void sampleTest() {

		// BaseURI for all endpoints

		// JWT

		/** Preparing request for /getOneEmployee.php */
		/** Using .log().all() to print out everything being sent with the request */
		RequestSpecification prepairingGetOneEmployeeRequest = given().header("Authorization", token)
				.header("Content-Type", "application-json").queryParam("employee_id", "25213A").log().all();

		/** Making call to /getOneEmployee.php */
		Response getOneEmployeeResponse = prepairingGetOneEmployeeRequest.when().get("/getOneEmployee.php");

		/** One way to print response object */
		System.out.println(getOneEmployeeResponse.asString());

		/** Second way to print response object using rest assured prettyPrint() */
		getOneEmployeeResponse.prettyPrint();

		/** Using assertThat() to verify status code */
		getOneEmployeeResponse.then().assertThat().statusCode(200);

	}

	}

