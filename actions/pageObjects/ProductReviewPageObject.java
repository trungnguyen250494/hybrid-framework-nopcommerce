package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class ProductReviewPageObject extends BasePage{
	private WebDriver driver;

	public ProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
