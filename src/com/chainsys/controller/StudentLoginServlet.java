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
import com.chainsys.controller.dao.BookDAO;
import com.chainsys.controller.dao.LoginDAO;
import com.chainsys.controller.dao.PublicationDAO;
import com.chainsys.controller.dao.StudentDAO;
import com.chainsys.controller.model.Author;
import com.chainsys.controller.model.Book;
import com.chainsys.controller.model.Publication;
import com.chainsys.controller.model.Student;

/**
 * Servlet implementation class StudentLoginServlet
 */
@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String student_name=(request.getParameter("student_name"));
		String password= request.getParameter("password");
		
		Student student=new Student();
		student.setStudent_name(student_name);
		student.setPassword(password);
		Author author =new Author();
		ArrayList<Book> list=new ArrayList<Book>();
		AuthorDAO authorDAO = new AuthorDAO();
		PublicationDAO publicationDAO=new  PublicationDAO();
		Publication publication=null;
		BookDAO bookDAO = new BookDAO();
		
		StudentDAO studentdao=new StudentDAO();
		try {
			if(studentdao.checkLogin(student)){
						
						list=bookDAO.findAllStatus();
						
						int id=0;
						int authorid1=0;
						int publicationid1=0;
						for(Book book1:list)
						{
							author=new Author();
							id=book1.getId();//get book id
							authorid1=bookDAO.getAuthorId(id);//get author id from bookid
							author=authorDAO.findById(authorid1);//get authorname from author id
							book1.setAuthor(author);
							
						    publication=new Publication();
							publicationid1=bookDAO.getPublicationId(id);//get publi id from bookid
							publication=publicationDAO.findById(publicationid1);//get publname from publ id
							book1.setPublication(publication);
							
							
							
						}
						
						request.setAttribute("BOOKS", list);
						
						RequestDispatcher rd=request.getRequestDispatcher("studentview.jsp");
						rd.forward(request, response);
			}
			else{
				String status="Invalid username or password";
				request.setAttribute("status", status);
				RequestDispatcher rd=request.getRequestDispatcher("studentlogin.jsp");
				rd.forward(request, response);
				
			}
		} catch
		(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
}
