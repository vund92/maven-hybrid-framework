package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserHomePageUI;
import pageUIs.wordpress.UserPostDetailPageUI;

public class UserHomePO extends BasePage {
	WebDriver driver;

	public UserHomePO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isPostInforDisplayedWithPostTitle(String postTitle) {
		waitForElementVisible(UserHomePageUI.POST_TITLE_TEXT, postTitle);
		return isElementDisplayed(UserHomePageUI.POST_TITLE_TEXT, postTitle);
	}

	public boolean isPostInforDisplayedWithPostBody(String postTitle, String postBody) {
		waitForElementVisible(UserHomePageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle, postBody);
		return isElementDisplayed(UserHomePageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle, postBody);
	}

	public boolean isPostInforDisplayedWithPostAuthor(String postTitle, String authorName) {
		waitForElementVisible(UserHomePageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle, authorName);
		return isElementDisplayed(UserHomePageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle, authorName);
	}

	public boolean isPostInforDisplayedWithPostCurrentDay(String postTitle, String currentDay) {
		waitForElementVisible(UserHomePageUI.POST_CURRENT_DATE_TEXT_BY_POST_TITLE, postTitle, currentDay);
		return isElementDisplayed(UserHomePageUI.POST_CURRENT_DATE_TEXT_BY_POST_TITLE, postTitle, currentDay);
	}

	public UserPostDetailPO clickToPostTitle(String postTitle) {
		waitForElementClickable(UserHomePageUI.POST_TITLE_TEXT, postTitle);
		clickToElement(UserHomePageUI.POST_TITLE_TEXT, postTitle);
		return PageGeneratorManager.getUserPostDetailPage(driver);
	}

	public boolean isPostInforUndisplayedWithPostTitle(String editPostTitle) {
		return isElementUndisplayed(UserHomePageUI.POST_TITLE_TEXT, editPostTitle);
	}

	public void enterToSearchTextbox(String editPostTitle) {
		waitForElementVisible(UserHomePageUI.SEARCH_TEXTBOX, editPostTitle);
		sendkeyToElement(UserHomePageUI.SEARCH_TEXTBOX, editPostTitle);
	}

	public UserSearchPostPO clickToSearchButton() {
		waitForElementClickable(UserHomePageUI.SEARCH_BUTTON);
		clickToElement(UserHomePageUI.SEARCH_BUTTON);
		return PageGeneratorManager.getUserSearchPostPage(driver);
	}
}
