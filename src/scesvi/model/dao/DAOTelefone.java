package scesvi.model.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import scesvi.model.Contratado;
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
	
	public static void update(Telefone telefone) {
		String query = "UPDATE TELEFONE SET siapeServ = ?, telefone = ? WHERE siapeServ = ?";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, telefone.getSiapeServ());
			pst.setString(2, telefone.getTelefone());
			pst.setString(3, telefone.getSiapeServ());
			pst.executeUpdate();
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
	public static String consultTel(String siape) {
		String lblText = null;
		String query = "SELECT telefone FROM TELEFONE WHERE " + siape + " = siapeServ";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultSet = pst.executeQuery(query);
			while(resultSet.next()) {
				lblText = resultSet.getString("telefone");
	     	}

			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return lblText;
	}
	
}

