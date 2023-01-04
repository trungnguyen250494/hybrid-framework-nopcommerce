package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.AddressPageObject;
import pageObjects.CustomerPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.ProductReviewPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.RewardPointPageObject;

public class Level_07_Switch_Page extends BaseTest{
	private WebDriver driver;
	private String validEmail, firstName, lastName, correctPassword, confirmPassword, invalidEmail, notFoundEmail, incorrectPassword;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private CustomerPageObject customerInfoPage;
	private AddressPageObject addressPage;
	private ProductReviewPageObject productReviewPage;
	private RewardPointPageObject rewardPointPage;
	

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);

		firstName = "Tester";
		lastName = "Tester";
		correctPassword = "Tester@123";
		incorrectPassword = "123";
		confirmPassword = "Tester@123";
		validEmail = "tester" + getRandomNumber() + "@yopmail.com";
		invalidEmail = "tester@yopmail.com@123";
		notFoundEmail = "testerHello@yopmail.com";

	}

	@Test
	public void User_01_Register() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLasttNameTextbox(lastName);
		registerPage.inputToEmailTextbox(validEmail);
		registerPage.inputToPasswordTextbox(correctPassword);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	@Test
	public void User_02_Login() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmail(validEmail);
		loginPage.inputToPassword(correctPassword);
		loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
	}

	@Test
	public void User_03_My_Account() {
		customerInfoPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(customerInfoPage.isDisplayed());
		customerInfoPage.uncheckNewsLetter();
		Assert.assertFalse(customerInfoPage.isNewsLetterChecked());
	}

	@Test
	public void User_04_Switch_Page() {
		addressPage = customerInfoPage.openAddressPage(driver);
		productReviewPage = addressPage.openProductReviewPage(driver);
		rewardPointPage = productReviewPage.openRewardPointPage(driver);
		customerInfoPage = rewardPointPage.openCustomerInfoPage(driver);
		Assert.assertTrue(customerInfoPage.isNewsLetterChecked());

	}

	

	public int getRandomNumber() {
		Random rd = new Random();
		return rd.nextInt(1000);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
