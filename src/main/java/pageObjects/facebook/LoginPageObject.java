package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.LoginPageUI;

public class LoginPageObject extends BasePage{
	
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void clickToCreateNewAccountButton() {
		waitForElementClickable (LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON); 
		clickToElement (LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		}
	
		public boolean isEmailAddressTextboxDisplayed () {
		waitForElementVisible (LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		return isElementDisplayed (LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		}
		
		public void enterToEmailAddressTextbox(String emailAddress) {
			waitForElementVisible(LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
			sendkeyToElement(LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
		}

		public boolean isConfirmEmailAddressTextboxDisplayed() {
			return isElementDisplayed(LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
		}

		public void clickCloseIconAtRegisterForm() {
			waitForElementClickable(LoginPageUI.CLOSE_ICON); 
			clickToElement(LoginPageUI.CLOSE_ICON);
		}

		public boolean isConfirmEmailAddressTextboxUndisplayed() {
			waitForElementUndisplayed(LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
			return isElementUndisplayed(LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
		}
}
