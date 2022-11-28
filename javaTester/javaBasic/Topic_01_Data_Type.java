package javaBasic;

import java.util.Scanner;

public class Topic_01_Data_Type {

	static int studentNumber;
	static boolean status;
	static final String BROWSER_NAME = "firefox"; //constant
	
	String studentName = "Automation FC";
	
	public static void main(String[] args) {
		System.out.println(studentNumber);
		System.out.println(status);
		Topic_01_Data_Type topic_1 = new Topic_01_Data_Type();
		Topic_01_Data_Type topic_2 = new Topic_01_Data_Type();
		Topic_01_Data_Type topic_3 = new Topic_01_Data_Type();
		System.out.println(topic_1.studentName);
		
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		System.out.println(name);
		System.out.print(name);
	}
	
	public String getStudentName() {
		return this.studentName;
	}
	
	public void setStudentName(String stdName) {
		this.studentName = stdName;
	}
}
