package com.chainsys.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.chainsys.controller.dao.BookDAO;
import com.chainsys.controller.dao.PublicationDAO;
import com.chainsys.controller.model.Author;
import com.chainsys.controller.model.Book;
import com.chainsys.controller.model.Publication;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int isbn=Integer.parseInt(request.getParameter("isbn"));
		String name=request.getParameter("name");
		int price=Integer.parseInt(request.getParameter("price"));
		String authorid=request.getParameter("authorname");
		String publicationid=request.getParameter("publicationid");
		Book book=new Book();
		Publication publication=new Publication();
		Author author=new Author();
		AuthorDAO authordao=new AuthorDAO();
		PublicationDAO publicationdao=new PublicationDAO();
		author.setId(Integer.parseInt(authorid));
		publication.setId(Integer.parseInt(publicationid));
		book.setIsbn(isbn);
		book.setStatus(1);
		book.setName(name);
		book.setPrice(price);
		book.setPublication(publication);
		book.setAuthor(author);
		
		BookDAO bookdao=new BookDAO();
		try {
			bookdao.addBook(book);
			
			List<Book> list=new ArrayList<Book>();
			
			list=bookdao.findAll();
			int id=0;
			int authorid1=0;
			int publicationid1=0;
			for(Book book1:list)
			{
				author=new Author();
				id=book1.getId();//get book id
				authorid1=bookdao.getAuthorId(id);//get author id from bookid
				author=authordao.findById(authorid1);//get authorname from author id
				book1.setAuthor(author);
				
			    publication=new Publication();
				publicationid1=bookdao.getPublicationId(id);//get publi id from bookid
				publication=publicationdao.findById(publicationid1);//get publname from publ id
				book1.setPublication(publication);
				
				
				
			}
		
			
			request.setAttribute("BOOKS", list);
			RequestDispatcher rd=request.getRequestDispatcher("listbook.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
