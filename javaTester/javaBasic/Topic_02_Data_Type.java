package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_02_Data_Type {
	//Primitive type/ value type: Nguyên thủy
	byte number = 6;

	short sNumber = 1500;

	int iNumber = 65000;

	long lNumber = 65000;

	float fNumber = 15.98f;

	double dNumber = 15.98;

	char cChar = '1';

	boolean bStatus;

	//Preference type: Tham chiếu

	// Array
	String[] studentAddress = {"address","Da Nang","Sai gon"};
	Integer[] studentnumbers = {15,20,50};

	// String
	String address = "Sai Gon";

	// Class
	Topic_02_Data_Type topic;

	// Interface
	WebDriver driver;

	// Object
	Object aObject;

	// Collection
	// List/Set/Queue/Map
	List<WebElement> homePageLinks = driver.findElements(By.tagName("a"));
	Set<String> allWindows = driver.getWindowHandles();
	List<String> listStudents = new ArrayList<>();

	public void clickToElement() {
		address.trim();

		studentAddress.clone();

		driver.getCurrentUrl();

		aObject.toString();


	}

	public static void main(String[] args) {

	}

}
