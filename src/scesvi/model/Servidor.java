package scesvi.model;

public class Servidor {
	private Long matricula;
	private String nomeUsuario;
	private String senha;
	private String cnh;
	private char categoria;
	private String siape;
	private String nome;
	private char autorizadoVeicInstitucional;
	private String CPF;
	private String email;

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCNH() {
		return cnh;
	}

	public void setCNH(String cNH) {
		cnh = cNH;
	}

	public char getCategoria() {
		return categoria;
	}

	public void setCategoria(char categoria) {
		this.categoria = categoria;
	}

	public String getSiape() {
		return siape;
	}

	public void setSiape(String siape) {
		this.siape = siape;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getAutorizadoVeicInstitucional() {
		return autorizadoVeicInstitucional;
	}

	public void setAutorizadoVeicInstitucional(char autorizadoVeicInstitucional) {
		this.autorizadoVeicInstitucional = autorizadoVeicInstitucional;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
