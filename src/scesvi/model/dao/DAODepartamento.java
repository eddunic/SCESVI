package scesvi.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import scesvi.model.Departamento;

public class DAODepartamento extends DAO {

	private static Departamento departamento;
	private static int codDep;
	
	public static Departamento getDepartamento() {
		return departamento;
	}
	
	public static int searchDepart(String departamento) {
		String query = "SELECT codigo FROM DEPARTAMENTO WHERE sigla = " + "'" + departamento + "'";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultSet = pst.executeQuery(query);
			while(resultSet.next()) {
				codDep = resultSet.getInt("codigo");
			}
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return codDep;
	}
	
	public static String consultDep(String codDep) {
		String lblText = null;
		String query = "SELECT sigla FROM DEPARTAMENTO WHERE codigo = " + codDep;
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultSet = pst.executeQuery(query);
			while(resultSet.next()) {
				lblText = resultSet.getString("sigla");
	     	}

			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return lblText;
	}
		
}
