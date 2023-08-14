package com.jquery.datatable;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.uploadFile.PageGeneratorManager;
import pageObject.jQuery.uploadFile.HomePageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_11_Upload_Files extends BaseTest{
	private WebDriver driver;
	private HomePageObject homePage;
	
	String csharpFileName = "CSharp.png";
	String javaFileName = "Java.png";
	String pythonFileName = "Python.png";
	String rubyFileName = "Ruby.png";
	String[] multipleFileNames = {csharpFileName, javaFileName, pythonFileName, rubyFileName};

	@Parameters({"browser", "url"})     
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		driver = getBrowserDriver(browserName, appURL);
		homePage = PageGeneratorManager.getHomePage(driver);
		driver.manage().window().maximize();

	}
  
	@Test
	public void Upload_01_One_File_Per_Time() {
		// Step 01 Load single file
		homePage.uploadMultipleFiles(csharpFileName);
		
		// Step 02 - Verify single file loaded success 
		Assert.assertTrue(homePage.isFileLoadedByName(csharpFileName));
		
		// Step 03 Click to Start button 
		homePage.clickToStartButton();
		
		// Step 04 - Verify single file link uploaded success 
		Assert.assertTrue(homePage.isFileLinkUploadedByName(csharpFileName));
		
		// Step 05 - Verify single file image uploaded success 
		Assert.assertTrue(homePage.isFileImageUploadedByName(csharpFileName));
	}
	
	@Test
	public void Upload_02_Multiple_File_Per_Time() {
		// Step 01 - Load multiple file
		homePage.uploadMultipleFiles(multipleFileNames);
		
		// Step 02 - Verify multiple file loaded success 
		Assert.assertTrue(homePage.isFileLoadedByName(csharpFileName)); 
		Assert.assertTrue(homePage.isFileLoadedByName(javaFileName)); 
		Assert.assertTrue(homePage.isFileLoadedByName(pythonFileName));
		Assert.assertTrue(homePage.isFileLoadedByName (rubyFileName));
		
		// Step 03 Click to Start button 
		homePage.clickToStartButton();
		
		// Step 04 - Verify multiple file link uploaded success 
		Assert.assertTrue(homePage.isFileLinkUploadedByName(csharpFileName)); 
		Assert.assertTrue(homePage.isFileLinkUploadedByName(javaFileName)); 
		Assert.assertTrue(homePage.isFileLinkUploadedByName(pythonFileName)); 
		Assert.assertTrue(homePage.isFileLinkUploadedByName(rubyFileName));
		
		// Step 05 - Verify multiple file image uploaded success 
		Assert.assertTrue(homePage.isFileImageUploadedByName(csharpFileName)); 
		Assert.assertTrue(homePage.isFileImageUploadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(pythonFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(rubyFileName));
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
