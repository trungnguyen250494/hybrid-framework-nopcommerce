package pageObjects.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.LoginPageUI;
import pageUIs.user.RegisterPageUI;

public class UserLoginPageObject extends BasePage{
	private WebDriver driver;
	
	public UserLoginPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.REGISTER_BUTTON);
		clickToElement(driver, LoginPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
		
	}

	public String getErrorMessageAtEmailTextbox() {
		waitUntilElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}


	public String getValidationErrorMessage() {
		waitUntilElementVisible(driver, LoginPageUI.VALIDATION_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.VALIDATION_ERROR_MESSAGE);
	}

	public void inputToEmail(String email) {
		waitUntilElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
		
	}

	public void inputToPassword(String password) {
		waitUntilElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public UserHomePageObject loginAsUser(String email, String password) {
		inputToEmail(email);
		inputToPassword(password);
		return clickToLoginButton();
		
	}
	

}
