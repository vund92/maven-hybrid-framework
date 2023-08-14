package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserSearchPostPageUI;

public class UserSearchPostPO extends BasePage {
	WebDriver driver;

	public UserSearchPostPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isNothingFoundMessageDisplayed() {
		waitForElementVisible(UserSearchPostPageUI.NOTHING_FOUND_MESSAGE);
		return isElementDisplayed(UserSearchPostPageUI.NOTHING_FOUND_MESSAGE);
	}
}
