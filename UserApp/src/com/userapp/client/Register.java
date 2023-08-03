package com.userapp.client;

import java.util.Scanner;

import com.user.exception.NameExistException;
import com.user.exception.TooLongException;
import com.user.exception.TooShortException;
import com.user.service.ValidationServiceImplementation;

public class Register {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ValidationServiceImplementation validate = new ValidationServiceImplementation();
		try {
			System.out.println("Enter username");
			String username = scanner.next();
			if (validate.validateUsername(username)) {
				System.out.println("Enter password");
				String password = scanner.next();
				if (validate.validatePassword(password)) {
					System.out.println("User can vote");
				}
			}
		} catch (NameExistException | TooLongException | TooShortException e) {
			System.out.println(e.getMessage());
		} finally {
			scanner.close();
		}

	}

}
