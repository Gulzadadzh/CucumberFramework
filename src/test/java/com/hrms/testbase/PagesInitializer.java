package com.hrms.testbase;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.EmployeeListPageElements;
import com.hrms.pages.LoginPageElements;
//import com.hrms.utils.APICommonMethods;

public class PagesInitializer extends BaseClass {

	protected static LoginPageElements login;
	protected static AddEmployeePageElements addEmp;
	protected static DashboardPageElements dashboard;
	protected static EmployeeListPageElements empList;
	//protected static APICommonMethods apiMethods;

	public static void initializePageObjects() {
		login = new LoginPageElements();
		addEmp = new AddEmployeePageElements();
		dashboard = new DashboardPageElements();
		empList = new EmployeeListPageElements();
		//apiMethods = new APICommonMethods();
	}

}