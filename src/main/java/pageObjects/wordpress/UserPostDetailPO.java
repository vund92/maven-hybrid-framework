package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserHomePageUI;
import pageUIs.wordpress.UserPostDetailPageUI;

public class UserPostDetailPO extends BasePage {
	WebDriver driver;

	public UserPostDetailPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean isPostInforDisplayedWithPostTitle(String postTitle) {
		waitForElementVisible(UserPostDetailPageUI.POST_TITLE_TEXT, postTitle);
		return isElementDisplayed(UserPostDetailPageUI.POST_TITLE_TEXT, postTitle);
	}

	public boolean isPostInforDisplayedWithPostBody(String postBody) {
		waitForElementVisible(UserPostDetailPageUI.POST_BODY_TEXT_BY_POST_TITLE, postBody);
		return isElementDisplayed(UserPostDetailPageUI.POST_BODY_TEXT_BY_POST_TITLE, postBody);
	}

	public boolean isPostInforDisplayedWithPostAuthor(String authorName) {
		waitForElementVisible(UserPostDetailPageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, authorName);
		return isElementDisplayed(UserPostDetailPageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, authorName);
	}

	public boolean isPostInforDisplayedWithPostCurrentDay(String currentDay) {
		waitForElementVisible(UserPostDetailPageUI.POST_CURRENT_DATE_TEXT_BY_POST_TITLE, currentDay);
		return isElementDisplayed(UserPostDetailPageUI.POST_CURRENT_DATE_TEXT_BY_POST_TITLE, currentDay);
	}

}
