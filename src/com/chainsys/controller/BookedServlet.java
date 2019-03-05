package com.chainsys.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.controller.dao.BookDAO;
import com.chainsys.controller.model.Book;


@WebServlet("/BookedServlet")
public class BookedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int isbn = Integer.parseInt(request.getParameter("book"));
		
		BookDAO bookDAO = new BookDAO();
		
		try {
			bookDAO.findByisbn(isbn);
			RequestDispatcher dispatcher = request.getRequestDispatcher("updatedlist.jsp");
			dispatcher.forward(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
