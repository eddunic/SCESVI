package scesvi.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Telefone {
	
	private final StringProperty matServ;
	private final StringProperty telefone;
	
	/**
	 * Construtor vazio.
	 */
	public Telefone() {
		this.matServ = new SimpleStringProperty("");
		this.telefone = new SimpleStringProperty("");
	}
	
	/**
	 * Construtor com parâmetros.
	 * 
	 * @param matServ
	 * @param telefone
	 */
	public Telefone(String matServ, String telefone) {
		this.matServ = new SimpleStringProperty(matServ);
		this.telefone = new SimpleStringProperty(telefone);
	}
	
	/* Getters & Setters */
	public void setMatServ(String matServ) {
		this.matServ.set(matServ);
	}

	public String getMatServ() {
		return matServ.get();
	}

	public StringProperty getMatServProperty() {
		return matServ;
	}

	public void setTelefone(String telefone) {
		this.telefone.set(telefone);
	}

	public String getTelefone() {
		return telefone.get();
	}

	public StringProperty getTelefoneProperty() {
		return telefone;
	}


}
