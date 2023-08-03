package com.lumen.fun;

public class FunMain {

	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		shapeFactory.printArea((double x, double y) -> {
			return (x * y);
		}, 10, 50);

		shapeFactory.printArea((double x, double y) -> {
			return (0.5 * x * y);
		}, 10, 50);
	}

}
