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
	private static ObservableList<String> listMarcaM, list, codAll, listV;
	
	public static Veiculo getVeiculo() {
		return veiculo;
	}

	public static void insert(Veiculo veiculo) {
		String query = "INSERT INTO VEICULO (placa, renavam, autorizado, categoria, institucional, maxPassageiros, observacao, cor, marcaModelo, dataSupervisionado, siapeServSupervisiona, siapeServResponsavel, situacao) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, veiculo.getPlaca());
			pst.setString(2, veiculo.getRenavam());
			pst.setString(3, veiculo.getAutorizado());
			pst.setString(4, veiculo.getCategoria());
			pst.setString(5, veiculo.getInstitucional());
			pst.setString(6, String.valueOf(veiculo.getMaxPassageiros()));
			pst.setString(7, veiculo.getObservacao());
			pst.setString(8, veiculo.getCor());
			pst.setString(9, veiculo.getMarcaModelo());
			pst.setString(10, veiculo.getDataSupervisionado());
			pst.setString(11, veiculo.getSiapeServSupervisiona());
			pst.setString(12, veiculo.getSiapeServResponsavel());
			pst.setString(13, veiculo.getSituacao());

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
				veic.setCodigo(Integer.parseInt(resultSet.getString("codigo")));
				veic.setMarcaModelo(resultSet.getString("marcaModelo"));
				veic.setSituacao(resultSet.getString("situacao"));
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
	
	public static ObservableList<Veiculo> listCodSitu() {
		listV = FXCollections.observableArrayList();
		String query = "SELECT codigo, situacao FROM VEICULO";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultSet = pst.executeQuery(query);
			while (resultSet.next()) {
				Veiculo veic = new Veiculo();
				veic.setCodigo(Integer.parseInt(resultSet.getString("codigo")));
				veic.setSituacao(resultSet.getString("situacao"));
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
	
	public static ObservableList<String> listAll() {
		list = FXCollections.observableArrayList();
		String query = "SELECT * FROM VEICULO WHERE";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultSet = pst.executeQuery(query);
			while (resultSet.next()) {
				listMarcaM.add(resultSet.getString(""));
			}

			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return list;
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
	public static void delete(int codigo) {
		String query = "DELETE FROM VEICULO WHERE codigo = " + codigo;
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.executeUpdate(query);
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}

	public static String consultParam(String var, int codigo) {
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
		String query = "UPDATE VEICULO SET placa = ?, renavam = ?, autorizado = ?, categoria = ?, institucional = ?, maxPassageiros = ?, observacao = ?, "
				+ "cor = ?, marcaModelo = ?, dataSupervisionado = ?, siapeServSupervisiona = ?, "
				+ "siapeServResponsavel = ?, situacao = ? WHERE codigo = ?";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, veiculo.getPlaca());
			pst.setString(2, veiculo.getRenavam());
			pst.setString(3, veiculo.getAutorizado());
			pst.setString(4, veiculo.getCategoria());
			pst.setString(5, veiculo.getInstitucional());
			pst.setString(6, String.valueOf(veiculo.getMaxPassageiros()));
			pst.setString(7, veiculo.getObservacao());
			pst.setString(8, veiculo.getCor());
			pst.setString(9, veiculo.getMarcaModelo());
			pst.setString(10, veiculo.getDataSupervisionado());
			pst.setString(11, veiculo.getSiapeServSupervisiona());
			pst.setString(12, veiculo.getSiapeServResponsavel());
			pst.setInt(14, veiculo.getCodigo());
			pst.setString(13, veiculo.getSituacao());
			
			
			
			pst.executeUpdate();
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
	public static String codVeic() {
		String query = "SELECT max(codigo) FROM VEICULO";
		String lblText = null;
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultSet = pst.executeQuery(query);
			while(resultSet.next()) {
				lblText = String.valueOf(Integer.parseInt(resultSet.getString("max(codigo)")) + 1);
			}
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return lblText;
	}
	
	public static ObservableList<String> codAll() {
		String query = "SELECT codigo FROM VEICULO";
		codAll = FXCollections.observableArrayList();;
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultSet = pst.executeQuery(query);
			while(resultSet.next()) {
				codAll.add(resultSet.getString("codigo"));
			}
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return codAll;
	}
	
	public static String listCod(String modelo) {
		ResultSet resultSet;
		String listCod = null;
		String query = "SELECT codigo FROM VEICULO WHERE marcaModelo = '" + modelo + "'";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			resultSet = pst.executeQuery();
			while (resultSet.next()) {
				listCod = resultSet.getString("codigo");
			}
			
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return listCod;
	}
}
