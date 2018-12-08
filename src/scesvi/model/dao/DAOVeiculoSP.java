package scesvi.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import scesvi.model.Veiculo;

public class DAOVeiculoSP extends DAO {

	private static Veiculo veiculo;
	
	public static Veiculo getVeiculo() {
		return veiculo;
	}
	
//	public static void insert(Veiculo veiculo) {
//		String query = "{CALL sp_InsertVeiculo(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
//		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
//			pst.setString(1, veiculo.getCodigo());
//			pst.setString(2, veiculo.getPlaca());
//			pst.setString(3, veiculo.getRenavam());
//			pst.setString(4, veiculo.getAutorizado());
//			pst.setString(5, veiculo.getCategoria());
//			pst.setString(6, veiculo.getInstitucional());
//			pst.setString(7, String.valueOf(veiculo.getMaxPassageiros()));
//			pst.setString(8, veiculo.getObservacao());
//			pst.setString(9, veiculo.getCor());
//			pst.setString(10, veiculo.getMarcaModelo());
//			pst.setString(11, veiculo.getDataSupervisionado());
//			pst.setString(12, veiculo.getSiapeServSupervisiona());
//			pst.setString(13, veiculo.getSiapeServResponsavel());
//			pst.setString(14, veiculo.getSituacao());
//
//			pst.executeUpdate();
//			pst.close();
//			disconnection();
//		} catch (SQLException e) {
//			System.out.println("Erro: " + e);
//		}
//	}
	
}
