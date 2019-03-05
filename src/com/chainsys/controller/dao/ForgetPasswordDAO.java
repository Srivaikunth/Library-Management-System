package com.chainsys.controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.chainsys.controller.model.Student;
import com.chainsys.controller.util.ConnectionUtil;

public class ForgetPasswordDAO {
	
	public void forgetpassword(Student student) throws SQLException
	{
		Connection connection=ConnectionUtil.getConnection();
		String sql="update student set password=? where phone_number=?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1,student.getPassword());
		preparedStatement.setLong(2,student.getPhone_number());
		preparedStatement.executeUpdate();
		ConnectionUtil.close(connection,preparedStatement,null);
	}

}
