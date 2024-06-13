package eclipseTips;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_02_Debug {
	String projectPath = System.getProperty("user.dir");
	WebDriver driver;

	@Test
	public void TC_01() {
		System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");

		driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		String headerText = driver.findElement(By.xpath("//h2[contains(text(),\"Facebook helps\")]")).getText();
		Assert.assertEquals(headerText, "Facebook giúp bạn kết nối và chia sẻ với mọi người trong cuộc sống của bạn.");

		driver.quit();

	}

}
