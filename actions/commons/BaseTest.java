package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private long timeout = 30;

	protected WebDriver getBrowserDriver(String browserName, String environmentName) {
		
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		
		if(browser == BrowserList.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser == BrowserList.H_FIREFOX) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(options);
		}
		else if(browser == BrowserList.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser == BrowserList.H_CHROME) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		}
		else if(browser == BrowserList.COC_COC) {
			WebDriverManager.chromedriver().driverVersion("108.0.5359.71").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("/Applications/CocCoc.app/Contents/MacOS/CocCoc");
			driver = new ChromeDriver(options);
		}
		else if(browser == BrowserList.BRAVE) {
			WebDriverManager.chromedriver().driverVersion("108.0.5359.71").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("/Applications/Brave Browser.app/Contents/MacOS/Brave Browser");
			driver = new ChromeDriver(options);
		}
		else if(browser == BrowserList.OPERA) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		}
		else if(browser == BrowserList.EDGE) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(browser == BrowserList.SAFARI) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}
		else {
			throw new RuntimeException("Invalid browserName");
		}
		
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(getEnvironmentUrl(environmentName));
		return driver;
	}
	
	private String getEnvironmentUrl (String environmentName) {
		String url = null;
		EnvironmentList environment = EnvironmentList.valueOf(environmentName.toUpperCase());
		switch(environment) {
		case DEV:
			url = GlobalConstants.USER_PAGE_URL;
			break;
		
		case STAGING:
			url = "";
			break;
		default:
			break;
		}
		return url;
	}
}
