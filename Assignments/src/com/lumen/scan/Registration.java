package com.lumen.scan;

import java.util.Scanner;

public class Registration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []usernames = { "John", "Namrath", "Hari" };
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name to register");
		boolean flag = false;
		String username = scanner.next();
		for (String name : usernames) {
			if (name.equals(username)) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("You are registered");
		} else {
			System.out.println("Name is not unique");
		}
		scanner.close();
	}
}
