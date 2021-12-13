package com.hrms.API.Final.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;

import com.hrms.utils.APICommonMethods;
import com.hrms.utils.APIConstants;
import com.hrms.utils.CommonMethods;

public class APIFinalSteps {
	
	
	RequestSpecification request;
	Response response;
	String BaseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
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
		request = APICommonMethods.createEmployeeRequest(GenerateTokenSteps.token,
				CommonMethods.readJson(APIConstants.CREATE_EMPLOYEE_JSON));
	}

	@When("a POST call is made to create an employee")
	public void a_POST_call_is_made_to_create_an_employee() {
		response = request.when().post(APIConstants.CREATE_EMPLOYEE_URI);
		response.prettyPrint();
	}

	@Then("the status code for creating an employee is {int}")
	public void the_status_code_for_creating_an_employee_is(int statusCode) {
		response.then().assertThat().statusCode(statusCode);
	}

	@Then("the employee is created contains key {string} and value {string}")
	public void the_employee_is_created_contains_key_and_value(String key, String value) {
		response.then().assertThat().body(key, equalTo(value));
	}

	@Then("the employee ID {string} is stored as a global variable to be used for other calls")
	public void the_employee_ID_is_stored_as_a_global_variable_to_be_used_for_other_calls(String value) {
		employeeID = response.jsonPath().getString(value);
	}

	@Given("a request is prepared to retreive the created employee")
	public void a_request_is_prepared_to_retreive_the_created_employee() {
		request = APICommonMethods.getEmployeeRequest(GenerateTokenSteps.token, employeeID);
	}

	@When("a GET call is made to retreive the created employee")
	public void a_GET_call_is_made_to_retreive_the_created_employee() {
		response = request.when().get(APIConstants.GET_ONE_EMPLOYEE_URI);
	}

	@Then("the status code for retreiving the created employee is {int}")
	public void the_status_code_for_retreiving_the_created_employee_is(int statusCodeForRetreivingEmployee) {
		response.then().assertThat().statusCode(statusCodeForRetreivingEmployee);
	}

	@Then("the retreived employee ID {string} matches the globally stored employee ID")
	public void the_retreived_employee_ID_matches_the_globally_stored_employee_ID(String retreivedEmployeeID) {
		response.then().assertThat().body(retreivedEmployeeID, equalTo(employeeID));
	}

	@Then("the retrieved data at {string} matches the data used to create an employee with employee ID {string}")
	public void the_retrieved_data_at_matches_the_data_used_to_create_an_employee_with_employee_ID(
			String employeeObject, String responseEmployeeID, DataTable dataTable) {
		List<Map<String, String>> expectedData = dataTable.asMaps(String.class, String.class);
		List<Map<String, String>> actualData = response.body().jsonPath().get(employeeObject);

		int index = 0;
		for (Map<String, String> map : expectedData) {
			Set<String> keys = map.keySet();
			for (String key : keys) {
				String expectedValue = map.get(key);
				String actualValue = actualData.get(index).get(key);
				Assert.assertEquals(expectedValue, actualValue);
			}
			index++;
		}
		String empID = response.body().jsonPath().getString(responseEmployeeID);
		Assert.assertTrue(empID.contentEquals(employeeID));
	}

	@Given("a request is prepared to retreive all employee")
	public void a_request_is_prepared_to_retreive_all_employee() {
		request = APICommonMethods.getAllEmployeesRequest(GenerateTokenSteps.token);
	}

	@When("a GET call is made to retreive all employees")
	public void a_GET_call_is_made_to_retreive_all_employees() {
		response = request.when().get(APIConstants.GET_ALL_EMPLOYEES_URI);
	}

	@Then("the status code for retreiving all employees is {int}")
	public void the_status_code_for_retreiving_all_employees_is(int expectedStatusCode) {
		response.then().assertThat().statusCode(expectedStatusCode);
	}

	@Then("the retreived data {string} contains the globally stored employee ID")
	public void the_retreived_data_contains_the_globally_stored_employee_ID(String employeeObject) {
		List<Map<String, String>> actualData = response.body().jsonPath().get(employeeObject);
		System.out.println(actualData.size());
		String actualEmployeeID = null;
		for (int i = 0; i < actualData.size(); i++) {
			actualEmployeeID = response.body().jsonPath().getString("Employees[" + i + "].employee_id");
			if (actualEmployeeID.equals(employeeID)) {
				System.out.println("Employee ID is inside");
				break;
			}
		}
		Assert.assertEquals(employeeID, actualEmployeeID);
	}

	@Then("the retreived data matches the data that was used to create an employee")
	public void the_retreived_data_matches_the_data_that_was_used_to_create_an_employee() {
	}
}