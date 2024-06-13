package javaBasic;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.GlobalConstants;

public class Topic_06_Condition_Statement {
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	WebDriver driver;

	//@Test
	public void TC_01_If() {
		boolean status = 5 > 3;
		if (status) {
			System.out.println("Go to if");
		}

		//driver = new FirefoxDriver();

		List<WebElement> salePopup = driver.findElements(By.id(""));

		if (salePopup.size() > 0 && salePopup.get(0).isDisplayed()) {

		}

		int studentNumber = 10;

		status = (studentNumber == 10);

		WebElement languageCheckbox = driver.findElement(By.id(""));
		if (languageCheckbox.isDisplayed()) {
			languageCheckbox.click();
		}
	}

	//@Test
	public void TC_02_If_Else() {
		if (osName.contains("Mac OS")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		}

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		System.out.println(driver.toString());
		driver.get("https://automationfc.github.io/basic-form/index.html");
	}

	@Parameters("browsers")
	//@Test
	public void TC_03_If_Else(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			if (osName.contains("Mac OS")) {
				System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
			} else {
				System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			}
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")){
			if (osName.contains("Mac OS")) {
				System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
			} else {
				System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			}
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("ie")){
			if (osName.contains("Mac OS")) {
				System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver");
			} else {
				System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			}
			driver = new EdgeDriver();

		} else {

			throw new RuntimeException("Please input another browserName");

		}
	}

	@Test
	public void TC_04_If_Else() {
		int age = 20;
		String access = (age < 18) ? "You cannot access" : "Welcome to the system";
		System.out.println(access);

	}

}
