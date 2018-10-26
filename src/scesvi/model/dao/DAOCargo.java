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
	
//	public static void insert(Cargo cargo) {
//		String query = "INSERT INTO CARGO VALUES(?,?)";
//		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
//			pst.setString(1, String.valueOf(cargo.getCodigo()));
//			pst.setString(2, cargo.getTitulacao());
//
//			pst.executeUpdate();
//			pst.close();
//			disconnection();
//		} catch (SQLException e) {
//			System.out.println("Erro: " + e);
//		}
//	}
	
	public static int searchCargo(String cargo) {
		String query = "SELECT codigo FROM CARGO WHERE titulacao = " + "'" + cargo + "'";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultset = pst.executeQuery(query);
			while(resultset.next()) {
				codCargo = resultset.getInt("codigo");
			}
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return codCargo;
	}
	
}
