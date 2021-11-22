package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class LoginPageElements extends BaseClass {
	@FindBy(id = "txtUsername")
	public static WebElement usernameTextBox;

	@FindBy(id = "txtPassword")
	public static WebElement passwordTextBox;

	@FindBy(id = "btnLogin")
	public static WebElement loginBtn;

	@FindBy(id = "spanMessage")
	public WebElement errorMsg;
	
	public void login() {
		CommonMethods.sendText(usernameTextBox, ConfigsReader.getPropValue("username"));
		CommonMethods.sendText(passwordTextBox, ConfigsReader.getPropValue("password"));
		CommonMethods.click(loginBtn);
	}
	
	public static void login(String username, String password) {
		CommonMethods.sendText(usernameTextBox, username);
		CommonMethods.sendText(passwordTextBox, password);
		CommonMethods.click(loginBtn);
	}

	public static final String ERROR_MESSAGE_BLANK_USERNAME = "Username cannot be empty";
	public static final String ERROR_MESSAGE_BLANK_PASSWORD = "Password cannot be empty";
	public static final String ERROR_MESSAGE_INVALID_PASSWORD = "Invalid credentials";
	public static final String ERROR_MESSAGE_INVALID_CREDENTIALS = "Invalid credentials";

	public LoginPageElements() {
		PageFactory.initElements(driver, this);
	}
}