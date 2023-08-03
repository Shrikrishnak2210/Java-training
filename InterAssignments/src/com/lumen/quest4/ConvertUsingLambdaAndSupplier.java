package com.lumen.quest4;

import java.util.function.Supplier;

public class ConvertUsingLambdaAndSupplier {

	public static void main(String[] args) {
		//using Lambda
		ConvertString convertString = (sentence) -> {
			return sentence.toUpperCase();
		};
		System.out.println(convertString.convertToUpperCase("john wick"));
		
		//using Supplier
		Supplier<String> convertStringSupplier = () -> "john wick".toUpperCase();
		String result = convertStringSupplier.get();
		System.out.println(result);
	}

}
