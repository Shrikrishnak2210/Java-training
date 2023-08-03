package com.lumen.absdemos;

public class Savings extends Account {

	public Savings(double balance) {
		super(balance);
	}

	@Override
	void withdraw(double amount) {
		System.out.println("Amount withdrawn " + amount);
		balance = balance - (amount + amount * 0.1);
	}

	@Override
	void deposit(double amount) {
		System.out.println("Amount deposited " + amount);
		balance = balance + amount;
	}

}
