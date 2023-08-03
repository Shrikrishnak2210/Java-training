package com.lumen.scan;

import java.util.Scanner;

public class SumAndAvgInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		float average;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter total number");
		int total = scanner.nextInt();
		int[] array = new int[total];
		for (int i = 0; i < total; i++) {
			array[i] = scanner.nextInt();
		}
		for (int i = 0; i < total; i++) {
			sum += array[i];
		}
		average = (float)sum / total;
		System.out.println("Sum is " + sum);
		System.out.println("Average is " + average);
		scanner.close();
	}

}
