package com.saucelab.sort;

import org.testng.annotations.Test;

import commons.BaseTest;

import pageObjects.sauceLab.LoginPageObject;
import pageObjects.sauceLab.PageGeneratorManager;
import pageObjects.sauceLab.ProductPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_19_Sort_Asc_Desc extends BaseTest {

	@Parameters({"browser","appUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		loginPage.enterToUsernameTextbox("standard_user");
		loginPage.enterToPasswordTextbox("secret_sauce");
		productPage = loginPage.clickToLoginButton();
	}

	@Test
	public void Sort_01_Name() {
		// Ascending
		productPage.selectItemInProductSortDropdown("Name (A to Z)");
		productPage.sleepInSecond(3);
		
		//Assert.assertTrue(productPage.isProductNameSortByAscending());
		
		Assert.assertTrue(productPage.isProductNameSortByAscendingLambda());
		
		// Descending
		productPage.selectItemInProductSortDropdown("Name (Z to A)");
		productPage.sleepInSecond(3);
		
		//Assert.assertTrue(productPage.isProductNameSortByDescending());
		
		Assert.assertTrue(productPage.isProductNameSortByDescendingLambda());
	}

	@Test
	public void Sort_02_Price() {
		// Ascending
		productPage.selectItemInProductSortDropdown("Price (low to high)");
		productPage.sleepInSecond(3);
		
		//Assert.assertTrue(productPage.isProductPriceSortByAscending());
		Assert.assertTrue(productPage.isProductPriceSortByAscendingNew(driver));
		
		// Descending
		productPage.selectItemInProductSortDropdown("Price (high to low)");
		productPage.sleepInSecond(3);
		
		//Assert.assertTrue(productPage.isProductPriceSortByDescending());
		Assert.assertTrue(productPage.isProductPriceSortByDescendingNew(driver));
	}

	@Parameters({"envName"})
	@AfterClass(alwaysRun = true)
	public void afterClass(String envName) {
		closeBrowserDriver(envName);
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	
	WebDriver driver;
	LoginPageObject loginPage;
	ProductPageObject productPage;

}
