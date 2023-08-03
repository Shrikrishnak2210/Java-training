package com.lumen.objbasics;

public class Student {
	String name;
	String department;

	public Student(String name, String department) {
		super();
		this.name = name;
		this.department = department;
	}

	void printDetails() {
		System.out.println("Name " + name);
		System.out.println("Department " + department);
	}

	String getGrades(int... marks) {
		int sum = 0;
		int average;
		for (int mark : marks) {
			sum += mark;
		}
		average = sum / marks.length;
		if (average >= 90 && average < 100) {
			return "Grade A";
		} else if (average >= 80 && average < 90) {
			return "Grade B";
		} else if (average >= 70 && average < 80) {
			return "Grade C";
		} else if (average >= 60 && average < 70) {
			return "Grade D";
		} else if (average >= 50 && average < 60) {
			return "GraSSde E";
		} else {
			return "Fail";
		}

	}
}
