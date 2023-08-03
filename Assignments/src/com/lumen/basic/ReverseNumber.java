package com.lumen.basic;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int reverse = 0;
		int remainder;
		int original;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number");
		int number = scanner.nextInt();
		original=number;
		while (number != 0) {
			remainder = number % 10;
			reverse = reverse * 10 + remainder;
			number /= 10;
		}
		System.out.println("Reverse of " + original + " is " + reverse);
		scanner.close();

	}

}
