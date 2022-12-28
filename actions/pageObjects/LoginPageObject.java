package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.LoginPageUI;
import pageUIs.RegisterPageUI;

public class LoginPageObject extends BasePage{
	private WebDriver driver;
	
	public LoginPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.REGISTER_BUTTON);
		clickToElement(driver, LoginPageUI.REGISTER_BUTTON);
		
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
	
	

}
