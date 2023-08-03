package com.lumen.scan;

import java.util.Scanner;

public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []usernames = { "John", "Namrath", "Hari" };
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name");
		boolean flag = false;
		String username = scanner.next();
		for (String name : usernames) {
			if (name.equals(username)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("You are logged in successfully");
		} else {
			System.out.println("Invalid username");
		}
		scanner.close();
	}

}
