package scesvi.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import scesvi.model.Registro;

public class DAORegistro extends DAO {
	
	private static Registro registro;
	
	public static Registro getRegistro() {
		return registro;
	}
	
	public static void insert(Registro registro) {
		String query = "INSERT INTO REGISTRO VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, String.valueOf(registro.getNumero()));
			pst.setString(2, registro.getObservacao());
			pst.setString(3, registro.getCodVeiculo());
			pst.setString(4, registro.getMatServInicia());
			pst.setString(5, registro.getMatServEncerra());
			pst.setString(6, registro.getMatServResponsavel());
			pst.setString(7, registro.getHoraInicia());
			pst.setString(8, registro.getDataInicia());
			pst.setString(9, registro.getHoraSaida());
			pst.setString(10, registro.getDataSaida());
			pst.setString(11, registro.getDataEntrada());
			pst.setString(12, registro.getHoraEntrada());
			pst.setString(13, registro.getDataEncerra());
			pst.setString(14, registro.getHoraEncerra());
			pst.setString(15, registro.getDescricao());
			pst.setString(16, String.valueOf(registro.getKmInicial()));
			pst.setString(17, String.valueOf(registro.getKmFinal()));
			pst.setString(18, String.valueOf(registro.getKmPercorridos()));
			pst.setString(19, registro.getDataSupervisionado());

			pst.executeUpdate();
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
}
