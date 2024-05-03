package pageObjects.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.RegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	private WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public String getErrorMessageAtFirstNameTextbox() {
		waitUntilElementVisible(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtLastNameTextbox() {
		waitUntilElementVisible(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitUntilElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitUntilElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitUntilElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitUntilElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
		
	}

	public void inputToLastNameTextbox(String lastName) {
		waitUntilElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
		
	}

	public void inputToEmailTextbox(String email) {
		waitUntilElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitUntilElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitUntilElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
		
	}

	public String getRegisterSuccessMessage() {
		waitUntilElementVisible(driver, RegisterPageUI.SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.SUCCESS_MESSAGE);
	}

	public String getExistingEmailErrorMessage() {
		waitUntilElementVisible(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
	}

	public void scrollToEmail() {
		scrollToElement(driver, RegisterPageUI.EMAIL_TEXTBOX);		
	}

}
