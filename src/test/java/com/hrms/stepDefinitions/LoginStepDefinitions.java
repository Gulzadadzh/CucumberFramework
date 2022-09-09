package com.hrms.stepDefinitions;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions extends CommonMethods {

	@Given("go to HRMS login page")
	public void go_to_HRMS_login_page() {
		login.login();
	}

	@When("verify the dashboard is displayed")
	public void verify_the_dashboard_is_displayed() {
		Assert.assertTrue(dashboard.welcomeMsg.isDisplayed());
	}

	@When("login with invalid credentials")
	public void login_with_invalid_credentials() {
		login.login("Admin", "Password");
	}

	@Then("varify the error message")
	public void varify_the_error_message() {
		Assert.assertEquals(login.ERROR_MESSAGE_INVALID_CREDENTIALS, login.errorMsg.getText());
	}

	@Then("quit the browser")
	public void quit_the_browser() {
	}
}