package com.bookapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.BookDetails;

public class BookServiceImpl implements IBookService {
	List<Book> books;

	public BookServiceImpl() {
		super();
		this.books = BookDetails.showBooks();

	}

	@Override
	public List<Book> getAll() {
		return books;
	}

	@Override
	public List<Book> getByAuthorContains(String author) throws BookNotFoundException {
		List<Book> bookByAuthor = new ArrayList<>();
		for (Book book : this.books) {
			if (book.getAuthor().toUpperCase().contains(author.toUpperCase()))
				bookByAuthor.add(book);
		}
		if (bookByAuthor.size() == 0)
			throw new BookNotFoundException("Book not found by author");
		return bookByAuthor;
	}

	@Override
	public List<Book> getByCategory(String category) throws BookNotFoundException {
		List<Book> bookByCategory = new ArrayList<>();
		for (Book book : this.books) {
			if (book.getCategory().contains(category))
				bookByCategory.add(book);
		}
		if (bookByCategory.size() == 0)
			throw new BookNotFoundException("Book not found by author");
		return bookByCategory;
	}

	@Override
	public List<Book> getByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException {
		List<Book> bookByAuthorAndCategory = new ArrayList<>();
		for (Book book : this.books) {
//			System.out.println(book.getAuthor() + " " + author + " " + book.getCategory() + " " + category);
			if (book.getAuthor().equals(author) && book.getCategory().equals(category))
				bookByAuthorAndCategory.add(book);
		}
		if (bookByAuthorAndCategory.size() == 0)
			throw new BookNotFoundException("Book not found by author");
		return bookByAuthorAndCategory;
	}

	@Override
	public Book getById(int bookId) throws BookNotFoundException {
		for (Book book : this.books) {
			if (book.getBookId() == bookId) {
				return book;
			}
		}
		throw new BookNotFoundException("Book not found by ID");
	}

	@Override
	public List<Book> getByPriceLessThan(double price) throws BookNotFoundException {
		List<Book> bookByPrice = new ArrayList<>();
		for (Book book : this.books) {
			if ((Double) book.getPrice() < price)
				bookByPrice.add(book);
		}
		if (bookByPrice.size() == 0)
			throw new BookNotFoundException("Book not found by author");
		return bookByPrice;
	}

}
