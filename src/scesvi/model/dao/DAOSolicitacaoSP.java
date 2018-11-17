package scesvi.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import scesvi.model.Solicitacao;

public class DAOSolicitacaoSP extends DAO {

	private static Solicitacao solicitacao;
	
	@FXML
	private static ObservableList<Solicitacao> listSolicit;
	
	public static Solicitacao getSolicitacao() {
		return solicitacao;
	}
	
	public static void insert(Solicitacao solicitacao) {
		String query = "CALL sp_InsertSolicitacao(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, String.valueOf(solicitacao.getNumero()));
			pst.setString(2, solicitacao.getVeiculoRequisitado());
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

			pst.executeUpdate();
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	 	
	public static ObservableList<Solicitacao> list() {
		listSolicit = FXCollections.observableArrayList();
		String query = "CALL sp_ListSolicit()";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultSet = pst.executeQuery(query);
			while(resultSet.next()) {
				Solicitacao solicit = new Solicitacao();
				solicit.setNumero(resultSet.getInt("numero"));
				solicit.setTipo(resultSet.getString("tipo"));
				solicit.setVeiculoRequisitado(resultSet.getString("veiculoRequisitado"));
				solicit.setDataCriacao(resultSet.getString("dataCriacao"));
				solicit.setDataAutorizado(resultSet.getString("dataAutorizado"));
				listSolicit.add(solicit);
			}

			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return listSolicit;
	}
	
	public static void delete(int numero) {
		String query = "CALL sp_DeleteSolicit(" + numero + ")";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {		
			pst.executeUpdate(query);
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
}
