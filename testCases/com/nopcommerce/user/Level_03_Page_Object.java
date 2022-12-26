package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import net.bytebuddy.agent.builder.AgentBuilder.ClassFileBufferStrategy;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class Level_03_Page_Object {
	private WebDriver driver;

	private String projectPath = System.getProperty("user.dir");
	private String osName = System.getProperty("os.name");
	private String email,firstName,lastName,password,confirmPassword;
	private long timeout = 30;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac OS")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		}

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://demo.nopcommerce.com/");
		
		firstName = "Tester";
		lastName = "Tester";
		password = "Tester@123";
		confirmPassword = "Tester@123";
		email = "tester" + getRandomNumber() + "@yopmail.com";
		
		homePage = new HomePageObject(driver);
		registerPage = new RegisterPageObject(driver);
		

	}

	@Test
	public void TC_01_Register_Empty_Data() {
		
		homePage.clickToRegisterLink();

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
		
	}

	@Test
	public void TC_02_Register_Invalid_Email() {

		homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLasttNameTextbox(lastName);
		registerPage.inputToEmailTextbox("abc#xyz");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);
		
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void TC_03_Register_Success() {

		homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLasttNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void TC_04_Register_Existing_Email() {

		homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLasttNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getExistingEmailErrorMessage(), "The specified email already exists");

	}

	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {

		homePage.clickToRegisterLink();
		
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLasttNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox("Test");
		registerPage.inputToConfirmPasswordTextbox("Test");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {

		homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLasttNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox("Tester@456");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");

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
