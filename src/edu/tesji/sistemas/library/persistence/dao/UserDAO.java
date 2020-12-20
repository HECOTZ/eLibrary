package edu.tesji.sistemas.library.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.tesji.sistemas.library.controller.LoginController;
import edu.tesji.sistemas.library.persistence.entities.UserEntity;

public class UserDAO {

	private PreparedStatement prepStatement;
	private ResultSet resultSet;
	private static final String QUERY_SELECT_ALL_USERS = "SELECT idusuario, nombre, password, status FROM usuario";

	private static final Logger log = Logger.getLogger(UserDAO.class);
	
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
			log.error("error sql al selcccionar users", e);
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


	public int insertUser(String nombreCompleto, String nacionalidad) {
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement("INSERT INTO autor (nombrecompleto, nacionalidad) values (?, ?)");
			prepStatement.setString(1, nombreCompleto);
			prepStatement.setString(2, nacionalidad);
			
			int insertedRows = prepStatement.executeUpdate();
			
			if (insertedRows == 1) {
				log.info("Se ha insertado correctamente el registro [nombreCompleto=" + nombreCompleto + ", nacionalidad=" + nacionalidad + "]");
			} else {
				log.info("NO se ha insertado el registro [nombreCompleto=" + nombreCompleto + ", nacionalidad=" + nacionalidad + "]");
			}

		} catch (SQLException e) {
			log.error("SQLException", e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					log.error("SQLException", e);
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
