package com.lumen.objbasics;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student = new Student("John", "CSE");
		student.printDetails();
		System.out.println(student.getGrades(68,84,74,94));
	}

}
