package scesvi.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
}
