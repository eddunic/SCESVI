package scesvi.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import scesvi.model.Departamento;

public class DAODepartamentoSP extends DAO {
	
	private static Departamento departamento;
	private static int codDep;
	
	public static Departamento getDepartamento() {
		return departamento;
	}
	
	public static int searchDepart(String departamento) {
		String query = "CALL sp_SearchDepart(" + departamento + ")";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			ResultSet resultSet = pst.executeQuery(query);
			while(resultSet.next()) {
				codDep = resultSet.getInt("codigo");
			}
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return codDep;
	}
	
}
