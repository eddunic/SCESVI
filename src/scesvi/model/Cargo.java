package scesvi.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Cargo {
	
	private final IntegerProperty codigo;
	private final StringProperty titulacao;
	
	/**
	 * Construtor vazio.
	 */
	public Cargo() {
		this.codigo = new SimpleIntegerProperty(0);
		this.titulacao = new SimpleStringProperty("");
	}
 	
	/**
	 * Construtor com parâmetros.
	 * 
	 * @param codigo
	 * @param titulacao
	 */
	public Cargo(int codigo, String titulacao) {
		this.codigo = new SimpleIntegerProperty(codigo);
		this.titulacao = new SimpleStringProperty(titulacao);
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
	
	public void setTitulacao(String titulacao) {
		this.titulacao.set(titulacao);
	}
	
	public String getTitulacao() {
		return titulacao.get();
	}
	
	public StringProperty getTitulacaoProperty() {
		return titulacao;
	}
}
