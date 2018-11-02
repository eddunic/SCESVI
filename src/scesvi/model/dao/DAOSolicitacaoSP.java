package scesvi.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import scesvi.model.Solicitacao;

public class DAOSolicitacaoSP extends DAO {

	private static Solicitacao solicitacao;
	
	public static Solicitacao getSolicitacao() {
		return solicitacao;
	}
	
	public static void insert(Solicitacao solicitacao) {
		String query = "CALL sp_InsertSolicitacao(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, String.valueOf(solicitacao.getNumero()));
			pst.setString(2, String.valueOf(solicitacao.getVeiculoRequisitado()));
			pst.setString(3, solicitacao.getDataVeiculoConfirmado());
			pst.setString(4, solicitacao.getDataInicio());
			pst.setString(5, solicitacao.getDataFim());
			pst.setString(6, solicitacao.getHoraCriacao());
			pst.setString(7, solicitacao.getDataCriacao());
			pst.setString(8, solicitacao.getLocalViagem());
			pst.setString(9, solicitacao.getHoraAutorizado());
			pst.setString(10, solicitacao.getDataAutorizado());
			pst.setString(11, String.valueOf(solicitacao.getQtdePassageiros()));
			pst.setString(12, solicitacao.getTipo());
			pst.setString(13, solicitacao.getFinalidade());
			pst.setString(14, solicitacao.getSiapeServAutoriza());
			pst.setString(15, solicitacao.getSiapeServRealiza());
			pst.setString(16, solicitacao.getCodVeiculoAtende());

			pst.executeUpdate();
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
}
