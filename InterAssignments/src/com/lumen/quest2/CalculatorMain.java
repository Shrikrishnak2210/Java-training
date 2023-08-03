package com.lumen.quest2;

public class CalculatorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IBasicCalculator calculator = new Basic();
		calculator.add(4, 5);
		calculator.product(3, 2);
		calculator.difference(5, 2);
		calculator.divide(6, 3);

		IScientificCalculator scientific = new Scientific();
		scientific.add(4, 5);
		scientific.product(3, 2);
		scientific.cube(4);
		scientific.square(2);

	}

}
