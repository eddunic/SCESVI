package scesvi.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Telefone {
	
	private final StringProperty siapeServ;
	private final StringProperty telefone;
	
	/**
	 * Construtor vazio.
	 */
	public Telefone() {
		this.siapeServ = new SimpleStringProperty("");
		this.telefone = new SimpleStringProperty("");
	}
	
	/**
	 * Construtor com parâmetros.
	 * 
	 * @param siapeServ
	 * @param telefone
	 */
	public Telefone(String siapeServ, String telefone) {
		this.siapeServ = new SimpleStringProperty(siapeServ);
		this.telefone = new SimpleStringProperty(telefone);
	}
	
	/* Getters & Setters */
	public void setSiapeServ(String siapeServ) {
		this.siapeServ.set(siapeServ);
	}

	public String getSiapeServ() {
		return siapeServ.get();
	}

	public StringProperty getSiapeServProperty() {
		return siapeServ;
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
