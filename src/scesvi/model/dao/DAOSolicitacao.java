package scesvi.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import scesvi.model.Solicitacao;

public class DAOSolicitacao extends DAO {
	
	private static Solicitacao solicitacao;
	
	@FXML
	private static ObservableList<Solicitacao> listSolicit;
	
	public static Solicitacao getSolicitacao() {
		return solicitacao;
	}
	
	public static void insert(Solicitacao solicitacao) {
		String query = "INSERT INTO SOLICITACAO VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
		String query = "SELECT numero, tipo, veiculoRequisitado, dataCriacao, dataAutorizado FROM SOLICITACAO";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultset = pst.executeQuery(query);
			while(resultset.next()) {
				Solicitacao solicit = new Solicitacao();
				solicit.setNumero(resultset.getInt("numero"));
				solicit.setTipo(resultset.getString("tipo"));
				solicit.setVeiculoRequisitado(resultset.getString("veiculoRequisitado"));
				solicit.setDataCriacao(resultset.getString("dataCriacao"));
				solicit.setDataAutorizado(resultset.getString("dataAutorizado"));
				listSolicit.add(solicit);
			}
			
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return listSolicit;
	}
	
	public static void delete(int num) {
		String query = "DELETE FROM SOLICITACAO WHERE numero = " + num;
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.executeUpdate(query);
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
}
