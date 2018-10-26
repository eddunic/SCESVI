package scesvi.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import scesvi.model.Departamento;

public class DAODepartamento extends DAO {

	private static Departamento departamento;
	
	public static Departamento getDepartamento() {
		return departamento;
	}
	
	public static void insert(Departamento departamento) {
		String query = "INSERT INTO DEPARTAMENTO VALUES(?,?,?)";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, String.valueOf(departamento.getCodigo()));
			pst.setString(2, departamento.getNome());
			pst.setString(3, departamento.getSigla());

			pst.executeUpdate();
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
	public static void searchDepart(String departamento) {
		String query = "SELECT codigo, nome, sigla FROM DEPARTAMENTO WHERE sigla = " + departamento;
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
	
}
