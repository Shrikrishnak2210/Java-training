package com.lumen.basic;

import java.util.Scanner;

public class ArmstrongNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int original;
		int remainder;
		int result = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number");
		int number = scanner.nextInt();
		original = number;
		while (original != 0) {
			remainder = original % 10;
			result += Math.pow(remainder, 3);
			original /= 10;
		}
		if (result == number) {
			System.out.println("Armtrong Number");
		} else {
			System.out.println("Not Armtrong Number");
		}
		scanner.close();
	}

}
