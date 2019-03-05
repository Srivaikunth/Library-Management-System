 package com.chainsys.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.controller.dao.AuthorDAO;
import com.chainsys.controller.dao.LoginDAO;
import com.chainsys.controller.dao.PublicationDAO;
import com.chainsys.controller.model.Author;
import com.chainsys.controller.model.Login;
import com.chainsys.controller.model.Publication;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = (request.getParameter("username"));
		String password = (request.getParameter("password"));
		Login login = new Login();
		login.setUsername(username);
		login.setPassword(password);
		ArrayList<Login> logindet = new ArrayList<>();

		LoginDAO loginDAO = new LoginDAO();
		try {
			logindet.add(login);
			if (loginDAO.checkLogin(login).equals(true)) {
				
				RequestDispatcher rdDispatcher = request
						.getRequestDispatcher("home.jsp");
				rdDispatcher.forward(request, response);
			} else {
			
				RequestDispatcher rdDispatcher = request
						.getRequestDispatcher("adminlogin.jsp");
				rdDispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
