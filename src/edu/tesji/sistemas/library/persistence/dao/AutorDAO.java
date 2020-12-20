package edu.tesji.sistemas.library.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.tesji.sistemas.library.persistence.entities.UserEntity;

public class AutorDAO {

	private PreparedStatement prepStatement;
	private ResultSet resultSet;
	private static final String QUERY_SELECT_ALL_USERS = "SELECT idusuario, nombre, password, status FROM usuarios";
	private static final String QUERY_INSERT_AUTOR = "INSERT INTO autor (nombrecompleto, nacionalidad) values (?, ?)";

	
	public List<UserEntity> selectUsers() {
		List<UserEntity> userList = new ArrayList<UserEntity>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_SELECT_ALL_USERS);
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				UserEntity user = new UserEntity(resultSet.getInt("idusuario"), resultSet.getString("nombre"),
						resultSet.getString("password"), resultSet.getBoolean("status"));
				userList.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return userList;
	}

	public int insertAutor() {
		List<UserEntity> userList = new ArrayList<UserEntity>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_SELECT_ALL_USERS);
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				UserEntity user = new UserEntity(resultSet.getInt("idusuario"), resultSet.getString("nombre"),
						resultSet.getString("password"), resultSet.getBoolean("status"));
				userList.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return -1;
	}
	
	public void updateUser() {

	}

	public void deleteUser() {

	}

}
