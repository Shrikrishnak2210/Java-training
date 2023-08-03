package com.lumen.scan;

import java.util.Scanner;

public class SqRootInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter total number");
		int total = scanner.nextInt();
		int[] array = new int[total];
		float[] squareRootArray = new float[total];
		for (int i = 0; i < total; i++) {
			array[i] = scanner.nextInt();
		}
		for (int j = 0; j < total; j++) {
			squareRootArray[j] = (float) Math.sqrt(array[j]);
		}
		System.out.println("Square root of array is");
		for (float number : squareRootArray) {
			System.out.print(number + " ");
		}
		scanner.close();

	}

}
