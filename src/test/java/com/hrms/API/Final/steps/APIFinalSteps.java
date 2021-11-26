package com.hrms.API.Final.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIFinalSteps {
	
	
	RequestSpecification request;
	Response response;
//	String BaseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	static String employeeID;

	@Given("a request is prepared to create an employee")
	public void a_request_is_prepared_to_create_an_employee() {
//		/** First way to send a payload with request */
////		request = given().header("Content-Type", "application/json").header("Authorization", GenerateTokenSteps.token)
////				.body(APIPayloadCommonMethods.createEmployeePayload()).log().all();
//		/** Second way */
//		request = given().header("Authorization", GenerateTokenSteps.token).header("Content-Type", "application/json")
//				.body(CommonMethods.readJson(APIConstants.CREATE_EMPLOYEE_JSON));
//		/** Third way - hardcoding */
		/**
		 * Using createEmployeeRequest() common method which creates a request by
		 * passing expected parameters
		 */
//		request = APICommonMethods.createEmployeeRequest(GenerateTokenSteps.token,
//				APIPayloadCommonMethods.createEmployeePayload());
		//request = APICommonMethods.createEmployeeRequest(GenerateTokenSteps.token,
			//	CommonMethods.readJson(APIConstants.CREATE_EMPLOYEE_JSON));
	}

}