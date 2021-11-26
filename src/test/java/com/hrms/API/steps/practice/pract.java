package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class pract {
	
	String baseURI = RestAssured.baseURI = "hrm.syntaxtechs.net/syntaxapi/api";
	String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2Mzc3ODUxNTMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYzNzgyODM1MywidXNlcklkIjoiMjE5OSJ9.3tmXRC-KdylLdg0dy00jYA7cdAOLyXzWW8px24p1NGc";	
	static String employeeID;
	
	

	@Test
	public void sampleTest() {

		// BaseURI for all endpoints

		// JWT

		/** Preparing request for /getOneEmployee.php */
		/** Using .log().all() to print out everything being sent with the request */
		RequestSpecification prepairingGetOneEmployeeRequest = given().header("Authorization", token)
				.header("Content-Type", "application-json").queryParam("employee_id", "8625").log().all();

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

