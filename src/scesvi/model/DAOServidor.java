package scesvi.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOServidor extends DAO {
	
	private static Servidor servidor;
	
	public static Servidor getServidor() {
		return servidor;
	}
	
	public static void inserir(Servidor servidor) {
		String query = "insert into servidor values(?,?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, servidor.getMatricula());
			pst.setString(2, servidor.getNomeUsuario());
			pst.setString(3, servidor.getSenha());
			pst.setString(4, servidor.getCNH());
			pst.setString(5, String.valueOf(servidor.getCategoria()));
			pst.setString(6, servidor.getSiape());
			pst.setString(7, String.valueOf(servidor.getAutorizadoVeicInstitucional()));
			pst.setString(8, servidor.getCPF());
			pst.setString(9, servidor.getNome());
			pst.setString(10, servidor.getEmail());

			pst.executeUpdate();
			pst.close();
			disconnection();
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
	}
	
}
