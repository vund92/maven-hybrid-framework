package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class AdminPostTagPO extends BasePage{
	WebDriver driver;

	public AdminPostTagPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
