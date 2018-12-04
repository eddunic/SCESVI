package scesvi.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import scesvi.model.Cargo;

public class DAOCargo extends DAO {
	
	private static Cargo cargo;
	private static int codCargo;
	
	public static Cargo getCargo() {
		return cargo;
	}
		
	public static int searchCargo(String cargo) {
		String query = "SELECT codigo FROM CARGO WHERE titulacao = " + "'" + cargo + "'";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultSet = pst.executeQuery(query);
			while(resultSet.next()) {
				codCargo = resultSet.getInt("codigo");
			}
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return codCargo;
	}
	
	public static String consultCargo(String codCargo) {
		String lblText = null;
		String query = "SELECT titulacao FROM CARGO WHERE codigo = " + codCargo;
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultSet = pst.executeQuery(query);
			while(resultSet.next()) {
				lblText = resultSet.getString("titulacao");
	     	}

			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return lblText;
	}
		
}
