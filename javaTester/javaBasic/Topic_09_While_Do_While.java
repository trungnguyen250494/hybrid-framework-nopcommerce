package javaBasic;

public class Topic_09_While_Do_While {
	public static void main(String[] args) {

		for (int i = 0; i < 5;i++) {
			System.out.println("For: " + i);

		}
		int i = 0;
		while (i < 5) {
			System.out.println("While: "+ i);
			i++;
		}


		i = 0;
		do {
			System.out.println("Do While: "+ i);
			i++;
		}while (i < 5);

	}

}
