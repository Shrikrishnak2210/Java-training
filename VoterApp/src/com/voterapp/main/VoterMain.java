package com.voterapp.main;

import java.util.Scanner;

import com.voterapp.exception.InValidVoterException;
import com.voterapp.service.ElectionBoothImpl;

public class VoterMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your age");
		int age = scanner.nextInt();
		System.out.println("Enter your locality");
		String locality = scanner.next();
		System.out.println("Enter your Voter ID");
		int voterId = scanner.nextInt();
		ElectionBoothImpl boothImpl = new ElectionBoothImpl();
		try {
			if(boothImpl.checkEligibility(age, locality, voterId)) {
				System.out.println("You are eligible to vote");
			}
		} catch (InValidVoterException e) {
			System.out.println(e.getMessage());
		}
		
		scanner.close();
	}

}
