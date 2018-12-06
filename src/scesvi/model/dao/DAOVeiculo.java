package scesvi.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import scesvi.model.Solicitacao;
import scesvi.model.Veiculo;

public class DAOVeiculo extends DAO {

	private static Veiculo veiculo;

	@FXML
	private static ObservableList<Veiculo> listVeic;
	
	@FXML
	private static ObservableList<String> listMarcaM;
	
	public static Veiculo getVeiculo() {
		return veiculo;
	}

	public static void insert(Veiculo veiculo) {
		String query = "INSERT INTO VEICULO VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			pst.setString(21, veiculo.getSituacao());

			pst.executeUpdate();
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}

	public static ObservableList<Veiculo> list() {
		listVeic = FXCollections.observableArrayList();
		String query = "SELECT codigo, marcaModelo, situacao, siapeServResponsavel, placa FROM VEICULO";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultSet = pst.executeQuery(query);
			while (resultSet.next()) {
				Veiculo veic = new Veiculo();
				veic.setCodigo(resultSet.getString("codigo"));
				veic.setMarcaModelo(resultSet.getString("marcaModelo"));
				veic.setAnoModelo(resultSet.getString("situacao"));
				veic.setSiapeServResponsavel(resultSet.getString("siapeServResponsavel"));
				veic.setPlaca(resultSet.getString("placa"));
				listVeic.add(veic);
			}

			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return listVeic;
	}
//////////////////////////////////////
	public static ObservableList<String> listMarcaModelo() {
		listMarcaM = FXCollections.observableArrayList();
		String query = "SELECT marcaModelo FROM VEICULO";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultSet = pst.executeQuery(query);
			while (resultSet.next()) {
				listMarcaM.add(resultSet.getString("marcaModelo"));
			}

			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return listMarcaM;
	}
	
	public static ObservableList<String> listMarcaModelox() {
		ResultSet resultSet;
		listMarcaM = FXCollections.observableArrayList();
		String query = "SELECT marcaModelo FROM VEICULO WHERE situacao = 'L'";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			resultSet = pst.executeQuery();
			while (resultSet.next()) {
				listMarcaM.add(resultSet.getString("marcaModelo"));
			}
			
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return listMarcaM;
	}
/////////////////////////////////////
	public static void delete(String codigo) {
		String query = "DELETE FROM VEICULO WHERE VEICULO.codigo = " + codigo;
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.executeUpdate(query);
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}

	public static String consultParam(String var, String codigo) {
		String query = "SELECT " + var + " FROM VEICULO WHERE VEICULO.codigo = " + codigo;
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

	public static void update(Veiculo veiculo) {
		String query = "UPDATE VEICULO SET tipo = ?, placa = ?, renavam = ?, autorizado = ?, categoria = ?, institucional = ?, "
				+ "chassi = ?, maxPassageiros = ?, observacao = ?, exercicio = ?, tipoCombustivel = ?, potencia  = ?, "
				+ "cor = ?, marcaModelo = ?, anoFabricacao = ?, anoModelo = ?, dataSupervisionado = ?, siapeServSupervisiona = ?, "
				+ "siapeServResponsavel = ?, situacao = ? WHERE codigo = ?";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, veiculo.getTipo());
			pst.setString(2, veiculo.getPlaca());
			pst.setString(3, veiculo.getRenavam());
			pst.setString(4, veiculo.getAutorizado());
			pst.setString(5, veiculo.getCategoria());
			pst.setString(6, veiculo.getInstitucional());
			pst.setString(7, veiculo.getChassi());
			pst.setString(8, String.valueOf(veiculo.getMaxPassageiros()));
			pst.setString(9, veiculo.getObservacao());
			pst.setString(10, veiculo.getExercicio());
			pst.setString(11, veiculo.getTipoCombustivel());
			pst.setString(12, String.valueOf(veiculo.getPotencia()));
			pst.setString(13, veiculo.getCor());
			pst.setString(14, veiculo.getMarcaModelo());
			pst.setString(15, veiculo.getAnoFabricacao());
			pst.setString(16, veiculo.getAnoModelo());
			pst.setString(17, veiculo.getDataSupervisionado());
			pst.setString(18, veiculo.getSiapeServSupervisiona());
			pst.setString(19, veiculo.getSiapeServResponsavel());
			pst.setString(20, veiculo.getCodigo());
			pst.setString(21, veiculo.getSituacao());
			
			pst.executeUpdate();
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}

}
