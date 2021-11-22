package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class AddEmployeePageElements extends BaseClass {
	
	@FindBy(xpath = "//input[@name='chkLogin']")
	public WebElement loginDetailsCheckbox;

	@FindBy(xpath = "//a[@id='menu_pim_addEmployee']")
	public WebElement addEmpBtn;

	@FindBy(id = "firstName")
	public WebElement firstNameTextBox;

	@FindBy(id = "lastName")
	public WebElement lastNameTextBox;

	@FindBy(id = "user_name")
	public WebElement usernameTextBox;

	@FindBy(id = "user_password")
	public WebElement passwordTextBox;

	@FindBy(id = "employeeId")
	public WebElement empId;

	@FindBy(id = "middleName")
	public WebElement middleName;

	@FindBy(id = "btnSave")
	public WebElement saveBtn;

	@FindBy(xpath = "//div[@id='profile-pic']/h1")
	public WebElement FullName;

	@FindBy(id = "re_password")
	public WebElement confirmPasswordBtn;

	@FindBy(xpath = "//div[@id='profile-pic']/h1")
	public WebElement empInfo;

	public AddEmployeePageElements() {
		PageFactory.initElements(driver, this);
	}
}