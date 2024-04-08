package pageObjects.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class UserAddressPageObject extends UserMyAccountSideBarObject{
	private WebDriver driver;

	public UserAddressPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
