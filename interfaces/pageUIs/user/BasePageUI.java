package pageUIs.user;

public class BasePageUI {

	public static final String ADDRESS_LINK = "xpath=//div[@class='block block-account-navigation']//a[text()='Addresses']";
	public static final String PRODUCT_REVIEW_LINK = "xpath=//div[@class='block block-account-navigation']//a[text()='My product reviews']";
	public static final String REWARD_POINT_LINK = "xpath=//div[@class='block block-account-navigation']//a[text()='Reward points']";
	public static final String CUSTOMER_INFO_LINK = "xpath=//div[@class='block block-account-navigation']//a[text()='Customer info']";
	public static final String LOGOUT_LINK_AT_USER = "class=ico-logout";
	public static final String LOGOUT_LINK_AT_ADMIN = "xpath=//a[text()='Logout']";
	public static String DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA = "xpath=//div[@class='block block-account-navigation']//a[text()='%s']";
	public static String DYNAMIC_LINK_BY_PAGE_NAME ="xpath=//div[contains(@class,'%s')]//a[text()='%s']";

}
