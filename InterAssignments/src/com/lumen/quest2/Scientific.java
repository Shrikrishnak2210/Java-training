package com.lumen.quest2;

public class Scientific extends Basic implements IScientificCalculator {

	@Override
	public void square(int x) {
		System.out.println("Square " + (x * x));
	}

	@Override
	public void cube(int x) {
		System.out.println("Cube " + (x * x * x));
	}

	
	

}
