package com.lumen.scan;

import java.util.Scanner;

public class SmallestUsingAnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 3 numbers");
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		int z = scanner.nextInt();
		if (x < y && x < z) {
			System.out.println(x + " is Smallest");
		} else if (y < z) {
			System.out.println(y + " is Smallest");
		} else {
			System.out.println(z + " is Smallest");
		}
		scanner.close();

	}

}
