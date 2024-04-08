package pageObjects.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class UserRewardPointPageObject extends UserMyAccountSideBarObject{
	private WebDriver driver;

	public UserRewardPointPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
