package com.lumen.absdemos;

public class Current extends Account {

	public Current(double balance) {
		super(balance);
		// TODO Auto-generated constructor stub
	}

	@Override
	void withdraw(double amount) {
		// TODO Auto-generated method stub
		System.out.println("Amount withdrawn " + amount);
		balance = balance - (amount + amount * 0.2);
	}

	@Override
	void deposit(double amount) {
		// TODO Auto-generated method stub
		System.out.println("Amount deposited " + amount);
		balance = balance + amount;
	}

}
