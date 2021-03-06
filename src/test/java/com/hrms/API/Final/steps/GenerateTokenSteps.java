package com.hrms.API.Final.steps;

import com.hrms.utils.CommonMethods;


import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class GenerateTokenSteps {
	
	String BaseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
	public static String token;

	@Given("a JWT is generated")
	public void a_JWT_is_generated() {
		
		/** Preparing request to generate token */
		//RequestSpecification generateTokenRequest = given().header("Content-type", "application/json").body("{\n"
		//    "email": "dzhusukeeva@gmail.com",
		//    "password": "1994Gulya@"
		//			+ "}");
		//		.generateTokenRequest(CommonMethods.readJson(APIConstants.GENERATE_TOKEN_JSON));

		/** Storing response into generateTokenResponse */
		//Response generateTokenResponse = generateTokenRequest.when().post(APIConstants.GENERATE_TOKEN_URI);

		/** Optional to print response */
		//generateTokenResponse.prettyPrint();

		/**
		 * Storing token as a static global variable that will be used for other calls
		 */
		//token = "Bearer " + generateTokenResponse.jsonPath().getString("token");

	}
}


