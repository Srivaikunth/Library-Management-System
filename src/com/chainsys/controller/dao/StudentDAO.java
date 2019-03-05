package com.chainsys.controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chainsys.controller.model.Student;
import com.chainsys.controller.util.ConnectionUtil;

public class StudentDAO {
	public void addStudent(Student student) throws SQLException{
		Connection connection=ConnectionUtil.getConnection();
		String sql="insert into student(student_id,student_name,phone_number,address,password) values(student_student_id_seq.NEXTVAL,?,?,?,?)";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, student.getStudent_name());
		preparedStatement.setLong(2, student.getPhone_number());
		preparedStatement.setString(3, student.getAddress());
		preparedStatement.setString(4, student.getPassword());
		int rows = preparedStatement.executeUpdate();
		System.out.println("Rows inserted " + rows);
		ConnectionUtil.close(connection,preparedStatement,null);
			
	}
	public Boolean checkLogin(Student student) {
		Boolean isFind=false;
		try {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select student_name,password from student where student_name=? and password=?";
		PreparedStatement preparedstatement = connection
		.prepareStatement(sql);
	    String student_name = student.getStudent_name();
		preparedstatement.setString(1, student_name);
		preparedstatement.setString(2, student.getPassword());
		ResultSet resultSet=preparedstatement.executeQuery();

		while(resultSet.next())
		{
		isFind=true;
		break;
		}

		} catch (SQLException e) {
		e.printStackTrace();
		}
		return isFind;

		}


}
