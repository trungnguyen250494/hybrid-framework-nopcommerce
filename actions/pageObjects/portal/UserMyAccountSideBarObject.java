package pageObjects.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.BasePageUI;
import pageUIs.user.CustomerPageUI;
import pageUIs.user.MyAccountSideBarPageUI;
import pageUIs.user.RegisterPageUI;

public class UserMyAccountSideBarObject extends BasePage {
	private WebDriver driver;

	public UserMyAccountSideBarObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public UserAddressPageObject openAddressPage() {
		waitForElementClickable(driver, MyAccountSideBarPageUI.ADDRESS_LINK);
		clickToElement(driver, MyAccountSideBarPageUI.ADDRESS_LINK);
		return PageGeneratorManager.getUserAddressPage(driver);
	}
	
	public UserProductReviewPageObject openProductReviewPage() {
		waitForElementClickable(driver, MyAccountSideBarPageUI.PRODUCT_REVIEW_LINK);
		clickToElement(driver, MyAccountSideBarPageUI.PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getUserProductReviewPage(driver);
	}
	
	public UserRewardPointPageObject openRewardPointPage() {
		waitForElementClickable(driver, MyAccountSideBarPageUI.REWARD_POINT_LINK);
		clickToElement(driver, MyAccountSideBarPageUI.REWARD_POINT_LINK);
		return PageGeneratorManager.getUserRewardPointPage(driver);
	}
	
	public UserCustomerPageObject openCustomerInfoPage() {
		waitForElementClickable(driver, MyAccountSideBarPageUI.CUSTOMER_INFO_LINK);
		clickToElement(driver, MyAccountSideBarPageUI.CUSTOMER_INFO_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}
}
