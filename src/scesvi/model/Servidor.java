package scesvi.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Servidor {

	private final StringProperty siape;
	private final StringProperty cpf;
	private final StringProperty nome;
	private final StringProperty senha;
	private final ObjectProperty<LocalDate> dataNasc;
	private static StringProperty dataNascS;
	private final StringProperty cnh;
	private final StringProperty categoria;
	private final StringProperty autorizadoVeicInstitucional;

	/**
	 * Construtor sem parametros
	 */
	public Servidor() {
		this.siape = new SimpleStringProperty("");
		this.cpf = new SimpleStringProperty("");
		this.nome = new SimpleStringProperty("");
		this.senha = new SimpleStringProperty("");
		this.dataNasc = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
		Servidor.dataNascS = new SimpleStringProperty("");
		this.cnh = new SimpleStringProperty("");
		this.categoria = new SimpleStringProperty("");
		this.autorizadoVeicInstitucional = new SimpleStringProperty("");
	}

	/*
	 * Construtor com parametros.
	 * 
	 * @param siape
	 * 
	 * @param cpf
	 * 
	 * @param nome
	 * 
	 * @param senha
	 * 
	 * @param dataNasc
	 * 
	 * @param cnh
	 * 
	 * @param categoria
	 * 
	 * @param autorizadoVeicInstitucional
	 */
	public Servidor(String siape, String cpf, String nome, String senha, LocalDate dataNasc, String cnh,
			String categoria, String autorizadoVeicInstitucional) {

		this.siape = new SimpleStringProperty(siape);
		this.cpf = new SimpleStringProperty(cpf);
		this.nome = new SimpleStringProperty(nome);
		this.senha = new SimpleStringProperty(senha);
		this.dataNasc = new SimpleObjectProperty<LocalDate>(dataNasc);
		Servidor.dataNascS = format(getDataNasc());
		this.cnh = new SimpleStringProperty(cnh);
		this.categoria = new SimpleStringProperty(categoria);
		this.autorizadoVeicInstitucional = new SimpleStringProperty(autorizadoVeicInstitucional);
	}

	/* Getters & Setters */

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc.set(dataNasc);
	}

	public LocalDate getDataNasc() {
		return dataNasc.get();
	}
	
	public String getDataN(){
		return dataNascS.get();
	}
	
	public void setDataN(String dataNascS) {
		this.dataNascS.set(dataNascS);
	}

	public ObjectProperty<LocalDate> dataNascProperty() {
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

	public void setCnh(String cnh) {
		this.cnh.set(cnh);
	}

	public String getCnh() {
		return cnh.get();
	}

	public StringProperty getCnhProperty() {
		return cnh;
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

	public void setCpf(String cpf) {
		this.cpf.set(cpf);
	}

	public String getCpf() {
		return cpf.get();
	}

	public StringProperty getCpfProperty() {
		return cpf;
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

	public StringProperty getDataNascS() {
		return dataNascS;
	}

	public String setDataNascS(String dataNascS) {
		return dataNascS;
	}

	public static StringProperty format(LocalDate date) {
		if (date == null) {
			return null;
		}
		dataNascS = new SimpleStringProperty((String) date.format(DateTimeFormatter.BASIC_ISO_DATE));
		return dataNascS;
	}

}
