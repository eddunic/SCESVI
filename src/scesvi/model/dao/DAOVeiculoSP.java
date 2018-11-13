package scesvi.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import scesvi.model.Veiculo;

public class DAOVeiculoSP extends DAO {

	private static Veiculo veiculo;
	
	public static Veiculo getVeiculo() {
		return veiculo;
	}
	
	public static void insert(Veiculo veiculo) {
		String query = "CALL sp_InsertVeiculo(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, veiculo.getCodigo());
			pst.setString(2, veiculo.getTipo());
			pst.setString(3, veiculo.getPlaca());
			pst.setString(4, veiculo.getRenavam());
			pst.setString(5, veiculo.getAutorizado());
			pst.setString(6, veiculo.getCategoria());
			pst.setString(7, veiculo.getInstitucional());
			pst.setString(8, veiculo.getChassi());
			pst.setString(9, String.valueOf(veiculo.getMaxPassageiros()));
			pst.setString(10, veiculo.getObservacao());
			pst.setString(11, veiculo.getExercicio());
			pst.setString(12, veiculo.getTipoCombustivel());
			pst.setString(13, String.valueOf(veiculo.getPotencia()));
			pst.setString(14, veiculo.getCor());
			pst.setString(15, veiculo.getMarcaModelo());
			pst.setString(16, veiculo.getAnoFabricacao());
			pst.setString(17, veiculo.getAnoModelo());
			pst.setString(18, veiculo.getDataSupervisionado());
			pst.setString(19, veiculo.getSiapeServSupervisiona());
			pst.setString(20, veiculo.getSiapeServResponsavel());

			pst.executeUpdate();
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
}
