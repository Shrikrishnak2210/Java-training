package com.lumen.basic;

import java.util.Scanner;

public class PyramidWithStars2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number");
		int number = scanner.nextInt();
		for (int i = number; i > 0 ; i--) {
			for (int j = i; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		scanner.close();
	}

}
