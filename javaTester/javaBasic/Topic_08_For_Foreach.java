package javaBasic;


import org.testng.annotations.Test;

public class Topic_08_For_Foreach {
	@Test
	public void TC_01() {
		String[] cityNames = {"Ha Noi","Ho Chi Minh","Da Nang","Can Tho"};

		for (String cityName : cityNames) {
			if(cityName.equals("Ho Chi Minh")) {
				System.out.println(cityName);
				break;
			}
			System.out.println(cityName);
		}


	}
}
