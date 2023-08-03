package com.lumen.quest3;

import java.util.function.BiConsumer;

public class AddUsingConsumerAndLamb {

	public static void main(String[] args) {
		// using lambda
		NewCalculator addition = (operand1, operand2) -> {
			System.out.println(operand1 + operand2);
		};
		addition.calculate(60, 70);

		// using BiConsumer
		BiConsumer<Integer, Integer> additionConsumer = (operand1, operand2) -> System.out.println(operand1 + operand2);
		additionConsumer.accept(10, 20);
	}

}
