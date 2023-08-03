package com.lumen.basic;

import java.util.Scanner;

public class PerfectNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number");
		int number = scanner.nextInt();
		for (int i = 1; i <= number / 2; i++) {
			if (number % i == 0) {
				sum += i;
			}
		}
		if (sum == number) {
			System.out.println("Perfect Number");
		} else {
			System.out.println("Not a Perfect Number");
		}
		scanner.close();

	}

}
