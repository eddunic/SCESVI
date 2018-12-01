package scesvi.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;

	public static Connection getConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SCESVI", "root", "");
			statement = connection.createStatement();		
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return connection;
	}

	public static boolean isConnected() {
		if (connection != null) {
			return true;
		} else {
			return false;
		}
	}

	public static void disconnection() {
		try {
			connection.close();
		}catch(SQLException e) {
			System.out.println("Erro: "+ e);
		}
	}
	
	public static Statement getStatement() {
		return statement;
	}

	public static ResultSet getResultSet() {
		return resultSet;
	}

	public static void setResultSet(ResultSet resultSet) {
		DAO.resultSet = resultSet;
	}
		
}
