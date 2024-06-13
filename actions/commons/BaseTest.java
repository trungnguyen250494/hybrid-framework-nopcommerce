package commons;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriverLogLevel;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	protected final Logger log;

	public BaseTest() {
		log = LogManager.getLogger(getClass());
	}

	protected WebDriver getBrowserDriver(String browserName, String environmentName){

		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

		switch (browser) {
		case FIREFOX:
			System.setProperty(GeckoDriverService.GECKO_DRIVER_LOG_LEVEL_PROPERTY, GlobalConstants.BROWSER_LOG_PATH + "FirefoxDriverLogLevel.log");
			FirefoxDriverService ffDriverService = new GeckoDriverService.Builder().withLogLevel(FirefoxDriverLogLevel.DEBUG).build();
			driver = new FirefoxDriver(ffDriverService);
			break;

		case H_FIREFOX:
			FirefoxOptions h_ff_options = new FirefoxOptions();
			h_ff_options.setBinary("/Applications/Firefox.app/Contents/MacOS/firefox");
			h_ff_options.addArguments("--headless");
			h_ff_options.addArguments("window-size=1920x1080");
			driver = WebDriverManager.firefoxdriver().capabilities(h_ff_options).create();
			break;

		case CHROME:
			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_LEVEL_PROPERTY, GlobalConstants.BROWSER_LOG_PATH + "ChromeDriverLogLevel.log");
			ChromeDriverService chromeDriverService = new ChromeDriverService.Builder().withLogLevel(ChromiumDriverLogLevel.DEBUG).build();
			driver = new ChromeDriver(chromeDriverService);
			break;

		case H_CHROME:
			WebDriverManager.chromedriver().clearDriverCache().setup();
			ChromeOptions hchrome_options = new ChromeOptions();
			hchrome_options.addArguments("--headless");
			driver = WebDriverManager.chromedriver().capabilities(hchrome_options).create();
			break;

		case EDGE:
			System.setProperty(EdgeDriverService.EDGE_DRIVER_LOG_LEVEL_PROPERTY, GlobalConstants.BROWSER_LOG_PATH + "EdgeDriverLogLevel.log");
			EdgeDriverService edgeDriverService = new EdgeDriverService.Builder().withLoglevel(ChromiumDriverLogLevel.DEBUG).build();
			driver = new EdgeDriver(edgeDriverService);
			break;

		case H_EDGE:
			WebDriverManager.chromedriver().clearDriverCache().setup();
			EdgeOptions h_edge_options = new EdgeOptions();
			h_edge_options.addArguments("--headless");
			driver = WebDriverManager.edgedriver().capabilities(h_edge_options).create();
			break;

		case COC_COC:
			WebDriverManager.chromedriver().driverVersion("108.0.5359.71").setup();
			ChromeOptions cc_options = new ChromeOptions();
			cc_options.setBinary("/Applications/CocCoc.app/Contents/MacOS/CocCoc");
			driver = new ChromeDriver(cc_options);
			break;

		case BRAVE:
			WebDriverManager.chromedriver().driverVersion("108.0.5359.71").setup();
			ChromeOptions brave_options = new ChromeOptions();
			brave_options.setBinary("/Applicastions/Brave Browser.app/Contents/MacOS/Brave Browser");
			driver = new ChromeDriver(brave_options);
			break;

		case SAFARI:
			SafariOptions safariOptions = new SafariOptions();
			driver = new SafariDriver(safariOptions);
			break;

		default:
			throw new RuntimeException("Invalid browserName");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));

		driver.manage().window().maximize();
		driver.get(getEnvironmentUrl(environmentName));
		return driver;
	}

	protected WebDriver getBrowserDriverWithUrl(String browserName, String url) {

		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

		switch (browser) {
		case FIREFOX:
//			FirefoxOptions ff_options = new FirefoxOptions();
//			ff_options.setBinary("/Applications/Firefox.app/Contents/MacOS/firefox");
//			ff_options.addArguments("window-size=1920x1080");
//			driver = WebDriverManager.firefoxdriver().capabilities(ff_options).create();
			driver = new FirefoxDriver();
			Path xpiPath = Paths.get(GlobalConstants.BROWSER_EXTENSION_PATH + "wappalyzer.xpi");
			FirefoxDriver ffDriver = (FirefoxDriver) driver;
			ffDriver.installExtension(xpiPath);
			driver = ffDriver;
			break;

		case H_FIREFOX:
			FirefoxOptions h_ff_options = new FirefoxOptions();
			h_ff_options.setBinary("/Applications/Firefox.app/Contents/MacOS/firefox");
			h_ff_options.addArguments("--headless");
			h_ff_options.addArguments("window-size=1920x1080");
			driver = WebDriverManager.firefoxdriver().capabilities(h_ff_options).create();
			break;

		case CHROME:
//			ChromeOptions chrome_options = new ChromeOptions();
//			chrome_options.addArguments("window-size=1920x1080");
//			driver = WebDriverManager.chromedriver().capabilities(chrome_options).create();
			ChromeOptions chromeOptions = new ChromeOptions();
			Path crxPath = Paths.get(GlobalConstants.BROWSER_EXTENSION_PATH + "wappalyzer.crx");
			File extensionFilePath = new File(crxPath.toUri());
			chromeOptions.addExtensions(extensionFilePath);
			driver = new ChromeDriver(chromeOptions);
			break;

		case H_CHROME:
			ChromeOptions hchrome_options = new ChromeOptions();
			hchrome_options.addArguments("--headless");
			hchrome_options.addArguments("window-size=1920x1080");
			driver = WebDriverManager.chromedriver().capabilities(hchrome_options).create();
			break;

		case EDGE:
//			EdgeOptions edge_options = new EdgeOptions();
//			edge_options.addArguments("window-size=1920x1080");
//			driver = WebDriverManager.edgedriver().capabilities(edge_options).create();
			EdgeOptions edgeOptions = new EdgeOptions();
			Path crxPath2 = Paths.get(GlobalConstants.BROWSER_EXTENSION_PATH + "wappalyzer.crx");
			File extensionFilePath2 = new File(crxPath2.toUri());
			edgeOptions.addExtensions(extensionFilePath2);
			driver = new EdgeDriver(edgeOptions);
			break;

		case H_EDGE:
			EdgeOptions h_edge_options = new EdgeOptions();
			h_edge_options.addArguments("--headless");
			h_edge_options.addArguments("window-size=1920x1080");
			driver = WebDriverManager.edgedriver().capabilities(h_edge_options).create();
			break;

		case COC_COC:
			WebDriverManager.chromedriver().driverVersion("108.0.5359.71").setup();
			ChromeOptions cc_options = new ChromeOptions();
			cc_options.setBinary("/Applications/CocCoc.app/Contents/MacOS/CocCoc");
			driver = new ChromeDriver(cc_options);
			break;

		case BRAVE:
			WebDriverManager.chromedriver().driverVersion("108.0.5359.71").setup();
			ChromeOptions brave_options = new ChromeOptions();
			brave_options.setBinary("/Applicastions/Brave Browser.app/Contents/MacOS/Brave Browser");
			driver = new ChromeDriver(brave_options);
			break;

		case SAFARI:
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;

		default:
			throw new RuntimeException("Invalid browserName");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

	private String getEnvironmentUrl(String environmentName) {
		String url = null;
		EnvironmentList environment = EnvironmentList.valueOf(environmentName.toUpperCase());
		switch (environment) {
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

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
			log.info("--------------- PASSED ------------------");
		} catch (Throwable e) {
			log.info("--------------- FAILED ------------------");
			pass = false;

			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
			log.info("--------------- PASSED ------------------");
		} catch (Throwable e) {
			log.info("--------------- FAILED ------------------");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info("--------------- PASSED ------------------");
		} catch (Throwable e) {
			log.info("--------------- FAILED ------------------");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	@BeforeSuite
	public void deleteFileInReport() {
		// Remove all file in ReportNG screenshot (image)
		deleteAllFileInFolder("reportNGImage");

		// Remove all file in Allure attachment (json file)
		deleteAllFileInFolder("allure-json");
	}

	public void deleteAllFileInFolder(String folderName) {
		try {
			String pathFolderDownload = GlobalConstants.REPORTNG_IMAGE_PATH;
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			if (listOfFiles.length != 0) {
				for (File listOfFile : listOfFiles) {
					if (listOfFile.isFile() && !listOfFile.getName().equals("environment.properties")) {
						new File(listOfFile.toString()).delete();
					}
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	protected void closeBrowserDriver() {
		String cmd = null;
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
			} else {
				cmd = "pkill " + browserDriverName;
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

//	protected void closeBrowserDriver() {
//		if (driver != null) {
//			driver.manage().deleteAllCookies();
//			driver.quit();
//		}
//		else {
//			driver.quit();
//		}
//	}
}
