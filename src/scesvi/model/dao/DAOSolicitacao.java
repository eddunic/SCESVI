package scesvi.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import scesvi.model.Solicitacao;

public class DAOSolicitacao extends DAO {
	
	private static Solicitacao solicitacao;
	
	public static Solicitacao getSolicitacao() {
		return solicitacao;
	}
	
	public static void insert(Solicitacao solicitacao) {
		String query = "INSERT INTO SOLICITACAO VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, String.valueOf(solicitacao.getVeiculoRequisitado()));
			pst.setString(2, solicitacao.getDataVeiculoConfirmado());
			pst.setString(3, solicitacao.getDataInicio());
			pst.setString(4, solicitacao.getDataFim());
			pst.setString(5, solicitacao.getHoraCriacao());
			pst.setString(6, solicitacao.getDataCriacao());
			pst.setString(7, solicitacao.getLocalViagem());
			pst.setString(8, solicitacao.getHoraAutorizado());
			pst.setString(9, solicitacao.getDataAutorizado());
			pst.setString(10, String.valueOf(solicitacao.getQtdePassageiros()));
			pst.setString(11, solicitacao.getTipo());
			pst.setString(11, solicitacao.getFinalidade());
			pst.setString(11, solicitacao.getMatServAutoriza());
			pst.setString(11, solicitacao.getMatServRealiza());
			pst.setString(11, solicitacao.getCodVeiculoAtende());

			pst.executeUpdate();
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
}
