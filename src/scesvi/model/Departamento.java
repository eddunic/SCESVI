package scesvi.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Departamento {
	
	private final IntegerProperty codigo;
	private final StringProperty nome;
	private final StringProperty sigla;
	
	/**
	 * Construtor vazio.
	 */
	public Departamento() {
		this.codigo = new SimpleIntegerProperty(0);
		this.nome = new SimpleStringProperty("");
		this.sigla = new SimpleStringProperty("");
	}
	
	/**
	 * Construtor com parâmetros.
	 * 
	 * @param codigo
	 * @param nome
	 * @param sigla
	 */
	public Departamento(int codigo, String nome, String sigla) {
		this.codigo = new SimpleIntegerProperty(codigo);
		this.nome = new SimpleStringProperty(nome);
		this.sigla = new SimpleStringProperty(sigla);
	}
	
	/* Getters & Setters */
	public void setCodigo(int codigo) {
		this.codigo.set(codigo);
	}

	public int getCodigo() {
		return codigo.get();
	}

	public IntegerProperty getCodigoProperty() {
		return codigo;
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

	public void setSigla(String sigla) {
		this.sigla.set(sigla);
	}

	public String getSigla() {
		return sigla.get();
	}

	public StringProperty getSiglaProperty() {
		return sigla;
	}


	
}
