package com.hrms.pages;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class DashboardPageElements extends BaseClass {

	@FindBy(id = "menu_admin_viewAdminModule")
	public WebElement admin;

	@FindBy(id = "menu_pim_viewPimModule")
	public WebElement pim;

	@FindBy(id = "menu_leave_viewLeaveModule")
	public WebElement leave;

	@FindBy(id = "menu_time_viewTimeModule")
	public WebElement time;

	@FindBy(id = "menu_recruitment_viewRecruitmentModule")
	public WebElement recruitment;

	@FindBy(id = "menu__Performance")
	public WebElement performance;

	@FindBy(id = "menu_directory_viewDirectory")
	public WebElement directory;

	@FindBy(id = "welcome")
	public WebElement welcomeMsg;

	@FindBy(xpath = "//div[@class='menu']/ul/li")
	public List<WebElement> dashTabs;

	public DashboardPageElements() {
		PageFactory.initElements(driver, this);
	}

}