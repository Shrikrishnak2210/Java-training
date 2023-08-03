package com.lumen.basic;

import java.util.Scanner;

public class ReverseInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int reverse;
		int remainder;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter total number");
		int total = scanner.nextInt();
		int[] reverseArray = new int[total];
		int[] array = new int[total];
		for (int i = 0; i < total; i++) {
			array[i] = scanner.nextInt();
		}
		for (int i = 0; i < total; i++) {
			reverse = 0;
			while (array[i] != 0) {
				remainder = array[i] % 10;
				reverse = reverse * 10 + remainder;
				array[i] /= 10;
			}
			reverseArray[i] = reverse;
		}
		for (int number : reverseArray) {
			System.out.print(number + " ");
		}
		scanner.close();
	}

}
