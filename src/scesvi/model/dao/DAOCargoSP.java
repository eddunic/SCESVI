package scesvi.model.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

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
			ResultSet resultSet = pst.executeQuery(query);
			while (resultSet.next()) {
				codCargo = resultSet.getInt("codigo");
			}
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return codCargo;
	}

	public static String consultCargo(String siape) {
		String lblText = "@cargo";
		String query = "{CALL sp_NomeCargo(?,?)}";
		try (CallableStatement call = getConnection().prepareCall(query)) {
			call.setString(1, siape);
			call.registerOutParameter(2, Types.VARCHAR);
			call.execute();
			lblText = String.valueOf(call.getString(2));
			//System.out.println(lblText);
			call.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return lblText;
	}

}
