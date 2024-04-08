package pageObjects.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class UserProductReviewPageObject extends UserMyAccountSideBarObject{
	private WebDriver driver;

	public UserProductReviewPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
