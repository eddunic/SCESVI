package scesvi.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import scesvi.model.Servidor;

public class DAOServidorSP extends DAO {
	
	private static Servidor servidor;
	
	public static Servidor getServidor() {
		return servidor;
	}
	
	public static void insert(Servidor servidor) {
		String query = "CALL sp_InsertServidor(?,?,?,?,?,?,?,?)";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, servidor.getSiape());
			pst.setString(2, servidor.getCpf());
			pst.setString(3, servidor.getNome());
			pst.setString(4, servidor.getSenha());
			pst.setString(5, servidor.getDataNascS());
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
		String query = "CALL sp_DeleteServidor(" + siape + ")";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.executeUpdate(query);
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
	public static void consultServidor(String siape) {
		String query = "CALL sp_ConsultServidor(" + siape + ")";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultset = pst.executeQuery(query);
			while(resultset.next()) {
				System.out.println(resultset.getString("nome"));
				System.out.println(resultset.getString("senha"));
			}

			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
	public static void list() {
		String query = "CALL sp_ListServidor()";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultset = pst.executeQuery(query);
			while(resultset.next()) {
				System.out.println(resultset.getString("nome"));
			}

			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
	public static void listNomeDepCargo() {
		String query = "CALL sp_ListNomeDepCargo()";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultset = pst.executeQuery(query);
			while(resultset.next()) {
				System.out.println(resultset.getString("SERVIDOR.nome"));
				System.out.println(resultset.getString("DEPARTAMENTO.sigla"));
				System.out.println(resultset.getString("CARGO.titulacao"));
			}

			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
}

