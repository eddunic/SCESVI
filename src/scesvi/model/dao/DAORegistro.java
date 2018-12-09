package scesvi.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import scesvi.model.Registro;
import scesvi.model.Veiculo;

public class DAORegistro extends DAO {
	
	private static Registro registro;
	
	@FXML
	private static ObservableList<Registro> listReg;
	
	@FXML
	private static ObservableList<String> codAll;
	
	public static Registro getRegistro() {
		return registro;
	}
	
	public static ObservableList<String> codAll() {
		String query = "SELECT numero FROM REGISTRO";
		codAll = FXCollections.observableArrayList();;
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultSet = pst.executeQuery(query);
			while(resultSet.next()) {
				codAll.add(resultSet.getString("numero"));
			}
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return codAll;
	}
	
	public static void insert(Registro registro) {
		String query = "INSERT INTO REGISTRO (observacao, codVeiculo, siapeServInicia, siapeServEncerra, siapeServResponsavel, "
				+ "dataInicia, horaSaida, dataSaida, dataEntrada, horaEntrada, dataEncerra, descricao, "
				+ "kmInicial, kmFinal, dataSupervisionado) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, registro.getObservacao());
			pst.setString(2, registro.getCodVeiculo());
			pst.setString(3, registro.getSiapeServInicia());
			pst.setString(4, registro.getSiapeServEncerra());
			pst.setString(5, registro.getSiapeServResponsavel());
			pst.setString(6, registro.getDataInicia());
			pst.setString(7, registro.getHoraSaida());
			pst.setString(8, registro.getDataSaida());
			pst.setString(9, registro.getDataEntrada());
			pst.setString(10, registro.getHoraEntrada());
			pst.setString(11, registro.getDataEncerra());
			pst.setString(12, registro.getDescricao());
			pst.setString(13, String.valueOf(registro.getKmInicial()));
			pst.setString(14, String.valueOf(registro.getKmFinal()));
			pst.setString(15, registro.getDataSupervisionado());

			pst.executeUpdate();
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
	public static ObservableList<Registro> list() {
		listReg = FXCollections.observableArrayList();
		String query = "SELECT numero, codVeiculo, siapeServResponsavel, horaEntrada, horaSaida FROM REGISTRO";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultSet = pst.executeQuery(query);
			while(resultSet.next()) {
				Registro reg = new Registro();
				reg.setNumero(resultSet.getInt("numero"));
				reg.setCodVeiculo(resultSet.getString("codVeiculo"));
				reg.setSiapeServResponsavel(resultSet.getString("siapeServResponsavel"));
				reg.setHoraEntrada(resultSet.getString("horaEntrada"));
				reg.setHoraSaida(resultSet.getString("horaSaida"));
				listReg.add(reg);
			}
			
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return listReg;
	}
	
	public static void delete(int numero) {
		String query = "DELETE FROM REGISTRO WHERE REGISTRO.numero = " + numero;
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.executeUpdate(query);
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
	public static String consultParam(String var, int numero) {
		String query = "SELECT " + var + " FROM REGISTRO WHERE REGISTRO.numero = " + numero;
		String lblText = null;
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultSet = pst.executeQuery(query);
			while(resultSet.next()) {
				lblText = resultSet.getString(var);
			}
			
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return lblText;
	}
	
	public static void update(Registro registro) {
        String query = "UPDATE REGISTRO SET observacao = ?, codVeiculo = ?, siapeServInicia = ?, siapeServEncerra = ?, "
        				+ "siapeServResponsavel = ?, dataInicia = ?, horaSaida = ?, dataSaida = ?, dataEntrada = ?, "
        				+ "horaEntrada = ?, dataEncerra = ?, descricao = ?, kmInicial = ?, kmFinal = ?, "
        				+ "dataSupervisionado = ? WHERE numero = ?";
        try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, registro.getObservacao());
			pst.setString(2, registro.getCodVeiculo());
			pst.setString(3, registro.getSiapeServInicia());
			pst.setString(4, registro.getSiapeServEncerra());
			pst.setString(5, registro.getSiapeServResponsavel());
			pst.setString(6, registro.getDataInicia());
			pst.setString(7, registro.getHoraSaida());
			pst.setString(8, registro.getDataSaida());
			pst.setString(9, registro.getDataEntrada());
			pst.setString(10, registro.getHoraEntrada());
			pst.setString(11, registro.getDataEncerra());
			pst.setString(12, registro.getDescricao());
			pst.setString(13, String.valueOf(registro.getKmInicial()));
			pst.setString(14, String.valueOf(registro.getKmFinal()));
			pst.setString(15, registro.getDataSupervisionado());
			pst.setString(16, String.valueOf(registro.getNumero()));

            pst.executeUpdate();
            pst.close();
            disconnection();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }
	
	public static String numReg() {
		String query = "SELECT max(numero) FROM REGISTRO";
		String lblText = null;
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultSet = pst.executeQuery(query);
			while(resultSet.next()) {
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
