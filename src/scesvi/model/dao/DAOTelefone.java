package scesvi.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import scesvi.model.Telefone;

public class DAOTelefone extends DAO {
	
	private static Telefone telefone;
	
	public static Telefone getTelefone() {
		return telefone;
	}
	
	public static void insert(Telefone telefone) {
		String query = "INSERT INTO TELEFONE VALUES(?,?)";
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
	
}

