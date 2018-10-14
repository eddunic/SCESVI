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
}
