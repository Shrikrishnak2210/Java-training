package com.lumen.basic;

import java.util.Scanner;

public class DuplicatesInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int duplicateCount = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter total number");
		int total = scanner.nextInt();
		int[] array = new int[total];
		for (int i = 0; i < total; i++) {
			array[i] = scanner.nextInt();
		}
		for (int j = 0; j < total; j++) {
			for (int k = j + 1; k < total; k++) {
				if (array[j] == array[k]) {
					duplicateCount++;
					break;
				}
			}
		}
		System.out.println("Duplicates are "+duplicateCount);
		scanner.close();

	}

}
