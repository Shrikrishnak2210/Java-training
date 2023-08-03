package com.lumen.basic;

import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int first = 0;
		int second = 1;
		int third;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter last number");
		int number = scanner.nextInt();
		System.out.print(first + " " + second);
		for (int i = 2; i < number; ++i) {
			third = first + second;
			System.out.print(" " + third);
			first = second;
			second = third;
		}
		scanner.close();
	}

}
