package scesvi.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import scesvi.model.Lotado;
import scesvi.model.SolicitVeiculo;
import scesvi.model.Solicitacao;

public class DAOSolicitVeiculo extends DAO {

	private static SolicitVeiculo solicitVeiculo;
	
	@FXML
	private static ObservableList<SolicitVeiculo> listSolicit;
	
	public static SolicitVeiculo getSolicitVeiculo() {
		return solicitVeiculo;
	}
	
	public static String consultParam(String var, int numero) {
		String query = "SELECT " + var + " FROM SOLICITVEICULO WHERE SOLICITVEICULO.numSolicit = " + numero;
		String lblText = null;
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultSet = pst.executeQuery(query);
			while (resultSet.next()) {
				lblText = resultSet.getString(var);
			}
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return lblText;
	}
	
	public static void insert(SolicitVeiculo solicitVeiculo) {
		String query = "INSERT INTO SOLICITVEICULO VALUES(?,?,?)";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, String.valueOf(solicitVeiculo.getNumSolicit()));
			pst.setString(2, solicitVeiculo.getCodVeic());
			pst.setString(3, solicitVeiculo.getSituacao());
			
			pst.executeUpdate();
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
	public static void update(SolicitVeiculo solicitVeiculo) {
		String query = "UPDATE SOLICITVEICULO VALUES(?,?,?)";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, String.valueOf(solicitVeiculo.getNumSolicit()));
			pst.setString(2, solicitVeiculo.getCodVeic());
			pst.setString(3, solicitVeiculo.getSituacao());
			
			pst.executeUpdate();
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
	public static ObservableList<SolicitVeiculo> list() {
		listSolicit = FXCollections.observableArrayList();
		String query = "SELECT numSolicit, situacao FROM SOLICITVEICULO";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultSet = pst.executeQuery(query);
			while (resultSet.next()) {
				SolicitVeiculo solicit = new SolicitVeiculo();
				solicit.setNumSolicit(resultSet.getInt("numSolicit"));
				solicit.setSituacao(resultSet.getString("situacao"));
				listSolicit.add(solicit);
			}

			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return listSolicit;
	}
	
	public static String listSituacao(String numSolic) {
		ResultSet resultSet;
		String situ = "-"; 
		String query = "SELECT situacao FROM SOLICITVEICULO WHERE numSolicit = " + numSolic;
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			resultSet = pst.executeQuery();
			while (resultSet.next()) {
				situ = resultSet.getString("situacao");
			}
			
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return situ;
	}
	
//	public static ObservableList<String> listMarcaModelo(ObservableList<String> listMarcaModx) {
//		listMarcaM = FXCollections.observableArrayList();
//		String query = "SELECT veiculoRequisitado FROM VEICULO WHERE dataFim is not null AND veiculoRequisitado = marcaModelo";
//		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
//			ResultSet resultSet = pst.executeQuery(query);
//			while (resultSet.next()) {
//				listMarcaM.add(resultSet.getString("veiculoRequisitado"));
//			}
//
//			pst.close();
//			disconnection();
//		} catch (SQLException e) {
//			System.out.println("Erro: " + e);
//		}
//		return listMarcaM;
//	}
//	
//	public static ObservableList<String> listCodVeic() {
//		listMarcaM = FXCollections.observableArrayList();
//		String query = "SELECT codVeic FROM SOLICITVEICULO";
//		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
//			ResultSet resultSet = pst.executeQuery(query);
//			while (resultSet.next()) {
//				listMarcaM.add(resultSet.getString("codVeic"));
//			}
//
//			pst.close();
//			disconnection();
//		} catch (SQLException e) {
//			System.out.println("Erro: " + e);
//		}
//		return listMarcaM;
//	}
	
}
