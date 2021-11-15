package com.hrms.stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmployeeStepDEfinitions extends CommonMethods {

	@Then("navigate to add employee page")
	public void navigate_to_add_employee_page() {
		click(dash.pimLinkBtn);
		click(dash.addEmpBtn);

	}

	@Then("enter first and last name")
	public void enter_first_and_last_name() {
		sendText(addEmp.firstNameField, "John");
		sendText(addEmp.lastNameField, "Wick");

	}

	@Then("click on save Button")
	public void click_on_save_Button() {
		click(addEmp.saveButton);

	}

	@Then("verify the employee is added succesfully")
	public void verify_the_employee_is_added_succesfully() {
		String profileName = persDetails.profileName.getText();
		Assert.assertEquals("John Wick", profileName);
	}

	@Then("verify that {string} is added succesfully")
	public void verify_that_is_added_succesfully(String fullName) {
		String profileName = persDetails.profileName.getText();
		Assert.assertEquals(fullName, profileName);
	}

	@When("enter employee {string} {string} and {string}")
	public void enters_employee_and(String firstName, String middleName, String lastName) {
		sendText(addEmp.firstNameField, firstName);
		sendText(addEmp.middleName, middleName);
		sendText(addEmp.lastNameField, lastName);

	}

	@When("add multiple employees and verify thea added")
	public void add_multiple_employees_and_verify_thea_added() {
		List<Map<String, String>> employeeNames = employees.asMaps();

		for (Map<String, String> employeeName : employeeNames) {
			employeeName.get("First Name");
			String firstName = employeeName.get("First Name");
			String middleName = employeeName.get("Middle Name");
			String lastName = employeeName.get("last Name");
			String empId = employeeName.get("Employee ID");
			
			sendText(addEmp.firstNameField, firstName);
			sendText(addEmp.middleName, middleName);
			sendText(addEmp.lastNameField, lastName);
			sendText(addEmp.idField, empId);
			
			click(addEmp.saveButton);
			String actualName = persDetails.profileName.getText();
			String expectedName = firstName +" "+middleName+" "+lastName;
			Assert.assertEquals("Verifying employee names", expectedName, actualName);
			click(dash.addEmpBtn);
			Thread.sleep(4000);
		}
			
		}
		@When("add multiple employees from {string}and verify they are added successfully")
	    public void add_multiple_employees_from_verify_they_are_added_successfully(String sheetName) {
	        List<Map<String, String>> exeldata =  ExcelUtility.excelToListMap(Constants.TESTDATA_FILEPATH, sheetName);
	        
	        for(Map<String, String> excelEmpName : exeldata){
	            String firstName = excelEmpName.get("firstName");
	            String middleName = excelEmpName.get("middleName");
	            String lastName = excelEmpName.get("lastName");
	            String empId = excelEmpName.get("Employee ID");
	            
	            sendText(addEmp.firstNameField, firstName);
	            sendText(addEmp.middleName,middleName);
	            sendText(addEmp.lastNameField, lastName);
	            click(addEmp.saveButton);

	          String actualName = persDetails.profileName.getText();
	          String expectedName =firstName+" "+ middleName +" "+ lastName;
	          Assert.assertEquals("Verifying employee names", expectedName, actualName);
	          jsClick(dash.addEmpBtn);

	        }

	}
}
