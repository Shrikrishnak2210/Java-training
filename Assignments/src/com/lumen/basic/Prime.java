package com.lumen.basic;

import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int flag = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number");
		int number = scanner.nextInt();
		if (number == 0 || number == 1) {
			System.out.println(number + " is not a Prime Number");
		} else {
			for (int i = 2; i <= number / 2; i++) {
				if (number % i == 0) {
					System.out.println(number + " is not a Prime Number");
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				System.out.println(number + " is a Prime Number");
			}
		}
		scanner.close();

	}

}
