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

import com.chainsys.controller.dao.AuthorDAO;
import com.chainsys.controller.dao.PublicationDAO;
import com.chainsys.controller.model.Author;
import com.chainsys.controller.model.Publication;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AuthorDAO authordao=new AuthorDAO();
		PublicationDAO publicationDAO=new PublicationDAO();
		Author author=new Author();
		Publication publication=new Publication();
		ArrayList<Author> authorList=new ArrayList<Author>();
		ArrayList<Publication> publicationList=new ArrayList<Publication>();
		try {
			authorList.addAll(authordao.findAll());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			publicationList.addAll(publicationDAO.findAll(publication));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("Authorname", authorList);
		request.setAttribute("Publicationname", publicationList);
		RequestDispatcher rdDispatcher=request.getRequestDispatcher("addbook.jsp");
		rdDispatcher.forward(request, response);
	}

}
