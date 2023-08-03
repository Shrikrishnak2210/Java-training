package com.lumen.quest1;

public class CalculatorMain {

	public static void main(String[] args) {
		ICalculator addition = (operand1, operand2) -> {
			System.out.println("Addition " + (operand1 + operand2));
		};
		addition.calculate(4, 6);
		ICalculator subtraction = (operand1, operand2) -> {
			System.out.println("Subtraction "+(operand1 - operand2));
		};
		subtraction.calculate(14, 6);
		ICalculator multiplication = (operand1, operand2) -> {
			System.out.println("Multiplication "+(operand1 * operand2));
		};
		multiplication.calculate(4, 6);
		ICalculator division = (operand1, operand2) -> {
			System.out.println("Division "+(operand1 / operand2));
		};
		division.calculate(48, 6);
	}
}
