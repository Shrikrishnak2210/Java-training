package com.lumen.basic;

import java.util.Scanner;

public class ArrayScan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int sum = 0;
		int marks[] = new int[4];
		for (int i = 0; i < marks.length; i++) {
			System.out.println("Enter mark");
			marks[i] = scanner.nextInt();
		}
		for (int i = 0; i < marks.length; i++) {
			sum += marks[i];
		}
		System.out.println("Sum " + sum);
		scanner.close();
	}

}
