package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.wordpress.AdminPostAddNewPageUI;

public class AdminPostAddNewPO extends BasePage {

	WebDriver driver;

	public AdminPostAddNewPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Create_Post - Enter to post title")
	public void enterToAddNewPostTitle(String postTitleValue) {
		waitForElementVisible(AdminPostAddNewPageUI.TITLE_TEXTBOX);
		sendkeyToElement(AdminPostAddNewPageUI.TITLE_TEXTBOX, postTitleValue);
	}

	@Step("Create_Post - Enter to body")
	public void enterToAddNewPostBody(String postBodyValue) {
		waitForElementClickable(AdminPostAddNewPageUI.BODY_BUTTON);
		clickToElement(AdminPostAddNewPageUI.BODY_BUTTON);
		
		waitForElementVisible(AdminPostAddNewPageUI.BODY_TEXTBOX);
		sendkeyToElement(AdminPostAddNewPageUI.BODY_TEXTBOX, postBodyValue);
	}
	
	@Step("Create_Post - Enter to edit body")
	public void enterToEditPostBody(String postBodyValue) {
		waitForElementClickable(AdminPostAddNewPageUI.BODY_TEXTBOX);
		clickToElement(AdminPostAddNewPageUI.BODY_TEXTBOX);
		
		waitForElementVisible(AdminPostAddNewPageUI.BODY_TEXTBOX);
		clearValueInElementByDeleteKey(AdminPostAddNewPageUI.BODY_TEXTBOX);
		sleepInSecond(5);
		sendkeyToElement(AdminPostAddNewPageUI.BODY_TEXTBOX, postBodyValue);
	}
	
	@Step("Create_Post - Click to publish or update button")
	public void clickToPublishOrUpdateButton() {
		waitForElementClickable(AdminPostAddNewPageUI.PUBLISH_OR_UPDATE_BUTTON);
		clickToElement(AdminPostAddNewPageUI.PUBLISH_OR_UPDATE_BUTTON);
	}

	@Step("Create_Post - Click to 'Publish' button")
	public void clickToPublishButton() {
		waitForElementClickable(AdminPostAddNewPageUI.PUBLISH_BUTTON_BEFORE_CLICK);
		clickToElement(AdminPostAddNewPageUI.PUBLISH_BUTTON_BEFORE_CLICK);
		waitForElementClickable(AdminPostAddNewPageUI.PUBLISH_BUTTON_AFTER_CLICK);
		clickToElement(AdminPostAddNewPageUI.PUBLISH_BUTTON_AFTER_CLICK);
	}

	@Step("Create_Post - Verify 'Post published' message is displayed")
	public boolean isPostPublishMessageDisplayed(String postPublishedMessage) {
		waitForElementVisible(AdminPostAddNewPageUI.PUBLISHED_OR_UPDATE_MESSAGE, postPublishedMessage);
		return isElementDisplayed(AdminPostAddNewPageUI.PUBLISHED_OR_UPDATE_MESSAGE, postPublishedMessage);
	}

	@Step("Search_Post - Open 'Search Post' page")
	public AdminPostSearchPO openSearchPostPageUrl(String searchPostUrl) {
		openPageUrl(searchPostUrl);
		return PageGeneratorManager.getAdminPostSearchPage(driver);
	}
}
