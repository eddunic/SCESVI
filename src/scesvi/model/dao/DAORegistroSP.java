package scesvi.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import scesvi.model.Registro;

public class DAORegistroSP extends DAO {
	
private static Registro registro;
	
	public static Registro getRegistro() {
		return registro;
	}
	
	public static void insert(Registro registro) {
		String query = "CALL sp_InsertRegistro(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, String.valueOf(registro.getNumero()));
			pst.setString(2, registro.getObservacao());
			pst.setString(3, registro.getCodVeiculo());
			pst.setString(4, registro.getSiapeServInicia());
			pst.setString(5, registro.getSiapeServEncerra());
			pst.setString(6, registro.getSiapeServResponsavel());
			pst.setString(7, registro.getDataInicia());
			pst.setString(8, registro.getHoraSaida());
			pst.setString(9, registro.getDataSaida());
			pst.setString(10, registro.getDataEntrada());
			pst.setString(11, registro.getHoraEntrada());
			pst.setString(12, registro.getDataEncerra());
			pst.setString(13, registro.getDescricao());
			pst.setString(14, String.valueOf(registro.getKmInicial()));
			pst.setString(15, String.valueOf(registro.getKmFinal()));
			pst.setString(16, registro.getDataSupervisionado());

			pst.executeUpdate();
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
}
