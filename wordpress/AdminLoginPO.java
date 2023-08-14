package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminLoginPageUI;

public class AdminLoginPO extends BasePage{
	
	WebDriver driver;
	
	public AdminLoginPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToUsernameTextbox(String adminUsername) {
		waitForElementVisible(AdminLoginPageUI.USERNAME_TEXTBOX);
		sendkeyToElement(AdminLoginPageUI.USERNAME_TEXTBOX, adminUsername);
	}

	public void enterToPasswordTextbox(String adminPassword) {
		waitForElementVisible(AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(AdminLoginPageUI.PASSWORD_TEXTBOX, adminPassword);
	}

	public AdminDashboardPO clickToLoginButton() {
		waitForElementVisible(AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}

}
