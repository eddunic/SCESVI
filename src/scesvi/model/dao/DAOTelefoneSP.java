package scesvi.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.CallableStatement;

import scesvi.model.Telefone;

public class DAOTelefoneSP extends DAO {

	private static Telefone telefone;

	public static Telefone getTelefone() {
		return telefone;
	}

	public static void insert(Telefone telefone) {
		String query = "CALL sp_InsertTelefone(?,?)";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, telefone.getSiapeServ());
			pst.setString(2, telefone.getTelefone());

			pst.executeUpdate();
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}

	public static String consultTel(String siape) {
		String lblText = "@telefone";
		String query = "{CALL sp_ListTelefone(?,?)}";
		try (CallableStatement call = getConnection().prepareCall(query)) {
			call.setString(1, siape);
			call.registerOutParameter(2, Types.VARCHAR);
			call.execute();
			lblText = String.valueOf(call.getString(2));
			//System.out.println(String.valueOf(call.getInt(2)));
			call.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return lblText;
	}
	
}
