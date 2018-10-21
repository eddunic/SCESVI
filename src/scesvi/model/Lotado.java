package scesvi.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Lotado {
	
	private final StringProperty matServ;
	private final IntegerProperty codDep;
	private final StringProperty dataInicio;
	private final StringProperty dataFim;
	
	/**
	 * Construtor vazio.
	 */
	public Lotado() {
		this.matServ = new SimpleStringProperty("");
		this.codDep = new SimpleIntegerProperty(0);
		this.dataInicio = new SimpleStringProperty("");
		this.dataFim = new SimpleStringProperty("");
	}
	
	/**
	 * Construtor com parâmetros.
	 * 
	 * @param matServ
	 * @param codDep
	 * @param dataInicio
	 * @param dataFim
	 */
	public Lotado(String matServ, int codDep, String dataInicio, String dataFim) {
		this.matServ = new SimpleStringProperty(matServ);
		this.codDep = new SimpleIntegerProperty(codDep);
		this.dataInicio = new SimpleStringProperty(dataInicio);
		this.dataFim = new SimpleStringProperty(dataFim);
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

	public void setCodDep(int codDep) {
		this.codDep.set(codDep);
	}

	public int getCodDep() {
		return codDep.get();
	}

	public IntegerProperty getCodDepProperty() {
		return codDep;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio.set(dataInicio);
	}

	public String getDataInicio() {
		return dataInicio.get();
	}

	public StringProperty getDataInicioProperty() {
		return dataInicio;
	}

	public void setDataFim(String dataFim) {
		this.dataFim.set(dataFim);
	}

	public String getDataFim() {
		return dataFim.get();
	}

	public StringProperty getDataFimProperty() {
		return dataFim;
	}


}
