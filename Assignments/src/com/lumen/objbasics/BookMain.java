package com.lumen.objbasics;

public class BookMain {

	public static void main(String[] args) {
		Book book1 = new Book();
		book1.title = "Song of Fire and Ice";
		book1.author = "George RR Martin";
		book1.price = 510;
		book1.printDetails();
		System.out.println("Discounted Price: $" + book1.getDiscountedPrice());
		book1.checkBookType();

		System.out.println();
		Book book2 = new Book();
		book2.title = "Harry Potter";
		book2.author = "J K Rowling";
		book2.price = 160;
		book2.printDetails();
		System.out.println("Discounted Price: $" + book2.getDiscountedPrice());
		book2.checkBookType();
	}

}
