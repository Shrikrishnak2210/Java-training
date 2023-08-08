package com.bookapp.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;

/**
 * Servlet implementation class GetAllBooksServlet
 */
@WebServlet("/")
public class GetAllBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBookService bookService = new BookServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllBooksServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get data from service
		List<Book> books = bookService.getAll();
		//assign a reference name for the list
		request.setAttribute("books", books);
		//send to view page
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
