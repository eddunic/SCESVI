package scesvi.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SolicitVeiculo {
	
	private final IntegerProperty numSolicit;
	private final StringProperty codVeic;
	
	/**
	 * Construtor vazio.
	 */
	public SolicitVeiculo() {
		this.numSolicit = new SimpleIntegerProperty(0);
		this.codVeic = new SimpleStringProperty("");
	}
	
	/**
	 * Construtor com parâmetros.
	 * 
	 * @param numSolicit
	 * @param codVeic
	 */
	public SolicitVeiculo(int numSolicit, String codVeic) {
		this.numSolicit = new SimpleIntegerProperty(numSolicit);
		this.codVeic = new SimpleStringProperty(codVeic);
	}
	
	/* Getters & Setters */
	public void setNumSolicit(int numSolicit) {
		this.numSolicit.set(numSolicit);
	}

	public int getNumSolicit() {
		return numSolicit.get();
	}

	public IntegerProperty getNumSolicitProperty() {
		return numSolicit;
	}

	public void setCodVeic(String codVeic) {
		this.codVeic.set(codVeic);
	}

	public String getCodVeic() {
		return codVeic.get();
	}

	public StringProperty getCodVeicProperty() {
		return codVeic;
	}


}
