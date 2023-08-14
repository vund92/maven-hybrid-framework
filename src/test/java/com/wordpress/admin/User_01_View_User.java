package com.wordpress.admin;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import pageObjects.wordpress.AdminDashboardPO;
import pageObjects.wordpress.AdminLoginPO;
import pageObjects.wordpress.AdminUserPO;
import pageObjects.wordpress.PageGeneratorManager;

@Epic("Regression Tests")
@Feature("Wordpress-Admin Tests")
public class User_01_View_User extends BaseTest {
	
	String adminUsername = "automationfc";
	String adminPassword = "automationfc";

	@Parameters({ "browser", "urlAdmin" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl) {
		log.info("Pre-Condition - Step 01: Open browser and admin Url"); 
		driver = getBrowserDriver (browserName, adminUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		showBrowserConsoleLogs(driver);
		
		log.info("Pre-Condition Step 02: Enter to Username textbox with value: " + adminUsername);
		adminLoginPage.enterToUsernameTextbox(adminUsername);
		
		log.info("Pre-Condition - Step 03: Enter to Password textbox with value:  " + adminPassword);
		adminLoginPage.enterToPasswordTextbox(adminPassword);
		
		log.info("Pre-Condition Step 04: Click to Login button");
		adminDashboardPage = adminLoginPage.clickToLoginButton();
	}
	
	@Test
	public void TC_01_View_User() {
		log.info("View_User Step 01: Click to 'User' menu link");
		adminUserPage = adminDashboardPage.clickToUserMenuLink();
		
		log.info("View_User Step 02: Get all users from UI");
		int totalNumberUserAtUI = adminUserPage.getUserNumberAtUI();
		
		log.info("View_User Step 03: Get all users from DB");
		int totalNumberUserAtDB = adminUserPage.getUserNumberAtDB();
		
		log.info("View_User - Step 04: Verify the User are matching");
		verifyEquals(totalNumberUserAtUI, totalNumberUserAtDB);

	}
	
	@Parameters({"envName"})
	@AfterClass(alwaysRun = true)
	public void afterClass(String envName) {
		closeBrowserDriver(envName);
	}
	
	WebDriver driver;
	AdminLoginPO adminLoginPage;
	AdminDashboardPO adminDashboardPage;
	AdminUserPO adminUserPage;
	
}
