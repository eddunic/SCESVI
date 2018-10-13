package scesvi.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import scesvi.MainApp;

public class DAO {

	private MainApp mainApp;
	
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultset = null;

	public static Connection getConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/scesvi", "root", "");
			statement = connection.createStatement();
			System.out.println("Conex�o estabelecida");			
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

	public static ResultSet getResultset() {
		return resultset;
	}

	public static void setResultset(ResultSet resultset) {
		DAO.resultset = resultset;
	}
		
}
