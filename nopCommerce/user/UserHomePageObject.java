package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.UserHomePageUI;

public class UserHomePageObject extends BasePage {
	
	private WebDriver driver; 
	
	public UserHomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Register - Navigate to 'Register' page")
	public UserRegisterPageObject openRegisterPage() {
		waitForElementClickable(UserHomePageUI.REGISTER_LINK);
		clickToElement(UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	@Step("Login - Navigate to 'Login' page")
	public UserLoginPageObject openLoginPage() {
		waitForElementClickable(UserHomePageUI.LOGIN_LINK);
		clickToElement(UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	@Step("Login - Check 'My Account' link is displayed")
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(UserHomePageUI.MY_ACCOUNT_LINK);
	}

	@Step("Login - Navigate to 'My Account' page")
	public UserCustomerInforPageObject openMyAccountPage() {
		waitForElementClickable(UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInforPage(driver);
	}
	
	public boolean isLoginLinkUndisplayed() {
		waitForElementVisible(UserHomePageUI.LOGIN_LINK);
		return isElementUndisplayed(UserHomePageUI.LOGIN_LINK);
	}

}
