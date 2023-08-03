package com.lumen.basic;

import java.util.Scanner;

public class PyramidWithStars1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number");
		int number = scanner.nextInt();
		for (int i = 1; i <= number; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		scanner.close();
	}

}
