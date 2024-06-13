package javaBasic;

import java.util.Arrays;
import java.util.Collections;

import org.testng.annotations.Test;

public class Topic_12_String {
	public static String schoolName = "Automation Testing";
	static String courseName = "AUTOMATION TESTING";
	static String schoolAddress = "Sai Gon";
	public static void main(String[] args) {
		System.out.println("Độ dài bằng = "+ schoolName.length());
		System.out.println("Lấy ra 1 ký tự = " + schoolName.charAt(0) );
		System.out.println("Nối 2 chuỗi = " + schoolName.concat(schoolAddress));
		System.out.println("Nối 2 chuỗi = " + schoolName + " " + schoolAddress);
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = "+ schoolName.equals(courseName));
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tương đối = " + schoolName.equalsIgnoreCase(courseName));
		System.out.println("Chuỗi bắt đầu bằng A =  "+ schoolName.startsWith("A") );
		System.out.println("Chuỗi kết thúc bằng A = " + schoolName.endsWith("A"));
		System.out.println("Chuỗi lowercase = "+ schoolName.toLowerCase());
		System.out.println("Vị trí của ký tự A đầu tiên trong chuỗi = " + schoolName.indexOf("A"));

		String dynamicLocator = "//input[@id = %s]";
		System.out.println(String.format(dynamicLocator, "login"));

	}

	@Test
	public void TC_01() {
		char courseNameArr[] = schoolName.toCharArray();
		int countUppercase = 0;
		int countLowercase = 0;
		int countNumber = 0;


		for (char character : courseNameArr) {
			if (character <= 'Z' && character >= 'A') {
				countUppercase++;
			}
		}

		for (char character : courseNameArr) {
			if (character <= 'z' && character >= 'a') {
				countLowercase++;
			}
		}

		for (char character : courseNameArr) {
			if (character <= '9' && character >= '0') {
				countNumber++;
			}
		}

		System.out.println("Sum of upper case = "+ countUppercase);
		System.out.println("Sum of lower case = "+ countLowercase);
		System.out.println("Sum of number = "+ countNumber);
	}

	@Test
	public void TC_02() {
		char courseNameArr[] = schoolName.toCharArray();
		int count = 0;


		for (char character : courseNameArr) {
			if (character == 'a') {
				count++;
			}
		}

		System.out.println("Sum of 'a' character = "+ count);
	}

	@Test
	public void TC_03() {
		char courseNameArr[] = schoolName.toCharArray();

		Collections.reverse(Arrays.asList(courseNameArr));

		for (char c : courseNameArr) {
			System.out.println(c);
		}
	}

}
