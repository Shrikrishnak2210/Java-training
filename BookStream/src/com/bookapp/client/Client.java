package com.bookapp.client;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;

public class Client {

	public static void main(String[] args) {
			try (Scanner scanner = new Scanner(System.in)) {
				IBookService bookService = new BookServiceImpl();
				List<Book> books = bookService.getAll();

				System.out.println("Welcome to Library");
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
						String author = scanner.nextLine();
						try {
							books.stream()
								.filter(book->book.getAuthor().equals(author))
								.collect(Collectors.toList())
								.forEach(System.out::println);
						} catch (BookNotFoundException e) {
							System.out.println(e.getMessage());
						}
						System.out.println();
						break;
					case 2:
						System.out.println("Enter category: ");
						String category = scanner.nextLine();
						try {
							books.stream()
							.filter(book->book.getCategory().equals(category))
							.collect(Collectors.toList())
							.forEach(System.out::println);
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
							books.stream()
							.filter(book->(book.getAuthor().equals(author) && book.getCategory().equals(category)))
							.collect(Collectors.toList())
							.forEach(System.out::println);
						} catch (BookNotFoundException e) {
							System.out.println(e.getMessage());
						}
						System.out.println();
						break;
					case 4:
						System.out.println("Enter bookId: ");
						int bookId = scanner.nextInt();
						try {
							books.stream()
								.filter(book->book.getBookId().equals(bookId))
								.collect(Collectors.toList())
								.forEach(System.out::println);
						} catch (BookNotFoundException e) {
							System.out.println(e.getMessage());
						}
						System.out.println();
						break;
					case 5:
						System.out.println("Enter book price: ");
						double price = scanner.nextDouble();
						try {
							books.stream()
							.filter(book -> book.getPrice() <= price)
							.collect(Collectors.toList())
							.forEach(System.out::println);
						} catch (BookNotFoundException e) {
							System.out.println(e.getMessage());
						}
						System.out.println();
						break;
					case 6:
						books.stream().forEach(System.out::println);
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
			}
	}

}
