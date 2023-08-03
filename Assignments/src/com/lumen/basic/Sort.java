package com.lumen.basic;

import java.util.Arrays;
import java.util.Scanner;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter total number");
		int total = scanner.nextInt();
		Integer[] array = new Integer[total];
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}
		System.out.println("Original array");
		for (Integer integer : array) {
			System.out.print(integer+" ");
		}
		Arrays.sort(array);
		System.out.println("\nSorted array");
		for (Integer integer : array) {
			System.out.print(integer+" ");
		}
		scanner.close();
	}

}
