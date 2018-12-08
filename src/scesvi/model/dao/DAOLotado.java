package scesvi.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import scesvi.model.Contratado;
import scesvi.model.Departamento;
import scesvi.model.Lotado;

public class DAOLotado extends DAO {

	private static Lotado lotado;
	
	public static Lotado getLotado() {
		return lotado;
	}
	
	public static void insert(Lotado lotado) {
		String query = "INSERT INTO LOTADO VALUES(?,?,?,?)";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, lotado.getSiapeServ());
			pst.setString(2, String.valueOf(lotado.getCodDep()));
			pst.setString(3, lotado.getDataInicio());
			pst.setString(4, lotado.getDataFim());

			pst.executeUpdate();
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
	public static void update(Lotado lotado) {
		String query = "UPDATE LOTADO SET siapeServ = ?, codDep = ? WHERE siapeServ = ?";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, lotado.getSiapeServ());
			pst.setInt(2, lotado.getCodDep());
			pst.setString(3, lotado.getSiapeServ());
			pst.executeUpdate();
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
	public static String consultLotado(String siape) {
		String codDep = null;
		String query = "SELECT codDep FROM LOTADO where siapeServ = " + siape;
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultSet = pst.executeQuery(query);
			while(resultSet.next()) {
				codDep = resultSet.getString("codDep");
	     	}

			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return codDep;
	}
	
}
