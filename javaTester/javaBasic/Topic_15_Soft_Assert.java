package javaBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Topic_15_Soft_Assert {
	WebDriver driver;
	SoftAssert soft;
	
	@BeforeMethod
	public void beforeClass() {
		WebDriverManager.firefoxdriver().setup();
		System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox");
		driver = new FirefoxDriver();
		driver.get("http://live.techpanda.org/customer/account/login/");
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		soft = new SoftAssert();
	}

	@Test
	public void TC_01_Login_Empty_Email_Password() {
		System.out.println("Step 01 - Input to email textbox");
		driver.findElement(By.id("email")).sendKeys("");

		System.out.println("Step 02 - Input to password textbox");
		driver.findElement(By.id("pass")).sendKeys("");
		
		System.out.println("Step 03 - Click to Login button");
		driver.findElement(By.id("send2")).click();
		
		WebElement test1 = driver.findElement(By.id("advice-required-entry-pass"));
		String text1 = test1.getText();
		
		WebElement test2 = driver.findElement(By.id("advice-required-entry-email"));
		String text2 = test2.getText();

		// First Pass (5)
		System.out.println("Step 05 - Verify error message displayed");
		soft.assertEquals(text1, "This is a required field.");
		
		// Second Fail (10)
		System.out.println("Step 10 - Verify error message displayed");
		soft.assertEquals(text2, "This is a required field");

		// Pass (45)
		System.out.println("Step 45 - Verify .....");
		soft.assertTrue(driver.findElement(By.xpath("//button[@id='send2']")).isDisplayed());

		// Third Fail (50)
		System.out.println("Step 50 - Verify .....");
		soft.assertFalse(driver.findElement(By.xpath("//button[@title='Subscribe']")).isDisplayed());

		// Pass (65)
		System.out.println("Step 65 - Verify .....");
		soft.assertTrue(driver.findElement(By.xpath("//button[@id='send2']")).isDisplayed());

		// Fourth Fail (76)
		System.out.println("Step 76 - Verify .....");
		soft.assertFalse(driver.findElement(By.xpath("//a[@title='Create an Account']")).isDisplayed());
		
		soft.assertAll();
	}

	@AfterMethod
	public void afterClass() {
		driver.quit();
	}

}
