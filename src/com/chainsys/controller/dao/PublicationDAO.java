package com.chainsys.controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.controller.model.Publication;
import com.chainsys.controller.util.ConnectionUtil;

public class PublicationDAO {
	
	public void addPublication(Publication publication) throws SQLException{
		Connection connection =ConnectionUtil.getConnection();
		String sql="insert into publication(id,name) values(publication_id_seq.NEXTVAL,?)";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1,publication.getName());
		int rows = preparedStatement.executeUpdate();
		System.out.println("Rows inserted " + rows);
		ConnectionUtil.close(connection,preparedStatement,null);
		
		
		
	}
	public Publication findById(int id) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select id,name from publication where id=? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultset = preparedStatement.executeQuery();
		Publication publication = new Publication();
		if (resultset.next()) {
			publication = new Publication();
			publication.setId(resultset.getInt("id"));
			publication.setName(resultset.getString("name"));

		}
		ConnectionUtil.close(connection,preparedStatement,resultset);
		
		return publication;
	}
	
	public ArrayList<Publication> findAll(Publication publication) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select id,name from publication";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultset = preparedStatement.executeQuery();
		ArrayList<Publication> publicationlist = new ArrayList<Publication>();
		Publication publication1;
		while (resultset.next()) {

			publication1 = new Publication();
			publication1.setId(resultset.getInt("id"));
			publication1.setName(resultset.getString("name"));

			publicationlist.add(publication1);

		}
		ConnectionUtil.close(connection,preparedStatement,resultset);
		
		return publicationlist;
	}

}
