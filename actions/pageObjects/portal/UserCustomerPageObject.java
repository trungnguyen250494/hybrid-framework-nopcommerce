package pageObjects.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.CustomerPageUI;
import pageUIs.user.RegisterPageUI;

public class UserCustomerPageObject extends BasePage {
	private WebDriver driver;

	public UserCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void uncheckNewsLetter() {
		waitForElementClickable(driver, CustomerPageUI.NEWSLETTER_CHECKBOX);
		if(isElementSelected(driver, CustomerPageUI.NEWSLETTER_CHECKBOX)) {
			clickToElement(driver, CustomerPageUI.NEWSLETTER_CHECKBOX);
		}
	}

	public boolean isNewsLetterChecked() {
		return isElementSelected(driver, CustomerPageUI.NEWSLETTER_CHECKBOX);
	}

	public boolean isDisplayed() {
		return isElementDisplayed(driver, CustomerPageUI.HEADER_PAGE);
	}
}
