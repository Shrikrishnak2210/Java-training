package com.lumen.scan;

import java.util.Scanner;

public class GreatestUsingTernary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 3 numbers");
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		int z = scanner.nextInt();
		String result = (x > y && x > z) ? x + " is Greater" : ((y > z) ? y + " is Greater" : z + " is Greater");
		System.out.println(result);
		scanner.close();

	}

}
