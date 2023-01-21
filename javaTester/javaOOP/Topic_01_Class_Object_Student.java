package javaOOP;

public class Topic_01_Class_Object_Student {
	private int studentID;
	private String studentName;
	private Float knowledgePoint;
	private Float practicePoint;
	
	private int getStudentID() {
		return studentID;
	}
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Float getKnowledgePoint() {
		return knowledgePoint;
	}

	public void setKnowledgePoint(Float knowledgePoint) {
		this.knowledgePoint = knowledgePoint;
	}

	public Float getPracticePoint() {
		return practicePoint;
	}

	public void setPracticePoint(Float practicePoint) {
		this.practicePoint = practicePoint;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Topic_01_Class_Object_Student firstStudent = new Topic_01_Class_Object_Student();
		firstStudent.setStudentID(123456);
		firstStudent.setStudentName("Black Adam");
		firstStudent.setKnowledgePoint(8.0f);
		firstStudent.setPracticePoint(7.0f);
		firstStudent.showStudentInfo();

	}
	
	private Float getAveragePoint() {
		return (knowledgePoint + practicePoint * 2) / 3;
	}

	private void showStudentInfo() {
		// TODO Auto-generated method stub
		System.out.println("*****************************\n");
		System.out.println("Student ID = "+getStudentID()+ " \n");
		System.out.println("Student Name = "+getStudentName()+ " \n");
		System.out.println("Student Knowledge point = "+getKnowledgePoint()+ " \n");
		System.out.println("Student Practice point = "+getPracticePoint()+ " \n");
		System.out.println("Student Average Point = "+getAveragePoint()+ " \n");
		
	}

}
