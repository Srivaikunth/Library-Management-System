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
import com.chainsys.controller.dao.PublicationDAO;
import com.chainsys.controller.model.Author;
import com.chainsys.controller.model.Publication;

/**
 * Servlet implementation class AddPublication
 */
@WebServlet("/AddPublication")
public class AddPublication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPublication() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		PublicationDAO publicationdao = new PublicationDAO();
		Publication publication = new Publication();

		publication.setName(name);
		
		try {
			publicationdao.addPublication(publication);
			List<Publication> publicationlist= new ArrayList<Publication>();
			publicationlist=publicationdao.findAll(publication);
			request.setAttribute("Publications", publicationlist);
			RequestDispatcher rd = request.getRequestDispatcher("listpublication.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
