package com.lumen.basic;

public class Greater {

	public static void main(String[] args) {
		int x = 400;
		int y = 60;
		int z = 118;
		if (x > y && x > z) {
			System.out.println("X is Greater");
		} else if (y > z) {
			System.out.println("Y is Greater");
		} else {
			System.out.println("Z is Greater");
		}
	}

}
