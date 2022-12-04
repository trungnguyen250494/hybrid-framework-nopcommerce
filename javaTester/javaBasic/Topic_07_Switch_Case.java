package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_07_Switch_Case {
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriver driver;
	Scanner scanner = new Scanner(System.in);

	@Parameters("browsers")
	//@Test
	public void TC_01(String browserName) {

		getDriverByBrowserName(browserName);
		driver.quit();

	}
	
	@Test
	public void TC_02() {
		int month = scanner.nextInt();
		
		switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				System.out.println("Tháng này có 31 ngày");
				break;
				
			case 2:
				System.out.println("Tháng này có 28 hoặc 29 ngày");
				break;
				
			case 4:
			case 6:
			case 9:
			case 11:
				System.out.println("Tháng này có 30 ngày");
				break;
		}
				
	}
	
	public WebDriver getDriverByBrowserName(String browserName) {
		switch (browserName) {
		case "chrome":
			setPropertyByOS(osName, "chrome", "chromedriver");
			driver = new ChromeDriver();
			break;
		case "firefox":
			setPropertyByOS(osName, "gecko", "geckodriver");
			driver = new FirefoxDriver();
			break;
		case "ie":
			setPropertyByOS(osName, "edge", "msedgedriver");
			driver = new EdgeDriver();
			break;
		default:
			new RuntimeException("Please input another browserName");
			break;
		}
		return driver;
	}
	
	public void setPropertyByOS (String osName, String webbrowserName, String webdriverName) {
		if (osName.contains("Mac OS")) {
			System.setProperty("webdriver."+webbrowserName+".driver", projectPath + "/browserDrivers/"+webdriverName);
		} else {
			System.setProperty("webdriver."+webbrowserName+".driver", projectPath + "\\browserDrivers\\"+webdriverName+".exe");
		}
	}

}
