package scesvi.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Servidor {

	private final StringProperty matricula;
	private final StringProperty nomeUsuario;
	private final StringProperty dataNasc;
	private final StringProperty senha;
	private final StringProperty CNH;
	private final StringProperty categoria;
	private final StringProperty siape;
	private final StringProperty autorizadoVeicInstitucional;
	private final StringProperty CPF;
	private final StringProperty nome;
	private final StringProperty email;

	/**
	 * Construtor sem parâmetros
	 */
	public Servidor() {
		this.matricula = new SimpleStringProperty("");
		this.nomeUsuario = new SimpleStringProperty("");
		this.dataNasc = new SimpleStringProperty("");
		this.senha = new SimpleStringProperty("");
		this.CNH = new SimpleStringProperty("");
		this.categoria = new SimpleStringProperty("");
		this.siape = new SimpleStringProperty("");
		this.autorizadoVeicInstitucional = new SimpleStringProperty("");
		this.CPF = new SimpleStringProperty("");
		this.nome = new SimpleStringProperty("");
		this.email = new SimpleStringProperty("");
	}

	/**
	 * Construtor com par�metros.
	 * 
	 * @param matricula
	 * @param nomeUsuario
	 * @param dataNasc
	 * @param senha
	 * @param CNH
	 * @param categoria
	 * @param siape
	 * @param autorizadoVeicInstitucional
	 * @param CPF
	 * @param nome
	 * @param email
	 * @param matSupervisor
	 */
	public Servidor(String matricula, String nomeUsuario, String dataNasc, String senha, String CNH, String categoria,
			String siape, String autorizadoVeicInstitucional, String CPF, String nome, String email) {
		this.matricula = new SimpleStringProperty(matricula);
		this.nomeUsuario = new SimpleStringProperty(nomeUsuario);
		this.dataNasc = new SimpleStringProperty(dataNasc);
		this.senha = new SimpleStringProperty(senha);
		this.CNH = new SimpleStringProperty(CNH);
		this.categoria = new SimpleStringProperty(categoria);
		this.siape = new SimpleStringProperty(siape);
		this.autorizadoVeicInstitucional = new SimpleStringProperty(autorizadoVeicInstitucional);
		this.CPF = new SimpleStringProperty(CPF);
		this.nome = new SimpleStringProperty(nome);
		this.email = new SimpleStringProperty(email);
	}

	/* Getters & Setters */
	public void setMatricula(String matricula) {
		this.matricula.set(matricula);
	}

	public String getMatricula() {
		return matricula.get();
	}

	public StringProperty getMatriculaProperty() {
		return matricula;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario.set(nomeUsuario);
	}

	public String getNomeUsuario() {
		return nomeUsuario.get();
	}

	public StringProperty getNomeUsuarioProperty() {
		return nomeUsuario;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc.set(dataNasc);
	}

	public String getDataNasc() {
		return dataNasc.get();
	}

	public StringProperty getDataNascProperty() {
		return dataNasc;
	}
	
	public void setSenha(String senha) {
		this.senha.set(senha);
	}

	public String getSenha() {
		return senha.get();
	}

	public StringProperty getSenhaProperty() {
		return senha;
	}
	
	public void setCnh(String CNH) {
		this.CNH.set(CNH);
	}

	public String getCNH() {
		return CNH.get();
	}

	public StringProperty getCNHProperty() {
		return CNH;
	}
	
	public void setCategoria(String categoria) {
		this.categoria.set(categoria);
	}

	public String getCategoria() {
		return categoria.get();
	}

	public StringProperty getCategoriaProperty() {
		return categoria;
	}
	
	public void setSiape(String siape) {
		this.siape.set(siape);
	}

	public String getSiape() {
		return siape.get();
	}

	public StringProperty getSiapeProperty() {
		return siape;
	}
	
	public void setAutorizadoVeicInstitucional(String autorizadoVeicInstitucional) {
		this.autorizadoVeicInstitucional.set(autorizadoVeicInstitucional);
	}

	public String getAutorizadoVeicInstitucional() {
		return autorizadoVeicInstitucional.get();
	}

	public StringProperty getAutorizadoVeicInstitucionalProperty() {
		return autorizadoVeicInstitucional;
	}
	
	public void setCPF(String CPF) {
		this.CPF.set(CPF);
	}
	
	public String getCPF() {
		return CPF.get();
	}
	
	public StringProperty getCPFProperty() {
		return CPF;
	}
	
	public void setNome(String nome) {
		this.nome.set(nome);
	}
	
	public String getNome() {
		return nome.get();
	}
	
	public StringProperty getNomeProperty() {
		return nome;
	}
	
	public void setEmail(String email) {
		this.email.set(email);
	}
	
	public String getEmail() {
		return email.get();
	}
	
	public StringProperty getEmailProperty() {
		return email;
	}
	
}
