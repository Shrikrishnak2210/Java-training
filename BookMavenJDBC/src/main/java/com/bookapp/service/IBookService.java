package com.bookapp.service;

import java.sql.SQLException;
import java.util.List;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;

public interface IBookService {
	List<Book> getAll() ;
	void addBook(Book book) ;
	void updateBookPrice(int bookId, double price) ;
	void deleteBook(int bookId) ;
	List<Book> getByAuthorContains(String author) ;
	List<Book> getByCategory(String category) throws BookNotFoundException;
	List<Book> getByPriceLessThan(double price) throws BookNotFoundException;
	List<Book> getByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException;
	Book getById(int bookId) throws BookNotFoundException;
}
