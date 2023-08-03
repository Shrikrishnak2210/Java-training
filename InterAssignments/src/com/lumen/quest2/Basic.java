package com.lumen.quest2;

public class Basic implements IBasicCalculator {

	@Override
	public void add(int operand1, int operand2) {
		System.out.println("Addition " + (operand1 + operand2));
	}

	@Override
	public void difference(int operand1, int operand2) {
		System.out.println("Subtraction " + (operand1 - operand2));
	}

	@Override
	public void product(int operand1, int operand2) {
		System.out.println("Multiplication " + (operand1 * operand2));

	}

	@Override
	public void divide(int operand1, int operand2) {
		System.out.println("Division " + (operand1 / operand2));

	}

}
