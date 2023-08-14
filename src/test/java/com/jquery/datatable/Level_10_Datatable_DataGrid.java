package com.jquery.datatable;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.dataTable.HomePageObject;
import pageObject.jQuery.dataTable.PageGeneratorManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_10_Datatable_DataGrid extends BaseTest{
	WebDriver driver; //Neu ko dung Thread local thì comment dong nay lai cung duoc, con neu co Thread local thì phai dung toi no
	HomePageObject homePage;
	List<String> actualAllCountryValues;
	List<String> expectedAllCountryValues;

	@Parameters({"browser", "url"})     
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		driver = getBrowserDriver(browserName, appURL);
		homePage = PageGeneratorManager.getHomePage(driver);
		driver.manage().window().maximize();

	}
  
	//@Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("10"));
		
		homePage.openPagingByPageNumber("20");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("20"));
		
		homePage.openPagingByPageNumber("7");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("7"));
		
		homePage.openPagingByPageNumber("18");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("18"));
		
	}
	
	//@Test
	public void Table_02_Enter_To_Header() {
		homePage.refreshCurrentPage();
		
		homePage.enterToHeaderTextboxByLabel("Country", "Argentina"); 
		homePage.enterToHeaderTextboxByLabel("Females", "338282");
		homePage.enterToHeaderTextboxByLabel("Males", "349238");
		homePage.enterToHeaderTextboxByLabel("Total", "687522");
		homePage.sleepInSecond(3);
		
		homePage.enterToHeaderTextboxByLabel("Country", "Angola");
		homePage.enterToHeaderTextboxByLabel("Females", "276880");
		homePage.enterToHeaderTextboxByLabel ("Males", "276472"); 
		homePage.enterToHeaderTextboxByLabel ("Total", "553353"); 
		homePage.sleepInSecond (3);
	}
	
	//@Test
	public void Table_03_Enter_To_Header() {
		//Đọc dữ liệu của file country.txt ra
		
		// Lưu vào 1 List<String> = Expected Value = expectedAllCountryValues
		
		//Actual value
		actualAllCountryValues = homePage.getValueEachRowAtAllPage();
		
		// Verify 
		Assert.assertEquals(actualAllCountryValues, expectedAllCountryValues);  
	}
	
	@Test
	public void Table_04_Enter_To_Textbox_At_Any_Row() {
		homePage.clickToLoadButton();
		homePage.sleepInSecond(5);

		/*
		 * homePage.enterToTextboxByColumnNameAtRowNumber("Company", "1", "Michael 97");
		 * homePage.enterToTextboxByColumnNameAtRowNumber("Contact Person", "2",
		 * "Michael Jackson");
		 * homePage.enterToTextboxByColumnNameAtRowNumber("Order Placed", "3", "1997");
		 * homePage.enterToTextboxByColumnNameAtRowNumber("Member Since", "4",
		 * "09/30/1992");
		 * 
		 * homePage.selectDropdownByColumnNameAtRowNumber("Country", "1", "Japan");
		 * homePage.sleepInSecond (3);
		 * homePage.selectDropdownByColumnNameAtRowNumber("Country", "2", "Hong Kong");
		 * homePage.sleepInSecond (3);
		 * homePage.selectDropdownByColumnNameAtRowNumber("Country", "3",
		 * "United States"); homePage.sleepInSecond (3);
		 * 
		 * homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?","1");
		 * homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?","3");
		 * 
		 * homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?","2");
		 * homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?","4");
		 */
		
		homePage.clickToIconByRowNumber ("1", "Remove Current Row");
		homePage.sleepInSecond(2);
		homePage.clickToIconByRowNumber("1", "Insert Row Above");
		homePage.sleepInSecond(2);
		homePage.clickToIconByRowNumber ("3", "Move Up");
		homePage.sleepInSecond(2);
		homePage.clickToIconByRowNumber ("5", "Remove Current Row");
		homePage.sleepInSecond(2);
		homePage.clickToIconByRowNumber ("4", "Move Down"); 
		homePage.sleepInSecond(2);
		homePage.clickToIconByRowNumber ("3", "Remove Current Row"); 
		homePage.sleepInSecond(2);
		homePage.clickToIconByRowNumber ("2", "Remove Current Row");
		homePage.sleepInSecond(2);
		homePage.clickToIconByRowNumber ("1", "Remove Current Row");
		homePage.sleepInSecond(2);
		
	}

//  @AfterClass
//  public void afterClass() {
//	  driver.quit();
//  }
  
  public int generateFakeNumber() {
	  Random rand = new Random();
	  return rand.nextInt(9999);
  }
}
