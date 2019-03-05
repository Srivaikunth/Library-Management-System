package com.chainsys.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.controller.dao.AuthorDAO;
import com.chainsys.controller.model.Author;

/**
 * Servlet implementation class AddAuthor
 */
@WebServlet("/AddAuthor")
public class AddAuthor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		Author author = new Author();
		author.setName(name);
		AuthorDAO authordao = new AuthorDAO();
		try {
			authordao.addAuthor(author);
			List<Author> authorlist= new ArrayList<Author>();
			authorlist=authordao.findAll();
			System.out.println(authorlist.size());
			request.setAttribute("Authors", authorlist);
			RequestDispatcher rd = request.getRequestDispatcher("listauthor.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
