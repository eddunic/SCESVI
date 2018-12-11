package scesvi.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SolicitVeiculo {
	
	private final StringProperty numSolicit;
	private final StringProperty codVeic;
	private final StringProperty situacao;
	
	/**
	 * Construtor vazio.
	 */
	public SolicitVeiculo() {
		this.numSolicit = new SimpleStringProperty("");
		this.codVeic = new SimpleStringProperty("");
		this.situacao = new SimpleStringProperty("");
	}
	
	/**
	 * Construtor com parametros.
	 * 
	 * @param numSolicit
	 * @param codVeic
	 */
	public SolicitVeiculo(int numSolicit, String codVeic, String situ) {
		this.numSolicit = new SimpleStringProperty(String.valueOf(numSolicit));
		this.codVeic = new SimpleStringProperty(codVeic);
		this.situacao = new SimpleStringProperty(situ);
	}
	
	/* Getters & Setters */
	public void setNumSolicit(int numSolicit) {
		this.numSolicit.set((String.valueOf(numSolicit)));
	}

	public String getNumSolicit() {
		return numSolicit.get();
	}

	public StringProperty getNumSolicitProperty() {
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
	
	public void setSituacao (String situ) {
		this.situacao.set(situ);
	}

	public String getSituacao() {
		return situacao.get();
	}

	public StringProperty getSituacaoProperty() {
		return situacao;
	}

}
