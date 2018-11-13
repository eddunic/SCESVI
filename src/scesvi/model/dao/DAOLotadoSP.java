package scesvi.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import scesvi.model.Lotado;

public class DAOLotadoSP extends DAO {
	
private static Lotado lotado;
	
	public static Lotado getLotado() {
		return lotado;
	}
	
	public static void insert(Lotado lotado) {
		String query = "CALL sp_InsertLotado(?,?,?,?)";
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

}
