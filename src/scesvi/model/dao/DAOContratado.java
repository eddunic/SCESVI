package scesvi.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import scesvi.model.Contratado;
import scesvi.model.Servidor;

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

	public static void update(Contratado contratado) {
		String query = "UPDATE CONTRATADO SET siapeServ = ?, codCargo = ? WHERE siapeServ = ?";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, contratado.getSiapeServ());
			pst.setInt(2, contratado.getCodCargo());
			pst.setString(3, contratado.getSiapeServ());
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
			while (resultSet.next()) {
				codCargo = resultSet.getString("codCargo");
			}

			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return codCargo;
	}

	public static String consultContratadoAdmin(String siape) {
		String siapeServ = null;
		String query = "SELECT siapeServ FROM CONTRATADO WHERE codCargo = 1 AND siapeServ = " + siape;
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultSet = pst.executeQuery(query);
			while (resultSet.next()) {
				siapeServ = resultSet.getString("siapeServ");
			}

			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return siapeServ;
	}

}
