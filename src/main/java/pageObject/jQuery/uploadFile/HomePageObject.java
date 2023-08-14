package pageObject.jQuery.uploadFile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.uploadFile.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isFileLoadedByName(String fileName) {
		waitForElementVisible(HomePageUI.FILE_NAME_LOADED, fileName);
		return isElementDisplayed(HomePageUI.FILE_NAME_LOADED, fileName);
	}

	public boolean isFileLinkUploadedByName(String fileName) {
		waitForElementVisible(HomePageUI.FILE_NAME_UPLOADED_LINK, fileName);
		return isElementDisplayed(HomePageUI.FILE_NAME_UPLOADED_LINK, fileName);
	}

	public void clickToStartButton() {
		List<WebElement> startButtons = getListWebElement(HomePageUI.START_BUTTON);
		for (WebElement startButton : startButtons) {
			startButton.click();
			sleepInSecond(2);
		}
	}

	public boolean isFileImageUploadedByName(String fileName) {
		waitForElementVisible(HomePageUI.FILE_NAME_UPLOADED_IMAGE, fileName);
		return isImageLoaded(HomePageUI.FILE_NAME_UPLOADED_IMAGE, fileName);
	}

}
