package com.chainsys.controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.controller.model.Author;
import com.chainsys.controller.util.ConnectionUtil;

public class AuthorDAO {
      
	public void addAuthor(Author author) throws SQLException {

		Connection connection = ConnectionUtil.getConnection();
		String sql = "insert into author(author_id,author_name) values(author_author_id_seq.NEXTVAL,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, author.getName());
		preparedStatement.executeUpdate();
		ConnectionUtil.close(connection, preparedStatement, null);
	}
      
	public Author findByAuthor(Author author) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select author_id,author_name from author where author_name=? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, author.getName());
		ResultSet resultset = preparedStatement.executeQuery();
		Author author1 = null;
		if (resultset.next()) {
			author1 = new Author();
			author1.setId(resultset.getInt("id"));
			author1.setName(resultset.getString("name"));

		}
		ConnectionUtil.close(connection, preparedStatement, resultset);
		return author1;

	}

	public Author findById(int id) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select author_id,author_name from author where author_id=? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultset = preparedStatement.executeQuery();
		Author author2 = new Author();
		if (resultset.next()) {
			author2 = new Author();
			author2.setId(resultset.getInt("author_id"));
			author2.setName(resultset.getString("author_name"));

		}
		ConnectionUtil.close(connection, preparedStatement, resultset);

		return author2;
	}

	public ArrayList<Author> findAll() throws SQLException {
		ArrayList<Author> authorlist = new ArrayList<Author>();

		Connection connection = ConnectionUtil.getConnection();

		String sql = "select author_id,author_name from author";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultset = preparedStatement.executeQuery();

		Author author3;
		while (resultset.next()) {

			author3 = new Author();
			author3.setId(resultset.getInt("author_id"));
			author3.setName(resultset.getString("author_name"));

			authorlist.add(author3);

		}

		ConnectionUtil.close(connection, preparedStatement, resultset);

		return authorlist;
	}

}
