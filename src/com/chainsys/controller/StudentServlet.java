package com.chainsys.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.controller.dao.StudentDAO;
import com.chainsys.controller.model.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String student_name=(request.getParameter("student_name"));
		Long phone_number=Long.parseLong(request.getParameter("phone_number"));
		String address=(request.getParameter("address"));
		String password=(request.getParameter("password"));
		
		Student student=new Student();
		
		student.setStudent_name(student_name);
		student.setPhone_number(phone_number);
        student.setAddress(address);
        student.setPassword(password);
        StudentDAO studentDAO=new StudentDAO();
        
        try {
			studentDAO.addStudent(student);
			RequestDispatcher rd=request.getRequestDispatcher("studentlogin.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}


