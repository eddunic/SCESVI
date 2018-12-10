package scesvi.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import scesvi.model.Solicitacao;
import scesvi.model.Veiculo;

public class DAOSolicitacao extends DAO {

	private static Solicitacao solicitacao;

	@FXML
	private static ObservableList<Solicitacao> listSolicit;

	@FXML
	private static ObservableList<String> listMarcaM, codAll;

	public static Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public static ObservableList<String> codAll() {
		String query = "SELECT numero FROM SOLICITACAO";
		codAll = FXCollections.observableArrayList();
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultSet = pst.executeQuery(query);
			while (resultSet.next()) {
				codAll.add(resultSet.getString("numero"));
			}
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return codAll;
	}

	public static void insert(Solicitacao solicitacao) {
		String query = "INSERT INTO SOLICITACAO (dataInicio, dataFim, dataCriacao, localViagem, dataAutorizado, qtdePassageiros, tipo, finalidade, siapeServAutoriza, siapeServRealiza) VALUES (?,?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, solicitacao.getDataInicio());
			pst.setString(2, solicitacao.getDataFim());
			pst.setString(3, solicitacao.getDataCriacao());
			pst.setString(4, solicitacao.getLocalViagem());
			pst.setString(5, solicitacao.getDataAutorizado());
			pst.setString(6, String.valueOf(solicitacao.getQtdePassageiros()));
			pst.setString(7, solicitacao.getTipo());
			pst.setString(8, solicitacao.getFinalidade());
			pst.setString(9, solicitacao.getSiapeServAutoriza());
			pst.setString(10, solicitacao.getSiapeServRealiza());

			pst.executeUpdate();
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}

	public static ObservableList<Solicitacao> list() {
		listSolicit = FXCollections.observableArrayList();
		String query = "SELECT numero, tipo, dataCriacao, dataAutorizado FROM SOLICITACAO";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultSet = pst.executeQuery(query);
			while (resultSet.next()) {
				Solicitacao solicit = new Solicitacao();
				solicit.setNumero(resultSet.getInt("numero"));
				solicit.setTipo(resultSet.getString("tipo"));
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

	public static void update(Solicitacao solicitacao) {
		String query = "UPDATE SOLICITACAO SET dataInicio = ?, "
				+ "dataFim = ?, dataCriacao = ?, localViagem = ?, dataAutorizado = ?, "
				+ "qtdePassageiros = ?, tipo = ?, finalidade  = ?, siapeServAutoriza = ?, siapeServRealiza = ? WHERE numero = ?";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, solicitacao.getDataInicio());
			pst.setString(2, solicitacao.getDataFim());
			pst.setString(3, solicitacao.getDataCriacao());
			pst.setString(4, solicitacao.getLocalViagem());
			pst.setString(5, solicitacao.getDataAutorizado());
			pst.setString(6, String.valueOf(solicitacao.getQtdePassageiros()));
			pst.setString(7, solicitacao.getTipo());
			pst.setString(8, solicitacao.getFinalidade());
			pst.setString(9, solicitacao.getSiapeServAutoriza());
			pst.setString(10, solicitacao.getSiapeServRealiza());
			pst.setString(11, String.valueOf(solicitacao.getNumero()));

			pst.executeUpdate();
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}

//	public static ObservableList<String> listMarcaModelo(ObservableList<String> listCodVeic) {
//		listMarcaM = FXCollections.observableArrayList();
//	    newListCodVeic = listCodVeic;
//		for (ObservableList<String> newListCodVeic : listCodVeic.get()) {
//		String query = "SELECT veiculoRequisitado FROM SOLICITACAO WHERE dataFim is not null AND veiculoRequisitado =" marcaModel;
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
//////////////////////
//	public static ObservableList<String> listMarcaModelo() {
//		int i = 0;
//		ResultSet resultSet;
//		listMarcaM = FXCollections.observableArrayList();
//		String query = "SELECT situacao FROM SOLICITACAO";
//		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
//			resultSet = pst.executeQuery();
//			while (resultSet.next()) {
//				listMarcaM.add(resultSet.getString("situacao"));
//				pst.executeQuery();
//				i++;
//			}
//			
//			pst.close();
//			disconnection();
//		} catch (SQLException e) {
//			System.out.println("Erro: " + e);
//		}
//		return listMarcaM;
//	}

///////////////////////////////////
	public static void delete(int numero) {
		String query = "DELETE FROM SOLICITACAO WHERE numero = " + numero;
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.executeUpdate(query);
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}

	public static String consultParam(String var, int numero) {
		String query = "SELECT " + var + " FROM SOLICITACAO WHERE SOLICITACAO.numero = " + numero;
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

	public static String numSolic() {
		String query = "SELECT max(numero) FROM SOLICITACAO";
		String lblText = null;
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultSet = pst.executeQuery(query);
			while (resultSet.next()) {
				lblText = String.valueOf(Integer.parseInt(resultSet.getString("max(numero)")) + 1);
			}
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return lblText;
	}

}
