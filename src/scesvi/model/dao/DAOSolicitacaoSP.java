package scesvi.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import scesvi.model.SolicitVeiculo;
import scesvi.model.Solicitacao;

public class DAOSolicitacaoSP extends DAO {

	private static Solicitacao solicitacao;
	
	@FXML
	private static ObservableList<Solicitacao> listSolicit;
	
	public static Solicitacao getSolicitacao() {
		return solicitacao;
	}
	
	public static void insert(Solicitacao solicitacao) {
		String query = "CALL sp_InsertSolicitacao(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, String.valueOf(solicitacao.getNumero()));
			pst.setString(2, solicitacao.getDataInicio());
			pst.setString(3, solicitacao.getDataFim());
			pst.setString(4, solicitacao.getDataCriacao());
			pst.setString(5, solicitacao.getLocalViagem());
			pst.setString(6, solicitacao.getDataAutorizado());
			pst.setString(7, String.valueOf(solicitacao.getQtdePassageiros()));
			pst.setString(8, solicitacao.getTipo());
			pst.setString(9, solicitacao.getFinalidade());
			pst.setString(10, solicitacao.getSiapeServAutoriza());
			pst.setString(11, solicitacao.getSiapeServRealiza());

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
				SolicitVeiculo solicVeic = new SolicitVeiculo();
				solicit.setNumero(resultSet.getInt("numero"));
				solicit.setTipo(resultSet.getString("tipo"));
				solicVeic.setSituacao(resultSet.getString("situacao"));
				solicVeic.setNumSolicit(resultSet.getInt("numero"));
				//solicVeic.setCodVeic(codVeic);
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
