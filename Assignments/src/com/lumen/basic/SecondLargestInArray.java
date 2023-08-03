package com.lumen.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SecondLargestInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter total number");
		int total = scanner.nextInt();
		Integer[] array = new Integer[total];
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}
		Arrays.sort(array, Collections.reverseOrder());
		System.out.println(array[1] + " is Second Largest in the array");
		scanner.close();
	}

}
