package com.bookapp.service;

import java.sql.SQLException;
import java.util.List;
import com.bookapp.dao.BookDaoImpl;
import com.bookapp.dao.IBookDao;
import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;

public class BookServiceImpl implements IBookService {
	IBookDao bookDao = new BookDaoImpl();

	@Override
	public List<Book> getAll() throws SQLException {
		return bookDao.findAll();
	}

	@Override
	public void addBook(Book book) throws SQLException {
		bookDao.addBook(book);
	}

	@Override
	public void updateBookPrice(int bookId, double price) throws SQLException {

		bookDao.updateBook(bookId, price);

	}

	@Override
	public void deleteBook(int bookId) throws SQLException {
		bookDao.deleteBook(bookId);

	}

	@Override
	public List<Book> getByAuthorContains(String author) throws BookNotFoundException {
		List<Book> books = bookDao.getByAuthorContains(author);
		if (books.isEmpty())
			throw new BookNotFoundException("books not found by author");
		return books.stream().sorted((o1, o2) -> o1.compareTo(o2)).toList();
	}

	@Override
	public List<Book> getByCategory(String category) throws BookNotFoundException, SQLException {
		List<Book> books = bookDao.getByCategory(category);
		if (books.isEmpty())
			throw new SQLException("books not found by category");
		return books.stream().sorted((o1, o2) -> o1.compareTo(o2)).toList();
	}

	@Override
	public List<Book> getByPriceLessThan(double price) throws BookNotFoundException, SQLException {
		List<Book> books = bookDao.getByPriceLessThan(price);
		if (books.isEmpty())
			throw new BookNotFoundException("books not found below the given price");
		return books.stream().sorted((o1, o2) -> o1.compareTo(o2)).toList();
	}

	@Override
	public List<Book> getByAuthorContainsAndCategory(String author, String category)
			throws BookNotFoundException, SQLException {
		List<Book> books = bookDao.getByAuthorContainsAndCategory(author, category);
		if (books.isEmpty())
			throw new BookNotFoundException("books not found by author and category");
		return books.stream().sorted((o1, o2) -> o1.compareTo(o2)).toList();
	}

	@Override
	public Book getById(int bookId) throws BookNotFoundException, SQLException {
		Book book = bookDao.getById(bookId);
		if (book == null)
			throw new BookNotFoundException("");
		return book;
	}

}
