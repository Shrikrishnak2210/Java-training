package com.lumen.basic;

import java.util.Scanner;

public class Smaller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter one number: ");
		int x = scanner.nextInt();
		System.out.print("Enter another number: ");
		int y = scanner.nextInt();
		if (x < y) {
			System.out.println("First number is Smaller");
		} else {
			System.out.println("Second number is Smaller");
		}
	}

}
