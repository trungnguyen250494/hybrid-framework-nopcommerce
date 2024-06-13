package javaBasic;

public class Topic_11_Array {
	public static void main(String[] args) {

		for (int i = 0; i < 5;i++) {
			System.out.println("Lần chạy cũa i = " + i);

			for (int j = 0; j <= 5; j++) {
				if (j == 4) {
					continue;
				}

				System.out.println("j = "+ j);
			}

		}

	}

}
