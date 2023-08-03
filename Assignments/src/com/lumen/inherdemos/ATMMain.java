package com.lumen.inherdemos;

import java.util.Scanner;

public class ATMMain {
	public static void main(String[] args) {
		System.out.println("Enter acoount type");
		Scanner scanner = new Scanner(System.in);
		String accountType = scanner.next();
		switch (accountType) {
		case "Savings":
			Savings savings = new Savings(10_000);
			savings.deposit(4_000);
			savings.withdraw(5_000);
			System.out.println("Balance is Rs. " + savings.getBalance());
			break;
		case "Current":
			Current current = new Current(20_000);
			current.deposit(3_000);
			current.withdraw(6_000);
			System.out.println("Balance is Rs. " + current.getBalance());
			break;
		default:
			break;
		}
		scanner.close();
	}
}
