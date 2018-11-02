package scesvi.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import scesvi.model.Cargo;

public class DAOCargoSP extends DAO {
	
	private static Cargo cargo;
	private static int codCargo;
	
	public static Cargo getCargo() {
		return cargo;
	}
		
	public static int searchCargo(String cargo) {
		String query = "CALL sp_SearchCargo(" + cargo + ")";
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
