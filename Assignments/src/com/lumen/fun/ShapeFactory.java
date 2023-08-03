package com.lumen.fun;

public class ShapeFactory {
	void printArea(Shape shape, double x, double y) {
		System.out.println("Printing Area");
		System.out.println(shape.calcArea(x, y));
		System.out.println("done");
	}

}
