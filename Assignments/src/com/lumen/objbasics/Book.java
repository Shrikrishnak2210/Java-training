package com.lumen.objbasics;

public class Book {
	String title;
	String author;
	float price;
	
	void printDetails() {
		System.out.println("Title: " + title);
		System.out.println("Author: " + author);
		System.out.println("Book Price: $" + price);
	}
	
	double getDiscountedPrice() {
		return (price - (price*0.1));
	}
	void checkBookType() {
		if(price>500) {
			System.out.println("Premium Book");
		}
		else {
			System.out.println("Standard Book");
		}
	}
}
