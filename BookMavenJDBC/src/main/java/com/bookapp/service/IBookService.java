package com.bookapp.service;

import java.sql.SQLException;
import java.util.List;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;

public interface IBookService {
	List<Book> getAll() throws SQLException;
	void addBook(Book book) throws SQLException;
	void updateBookPrice(int bookId, double price) throws SQLException;
	void deleteBook(int bookId) throws SQLException;
	List<Book> getByAuthorContains(String author) throws BookNotFoundException;
	List<Book> getByCategory(String category) throws BookNotFoundException, SQLException;
	List<Book> getByPriceLessThan(double price) throws BookNotFoundException, SQLException;
	List<Book> getByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException, SQLException;
	Book getById(int bookId) throws BookNotFoundException, SQLException;
}
