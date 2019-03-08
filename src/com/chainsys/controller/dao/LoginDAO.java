package com.chainsys.controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chainsys.controller.model.Login;
import com.chainsys.controller.util.ConnectionUtil;


public class LoginDAO {
	public Boolean checkLogin(Login adminLogin) throws SQLException {
		boolean isActive=false;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select username,password from admin where username=? and password=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, adminLogin.getUsername());
		preparedStatement.setString(2, adminLogin.getPassword());
		ResultSet resultset = preparedStatement.executeQuery();
		if (resultset.next()) {
			isActive=true;
		}
		ConnectionUtil.close(connection,preparedStatement,resultset);
		
		return isActive;
	}
}
