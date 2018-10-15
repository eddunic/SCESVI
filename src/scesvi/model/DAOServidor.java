package scesvi.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOServidor extends DAO {
	
	private static Servidor servidor;
	
	public static Servidor getServidor() {
		return servidor;
	}
	
	public static void insert(Servidor servidor) {
		String query = "INSERT INTO SERVIDOR VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, servidor.getMatricula());
			pst.setString(2, servidor.getNomeUsuario());
			pst.setString(3, servidor.getDataNasc());
			pst.setString(4, servidor.getSenha());
			pst.setString(5, servidor.getCNH());
			pst.setString(6, servidor.getCategoria());
			pst.setString(7, servidor.getSiape());
			pst.setString(8, servidor.getAutorizadoVeicInstitucional());
			pst.setString(9, servidor.getCPF());
			pst.setString(10, servidor.getNome());
			pst.setString(11, servidor.getEmail());

			pst.executeUpdate();
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
}
