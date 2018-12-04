package scesvi.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import scesvi.model.Contratado;

public class DAOContratado extends DAO {
	
	private static Contratado contratado;
	
	public static Contratado getContratado() {
		return contratado;
	}
	
	public static void insert(Contratado contratado) {
		String query = "INSERT INTO CONTRATADO VALUES(?,?,?,?)";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, contratado.getSiapeServ());
			pst.setString(2, String.valueOf(contratado.getCodCargo()));
			pst.setString(3, contratado.getDataInicio());
			pst.setString(4, contratado.getDataFim());

			pst.executeUpdate();
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
	public static String consultContratado(String siape) {
		String codCargo = null;
		String query = "SELECT codCargo FROM CONTRATADO WHERE siapeServ = " + siape;
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultSet = pst.executeQuery(query);
			while(resultSet.next()) {
				codCargo = resultSet.getString("codCargo");
	     	}

			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return codCargo;
	}
	
}
