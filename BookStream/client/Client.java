package com.bookapp.client;

import java.util.List;
import java.util.Scanner;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;

public class Client {

	public static void main(String[] args) {

		IBookService bookService = new BookServiceImpl();

		String author;
		String category;
		int bookId;
		double price;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to Library");
		try {
			while (true) {
				System.out.println("1.Search books by author\n2.Search books by category\n"
						+ "3.Search books by author and category\n4.Search books by bookId\n"
						+ "5.Search books by price\n6.Show all books\n7.Exit");
				System.out.println("Enter choice:");
				int choice = scanner.nextInt();
				scanner.nextLine();
				switch (choice) {
				case 1:
					System.out.println("Enter author name: ");
					author = scanner.nextLine();
					try {
						bookService.getByAuthorContains(author).forEach(System.out::println);
					} catch (BookNotFoundException e) {
						System.out.println(e.getMessage());
					}
					System.out.println();
					break;
				case 2:
					System.out.println("Enter category: ");
					category = scanner.nextLine();
					try {
						bookService.getByCategory(category).forEach(System.out::println);
					} catch (BookNotFoundException e) {
						System.out.println(e.getMessage());
					}
					System.out.println();
					break;
				case 3:
					System.out.println("Enter author name: ");
					author = scanner.nextLine();
					System.out.println("Enter category: ");
					category = scanner.nextLine();
					try {
						bookService.getByAuthorContainsAndCategory(author, category).forEach(System.out::println);
					} catch (BookNotFoundException e) {
						System.out.println(e.getMessage());
					}
					System.out.println();
					break;
				case 4:
					System.out.println("Enter bookId: ");
					bookId = scanner.nextInt();
					try {
						System.out.println(bookService.getById(bookId));
					} catch (BookNotFoundException e) {
						System.out.println(e.getMessage());
					}
					System.out.println();
					break;
				case 5:
					System.out.println("Enter book price: ");
					price = scanner.nextDouble();
					try {
						bookService.getByPriceLessThan(price).forEach(System.out::println);
					} catch (BookNotFoundException e) {
						System.out.println(e.getMessage());
					}
					System.out.println();
					break;
				case 6:
					List<Book> books = bookService.getAll();
					System.out.println("\nBooks available in Library");
					for (Book book : books) {
						System.out.println(book);
					}
					System.out.println();
					break;
				case 7:
					System.exit(0);
				default:
					System.out.println("Invalid choice");
					System.out.println();
					break;
				}
			}

		} catch (Exception e) {
			e.getMessage();
		} finally {
			scanner.close();
		}

	}

}
