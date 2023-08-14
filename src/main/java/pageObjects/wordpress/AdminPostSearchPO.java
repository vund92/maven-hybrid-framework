package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.wordpress.AdminPostSearchPageUI;

public class AdminPostSearchPO extends BasePage{
	WebDriver driver;

	public AdminPostSearchPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Create_Post - Click to 'Add New' button")
	public AdminPostAddNewPO clickToAddNewButton() {
		waitForElementVisible(AdminPostSearchPageUI.ADD_NEW_BUTTON);
		clickToElement(AdminPostSearchPageUI.ADD_NEW_BUTTON);
		return PageGeneratorManager.getAdminPostAddNewPage(driver);
		
	}

	public void enterToSearchTextbox(String postTitle) {
		waitForElementVisible(AdminPostSearchPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(AdminPostSearchPageUI.SEARCH_TEXTBOX, postTitle);
	}

	public void clickToSearchPostsButton() {
		waitForElementClickable(AdminPostSearchPageUI.SEARCH_POSTS_BUTTON);
		clickToElement(AdminPostSearchPageUI.SEARCH_POSTS_BUTTON);
	}

	public boolean isPostSearchTableDisplayed(String headerID, String cellValue) {
		int headerIndex = getElementSize(AdminPostSearchPageUI.TABLE_HEADER_INDEX_BY_HEADER_NAME, headerID) + 1;
		waitForElementVisible(AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), cellValue);
		return isElementDisplayed(AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), cellValue);
	}
	
	public AdminPostAddNewPO clickToPostTitleLink(String postTitle) {
		waitForElementClickable(AdminPostSearchPageUI.ROW_TITLE_DETAIL_BY_TITLE_NAME, postTitle);
		clickToElement(AdminPostSearchPageUI.ROW_TITLE_DETAIL_BY_TITLE_NAME, postTitle);
		return PageGeneratorManager.getAdminPostAddNewPage(driver);
	}

	public void selectPostCheckboxByTitle(String editPostTitle) {
		waitForElementClickable(AdminPostSearchPageUI.ROW_CHECKBOX_BY_TITLE_NAME, editPostTitle);
		checkToDefaultCheckboxOrRadio(AdminPostSearchPageUI.ROW_CHECKBOX_BY_TITLE_NAME, editPostTitle);
	}

	public void selectTextItemInActionDropdown(String drodownItem) {
		waitForElementClickable(AdminPostSearchPageUI.ACTION_DROPDOWN);
		selectItemInDefaultDropdown(AdminPostSearchPageUI.ACTION_DROPDOWN, drodownItem);
	}

	public void clickToApplyButton() {
		waitForElementClickable(AdminPostSearchPageUI.APPLY_BUTTON);
		clickToElement(AdminPostSearchPageUI.APPLY_BUTTON);
	}

	public boolean isMoveToTrashMessageDisplayed(String message) {
		waitForElementVisible(AdminPostSearchPageUI.MOVE_TO_TRASH_MESSAGE, message);
		return isElementDisplayed(AdminPostSearchPageUI.MOVE_TO_TRASH_MESSAGE, message);
	}

	public boolean isNoPostFoundMessageDisplayed(String message) {
		waitForElementVisible(AdminPostSearchPageUI.NO_POST_FOUND_MESSAGE, message);
		return isElementDisplayed(AdminPostSearchPageUI.NO_POST_FOUND_MESSAGE, message);
	}

}
