package com.chainsys.controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.controller.model.Author;
import com.chainsys.controller.model.Book;
import com.chainsys.controller.model.Publication;
import com.chainsys.controller.util.ConnectionUtil;

public class BookDAO {

	public void addBook(Book book) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();

		String sql = "insert into book_details(id,isbn,name,price,publication_id,author_id,status) values(id_seq.NEXTVAL,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, book.getIsbn());
		preparedStatement.setString(2, book.getName());
		preparedStatement.setInt(3, book.getPrice());

		preparedStatement.setInt(4, book.getPublication().getId());
		preparedStatement.setInt(5, book.getAuthor().getId());
		preparedStatement.setInt(6, book.getStatus());
		int rows = preparedStatement.executeUpdate();
		System.out.println("Rows inserted " + rows);
		ConnectionUtil.close(connection, preparedStatement, null);

	}

	public void updateBook(Book book) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "update book_details set price=? where name=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, book.getPrice());
		preparedStatement.setString(2, book.getName());
		int rows = preparedStatement.executeUpdate();
		System.out.println("Rows inserted " + rows);
		ConnectionUtil.close(connection, preparedStatement, null);

	}

	public Book findByBook(Book book) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select id,isbn,name,price from book_details where name=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, book.getName());
		ResultSet resultset = preparedStatement.executeQuery();
		Book book2 = null;

		if (resultset.next()) {
			book2 = new Book();
			book2.setId(resultset.getInt("id"));
			book2.setIsbn(resultset.getInt("isbn"));
			book2.setName(resultset.getString("name"));
			book2.setPrice(resultset.getInt("price"));

		}
		ConnectionUtil.close(connection, preparedStatement, resultset);

		return book2;
	}

	public void findByisbn(int isbn) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "update book_details set status=? where isbn=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, 0);
		preparedStatement.setInt(2, isbn);
		preparedStatement.executeUpdate();

		ConnectionUtil.close(connection, preparedStatement, null);

	}

	public ArrayList<Book> findAll() throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select id,isbn,name,price from book_details";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultset = preparedStatement.executeQuery();
		ArrayList<Book> booklist = new ArrayList<Book>();
		Book book2;

		while (resultset.next()) {

			book2 = new Book();
			book2.setId(resultset.getInt("id"));
			book2.setIsbn(resultset.getInt("isbn"));
			book2.setName(resultset.getString("name"));
			book2.setPrice(resultset.getInt("price"));

			booklist.add(book2);

		}

		ConnectionUtil.close(connection, preparedStatement, resultset);
		return booklist;
	}

	public ArrayList<Book> findAllStatus() throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select id,isbn,name,price from book_details where status=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, 1);
		ResultSet resultset = preparedStatement.executeQuery();
		ArrayList<Book> booklist = new ArrayList<Book>();
		Book book2;

		while (resultset.next()) {

			book2 = new Book();
			book2.setId(resultset.getInt("id"));
			book2.setIsbn(resultset.getInt("isbn"));
			book2.setName(resultset.getString("name"));
			book2.setPrice(resultset.getInt("price"));

			booklist.add(book2);

		}

		ConnectionUtil.close(connection, preparedStatement, resultset);
		return booklist;
	}

	public int getAuthorId(int id) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select author_id from book_details where id=" + id;
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultset = preparedStatement.executeQuery();
		int authorid = 0;
		while (resultset.next()) {

			authorid = resultset.getInt(1);

		}

		ConnectionUtil.close(connection, preparedStatement, resultset);
		return authorid;
	}

	public int getPublicationId(int id) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select publication_id from book_details where id=" + id;
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultset = preparedStatement.executeQuery();
		int publicationid = 0;
		while (resultset.next()) {

			publicationid = resultset.getInt(1);

		}

		ConnectionUtil.close(connection, preparedStatement, resultset);
		return publicationid;
	}

}
