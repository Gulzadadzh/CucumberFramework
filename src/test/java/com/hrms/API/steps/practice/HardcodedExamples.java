package com.hrms.API.steps.practice;

import org.junit.Assert;
import org.junit.Test;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class HardcodedExamples {

	/*
	 * REST Assured - Java library specifically developed to automate REST endpoints
	 * 
	 * Given - Preparing your request Wnen - What action will you perform, what type
	 * of call are you making? Then -Verification
	 * 
	 */
	String baseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2Mzc2ODAzMDQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYzNzcyMzUwNCwidXNlcklkIjoiMjE5OSJ9.F78VAx9_xV315iD_gZ09BKAm4RIUTc2WezhPzdIaNi8";
	static String employeeID;

	//@Test
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


	
	public void aPOSTcreateEmployee() {

			/** Preparing request for creating an employee */
			RequestSpecification createEmployeeRequest = given().header("Authorization", token)
					.header("Content-Type", "application/json")
					.body("{\n"
							+ "    \"emp_firstname\": \"Masha\",\n"
							+ "    \"emp_lastname\": \"Medved\",\n"
							+ "    \"emp_middle_name\": \"And\",\n"
							+ "    \"emp_gender\": \"F\",\n"
							+ "    \"emp_birthday\": \"2016-09-21\",\n"
							+ "    \"emp_status\": \"Employee\",\n"
							+ "    \"emp_job_title\": \"Cloud Architect\"\n"
							+ "\n"
							+ "}");
					//.log().all();

			/** Making call to /createEmployee.php */
			Response createEmployeeResponse = createEmployeeRequest.when().post("/createEmployee.php");
			/** Printing response */
      		createEmployeeResponse.prettyPrint();

			/**
			 * Using jsonPath() to viuw the response body which lets us get the employee ID
			 * We are storing the emloyee ID as a static global variable to be able to use
			 * woth other calls
			 */
      		createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");
      		
      		/** Optional: Printing employeeID */
      		System.out.println(employeeID);
      		
      		/**
      		 * Verifying response body "Message" is paired with "Employee Created";
      		 * equalTo() method comes from static Hamcrest package - NEED TO IMPORT MANUALLY 
      		 * import static org.hamcrest.Matchers.*; */
      		createEmployeeResponse.then().assertThat().body("Message", equalTo("Employee Created"));
      		
      		
      		/**Verifying created employee first name */
      		createEmployeeResponse.then().assertThat().body("Employee.emp_firstname", equalTo("Masha"));
      		
      		/** Verifying server Apache/2.4.39 (Win64) PHP/7.2.18*/
      		createEmployeeResponse.then().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");
      		
		
		
		
		
		
	}


	@Test
	public void bGETcreateEmployee() {
		
		/** Preparing request to get created employee */
	RequestSpecification getCreatedEmployeeRequest=given().header("Content-type", "application/json")
			.header("Authorithation", token).queryParam("employee_id", employeeID);
	
	
	/** Storing response for retrieving created employee */
	Response getCreatedEmployeeResponse = getCreatedEmployeeRequest.when().get("/getOneEmployee.php");
	
	
	/** Printing response */
	getCreatedEmployeeResponse.prettyPrint();
	
	/** Storing response employee ID into empID to compare with static global employee ID*/
	String empID = getCreatedEmployeeResponse.body().jsonPath().getString("employee.employee_id");	
	
	/** Comparing empID with stored employeeID from created employee call*/
	boolean verifyingEmployeeID = empID.equalsIgnoreCase(employeeID);
	
	/** Asserting to verify the above condition is true */
	Assert.assertTrue(verifyingEmployeeID);
	
	/** Verifying status code is 200 */
	getCreatedEmployeeResponse.then().assertThat().statusCode(200);
	
	
	
	
	}
	







}
