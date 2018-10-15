package scesvi.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOCargo extends DAO {
	
private static Cargo cargo;
	
	public static Cargo getCargo() {
		return cargo;
	}
	
	public static void insert(Cargo cargo) {
		String query = "INSERT INTO CARGO VALUES(?,?)";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, String.valueOf(cargo.getCodigo()));
			pst.setString(2, cargo.getTitulacao());

			pst.executeUpdate();
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
}
