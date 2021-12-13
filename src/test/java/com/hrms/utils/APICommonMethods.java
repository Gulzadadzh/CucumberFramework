package com.hrms.utils;

import static io.restassured.RestAssured.given;

import org.apache.http.entity.ContentType;

import com.hrms.API.Final.steps.GenerateTokenSteps;

import io.restassured.specification.RequestSpecification;

public class APICommonMethods extends CommonMethods{

	/**
	 * Use this method to create an employee Pass below parameters
	 * 
	 * @param token
	 * @param createEmployeeBody
	 * @return
	 */
	public static RequestSpecification createEmployeeRequest(String token, String createEmployeeBody) {

		return given().header("Authorization", token).header("Content-Type", "application/json")
				.body(createEmployeeBody);
	}

	/**
	 * Use this method to GET an employee
	 * 
	 * @param token
	 * @param employeeID
	 * @return
	 */
	public static RequestSpecification getEmployeeRequest(String token, String employeeID) {
		return given().header("Content-Type", ContentType.APPLICATION_JSON).header("Authorization", token)
				.param("employee_id", employeeID);
	}

	/**
	 * Use this method to generate a token
	 * 
	 * @param generateTokenBody
	 * @return
	 */
	public static RequestSpecification generateTokenRequest(String generateTokenBody) {
		return given().header("Content-Type", "application/json").body(generateTokenBody);
	}

	/**
	 * Use this method to GET all employees
	 * 
	 * @param token
	 * @return
	 */
	public static RequestSpecification getAllEmployeesRequest(String token) {
		return given().header("Content-Type", ContentType.APPLICATION_JSON).header("Authorization", token).log().all();
	}
}