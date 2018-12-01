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
	
	public static Registro getRegistro() {
		return registro;
	}
	
	public static void insert(Registro registro) {
		String query = "INSERT INTO REGISTRO VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, String.valueOf(registro.getNumero()));
			pst.setString(2, registro.getObservacao());
			pst.setString(3, registro.getCodVeiculo());
			pst.setString(4, registro.getSiapeServInicia());
			pst.setString(5, registro.getSiapeServEncerra());
			pst.setString(6, registro.getSiapeServResponsavel());
			pst.setString(7, registro.getHoraInicia());
			pst.setString(8, registro.getDataInicia());
			pst.setString(9, registro.getHoraSaida());
			pst.setString(10, registro.getDataSaida());
			pst.setString(11, registro.getDataEntrada());
			pst.setString(12, registro.getHoraEntrada());
			pst.setString(13, registro.getDataEncerra());
			pst.setString(14, registro.getHoraEncerra());
			pst.setString(15, registro.getDescricao());
			pst.setString(16, String.valueOf(registro.getKmInicial()));
			pst.setString(17, String.valueOf(registro.getKmFinal()));
			pst.setString(18, String.valueOf(registro.getKmPercorridos()));
			pst.setString(19, registro.getDataSupervisionado());

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
        				+ "siapeServResponsavel = ?, horaInicia = ?, DataInicia = ?, HoraSaida = ?, dataSaida = ?, dataEntrada = ?, "
        				+ "horaEntrada = ?, dataEncerra = ?, horaEncerra = ?, descricao = ?, kmInicial = ?, kmFinal = ?, "
        				+ "kmPercorridos = ?, dataSupervisionado = ? WHERE numero = ?";
        try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, registro.getObservacao());
			pst.setString(2, registro.getCodVeiculo());
			pst.setString(3, registro.getSiapeServInicia());
			pst.setString(4, registro.getSiapeServEncerra());
			pst.setString(5, registro.getSiapeServResponsavel());
			pst.setString(6, registro.getHoraInicia());
			pst.setString(7, registro.getDataInicia());
			pst.setString(8, registro.getHoraSaida());
			pst.setString(9, registro.getDataSaida());
			pst.setString(10, registro.getDataEntrada());
			pst.setString(11, registro.getHoraEntrada());
			pst.setString(12, registro.getDataEncerra());
			pst.setString(13, registro.getHoraEncerra());
			pst.setString(14, registro.getDescricao());
			pst.setString(15, String.valueOf(registro.getKmInicial()));
			pst.setString(16, String.valueOf(registro.getKmFinal()));
			pst.setString(17, String.valueOf(registro.getKmPercorridos()));
			pst.setString(18, registro.getDataSupervisionado());
			pst.setString(19, String.valueOf(registro.getNumero()));

            pst.executeUpdate();
            pst.close();
            disconnection();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }
	
}
