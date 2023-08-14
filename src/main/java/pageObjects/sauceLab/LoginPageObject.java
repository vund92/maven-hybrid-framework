package pageObjects.sauceLab;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.sauceLab.LoginPageUI;

public class LoginPageObject extends BasePage{
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToUsernameTextbox(String username) {
		waitForElementVisible(LoginPageUI.USERNAME_TEXTBOX);
		sendkeyToElement(LoginPageUI.USERNAME_TEXTBOX, username);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public ProductPageObject clickToLoginButton() {
		waitForElementClickable(LoginPageUI.LOGIN_BUTTON);
		clickToElement(LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getProductPage(driver);
	}

}
