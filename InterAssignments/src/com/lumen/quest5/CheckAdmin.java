package com.lumen.quest5;

import java.util.function.BiConsumer;

public class CheckAdmin {

	public static void main(String[] args) {
		BiConsumer<String, Integer> checkAdmin = (name, age) -> {
			if (name.equals("Admin") && age > 30)
				System.out.println("Welcome Admin");
			else
				System.out.println("Wrong user");
		};
		checkAdmin.accept("Admin", 31);
	}

}
