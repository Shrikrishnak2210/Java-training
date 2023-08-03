package com.lumen.basic;

import java.util.Arrays;
import java.util.Scanner;

public class SecondSmall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter total number");
		int total = scanner.nextInt();
		int[] array = new int[total];
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}
		Arrays.sort(array);
		System.out.println(array[1] + " is Second Smallest in the array");
		scanner.close();

	}

}
