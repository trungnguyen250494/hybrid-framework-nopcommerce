package javaBasic;


import org.testng.annotations.Test;

public class Topic_08_For_Foreach {
	@Test
	public void TC_01() {
		String[] cityNames = {"Ha Noi","Ho Chi Minh","Da Nang","Can Tho"};
		
		for (int i = 0; i < cityNames.length; i++) {
			if(cityNames[i].equals("Ho Chi Minh")) {
				System.out.println(cityNames[i]);
				break;
			}
			System.out.println(cityNames[i]);
		}
		
		
	}
}
