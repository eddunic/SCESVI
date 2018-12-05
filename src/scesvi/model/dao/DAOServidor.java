package scesvi.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import scesvi.model.Servidor;

public class DAOServidor extends DAO {
	
	private static Servidor servidor;
	
	@FXML
	private static ObservableList<Servidor> listServ;
	
	@FXML
	public static  ObservableList<String> siapes;
	
	@FXML
	private static ComboBox<Servidor> cbSiapeSolicit;
	
	public static Servidor getServidor() {
		return servidor;
	}
	
	public static void insert(Servidor servidor) {
		String query = "INSERT INTO SERVIDOR VALUES(?,?,?,?,?,?,?,?)";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, servidor.getSiape());
			pst.setString(2, servidor.getCpf());
			pst.setString(3, servidor.getNome());
			pst.setString(4, servidor.getSenha());
			pst.setString(5, String.valueOf(servidor.getDataN()));
			pst.setString(6, servidor.getCnh());
			pst.setString(7, servidor.getCategoria());
			pst.setString(8, servidor.getAutorizadoVeicInstitucional());

			pst.executeUpdate();
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
		
	public static void delete(String siape) {
		String query = "DELETE FROM SERVIDOR WHERE siape = " + siape;
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.executeUpdate(query);
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
	public static String consultParam(String var, String siape) {
		String query = "SELECT " + var + " FROM SERVIDOR WHERE SERVIDOR.siape = " + siape;
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
	
	public static void update(Servidor servidor) {
        String query = "UPDATE SERVIDOR SET cpf = ?, nome = ?, senha = ?, dataNasc = ?, cnh = ?, categoria = ?, "
        				+ "autorizadoVeicAutorizado = ? WHERE siape = ?";
        try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, servidor.getCpf());
			pst.setString(2, servidor.getNome());
			pst.setString(3, servidor.getSenha());
			pst.setString(4, String.valueOf(servidor.getDataNascS()));
			pst.setString(5, servidor.getCnh());
			pst.setString(6, servidor.getCategoria());
			pst.setString(7, servidor.getAutorizadoVeicInstitucional());
			pst.setString(8, servidor.getSiape());

            pst.executeUpdate();
            pst.close();
            disconnection();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }
	
	public static ObservableList<Servidor> list() {
		listServ = FXCollections.observableArrayList();
		String query = "SELECT siape, nome, cnh, categoria, autorizadoVeicInstitucional FROM SERVIDOR";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultSet = pst.executeQuery(query);
			while(resultSet.next()) {
				Servidor serv = new Servidor();
				serv.setSiape(resultSet.getString("siape"));
				serv.setNome(resultSet.getString("nome"));
				serv.setCnh(resultSet.getString("cnh"));
				serv.setCategoria(resultSet.getString("categoria"));
				serv.setAutorizadoVeicInstitucional(resultSet.getString("autorizadoVeicInstitucional"));
				listServ.add(serv);
			}
			
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return listServ;
	}
	
	public static ObservableList<String> siapeList() {
		siapes = FXCollections.observableArrayList();
		String query = "SELECT siape FROM SERVIDOR";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultSet = pst.executeQuery(query);
			while(resultSet.next()) {
				//Servidor serv = new Servidor();
				//serv.setSiape(resultSet.getString("siape"));	
	//			cbSiapeSolicit = new ComboBox<Servidor>();
	//			cbSiapeSolicit.addItem(resultSet.getString("siape"));
				//siapes.add(serv);		
				 siapes.add(resultSet.getString("siape"));
			}
			
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return siapes;
	} 

//	public static void listNomeDepCargo() {
//		String query = "SELECT SERVIDOR.nome, DEPARTAMENTO.sigla, CARGO.titulacao\r\n" + 
//					   "FROM SERVIDOR INNER JOIN LOTADO\r\n" + 
//					   "ON SERVIDOR.siape = LOTADO.siapeServ\r\n" + 
//					   "INNER JOIN DEPARTAMENTO\r\n" + 
//					   "ON DEPARTAMENTO.codigo = LOTADO.codDep\r\n" + 
//					   "INNER JOIN CONTRATADO\r\n" + 
//					   "ON SERVIDOR.siape = CONTRATADO.siapeServ\r\n" + 
//					   "INNER JOIN CARGO\r\n" + 
//					   "ON CARGO.codigo = CONTRATADO.codCargo\r\n" + 
//					   "GROUP BY SERVIDOR.nome;";
//		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
//			ResultSet resultSet = pst.executeQuery(query);
//			while(resultSet.next()) {
//				System.out.println(resultSet.getString("SERVIDOR.nome"));
//				System.out.println(resultSet.getString("DEPARTAMENTO.sigla"));
//				System.out.println(resultSet.getString("CARGO.titulacao"));
//			}
//
//			pst.close();
//			disconnection();
//		} catch (SQLException e) {
//			System.out.println("Erro: " + e);
//		}
//	}
	
}
