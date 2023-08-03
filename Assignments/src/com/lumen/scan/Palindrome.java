package com.lumen.scan;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		int reverse = 0;
		int remainder;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number");
		int number = scanner.nextInt();
		int original = number;
		while (number != 0) {
			remainder = number % 10;
			reverse = reverse * 10 + remainder;
			number /= 10;
		}
		if (original == reverse) {
			System.out.println(original + " is Palindrome");
		} else {
			System.out.println(original + " is Not Palindrome");
		}
		scanner.close();

	}

}
