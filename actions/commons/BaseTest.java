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
		
		if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("h_firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(options);
		}
		else if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equals("h_chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		}
		else if(browserName.equals("coccoc")) {
			WebDriverManager.chromedriver().driverVersion("108.0.5359.71").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("/Applications/CocCoc.app/Contents/MacOS/CocCoc");
			driver = new ChromeDriver(options);
		}
		else if(browserName.equals("brave")) {
			WebDriverManager.chromedriver().driverVersion("108.0.5359.71").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("/Applications/Brave Browser.app/Contents/MacOS/Brave Browser");
			driver = new ChromeDriver(options);
		}
		else if(browserName.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		}
		else if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(browserName.equals("safari")) {
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
		switch(environmentName) {
		case "dev":
			url = GlobalConstants.USER_PAGE_URL;
			break;
		
		case "staging":
			url = "";
			break;
		default:
			break;
		}
		return url;
	}
}
