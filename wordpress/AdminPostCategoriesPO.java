package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class AdminPostCategoriesPO extends BasePage{
	WebDriver driver;

	public AdminPostCategoriesPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
