package com.facebook.register;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManager;
import pageObject.jQuery.uploadFile.HomePageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_13_Element_Undisplayed extends BaseTest{
	WebDriver driver; //Neu ko dung Thread local thì comment dong nay lai cung duoc, con neu co Thread local thì phai dung toi no
	private LoginPageObject loginPage;
	
	@Parameters({"browser", "url"})     
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		driver = getBrowserDriver(browserName, appURL);
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}
  
	@Test
	public void TC_01_Verify_Element_Displayed() {
		loginPage.clickToCreateNewAccountButton();
		
		// Nếu 1 cái hàm chỉ mong đợi để verify element displayed thôi - kết hợp cả wait + isDisplayed
		// waitForElementVisible
		// isElementDisplayed
		//verifyTrue(loginPage.isEmailAddressTextboxDisplayed());
		
		// Verify True - mong đợi Confirm Email displayed (true)
		loginPage.enterToEmailAddressTextbox("automationfc@gmail.com");
		loginPage.sleepInSecond(3);
		verifyTrue(loginPage.isConfirmEmailAddressTextboxDisplayed());
		
	}
	
	@Test
	public void TC_02_Verify_Element_Undisplayed_In_DOM() {
		// Nếu như mình mong đợi 1 cái hàm vừa verify displayed/ undisplayed thì ko được kết hợp wait 
		// isElementDisplayed
		
		// Verify False - mong đợi Confirm Email Undisplayed (false)
		loginPage.enterToEmailAddressTextbox("");
		loginPage.sleepInSecond(3);
		//verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed());
		
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
		
	}
	
	@Test
	public void TC_03_Verify_Element_Undisplayed_Not_In_DOM() {
		loginPage.clickCloseIconAtRegisterForm();
		loginPage.sleepInSecond(3);
		
		// Khi close cái form Register đi thì Confirm Email ko còn trong DOM nữa 
		// Nên hàm findElement sẽ bị fail vì ko tìm thấy element
		// 1 - Nó sẽ chờ hết timeout của implicit: 30s
		// 2 - Nó sẽ đánh fail testcase tại đúng step này luôn
		// 3 - Ko có chạy các step còn lại nữa
		
		// Verify False mong đợi Confirm Email Undisplayed (false)
		// isDisplayed: bản chất ko kiểm tra 1 element ko có trong DOM được
		//verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed());
		
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
  
	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
