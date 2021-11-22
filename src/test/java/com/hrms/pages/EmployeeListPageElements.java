package com.hrms.pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class EmployeeListPageElements extends BaseClass {

	@FindBy(id = "menu_pim_viewEmployeeList")
	public WebElement empList;

	@FindBy(id = "empsearch_id")
	public WebElement id;

	@FindBy(id = "searchBtn")
	public WebElement searchBtn;

	@FindBy(id = "empsearch_employee_name_empName")
	public WebElement empName;

	@FindBy(xpath = "//table[@id='resultTable']/tbody/tr")
	public List<WebElement> empListRows;

	@FindBy(xpath = "//table[@id='resultTable']/tbody/tr/td[2]")
	public List<WebElement> IDs;

	@FindBy(xpath = "//table[@id='resultTable']/tbody/tr/td[1]")
	public List<WebElement> CheckBoxes;

	@FindBy(id = "btnDelete")
	public WebElement deleteBtn;

	@FindBy(id = "dialogDeleteBtn")
	public WebElement okBtn;

	@FindBy(xpath = "(//a[text()='Next'])[1]")
	public WebElement nextBtn;

	@FindBy(xpath = "//table[@id = 'resultTable']")
	public WebElement resultTable;

	@FindBy(xpath = "//table[@id = 'resultTable']/tbody/tr/td[3]")
	public List<WebElement> searchResultFirstName;

	public boolean isTableDisplayed() {
		return resultTable.isDisplayed();
	}

	public List<Map<String, String>> getFirstNameFromTable() {
		List<Map<String, String>> uiFirstNames = new ArrayList<>();
		for (WebElement firstNameRow : searchResultFirstName) {
			Map<String, String> mapData = new LinkedHashMap<>();
			String tableName = firstNameRow.getText();
			mapData.put("emp_firstname", tableName);
			uiFirstNames.add(mapData);
		}
		return uiFirstNames;
	}

	public EmployeeListPageElements() {
		PageFactory.initElements(driver, this);
	}

}