package com.hrms.stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.hrms.utils.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class DashboardStepDefinitions extends CommonMethods{

	@Then("verify the folloving dashboard tabs")
	public void verify_the_following_dashboard_tabs(DataTable dataTable) {
		List<String> expectedDashTabs = dataTable.asList();
		List<String> actualDashTabs = new ArrayList<String>();

		for (WebElement dashTab : dash.DashTabs) {
			actualDashTabs.add(dashTab.getText());
		}
		System.out.println(actualDashTabs);
		System.out.println(expectedDashTabs);

		Assert.assertTrue(expectedDashTabs.equals(actualDashTabs));
	}

}
