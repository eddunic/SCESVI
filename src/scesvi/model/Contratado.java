package scesvi.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Contratado {
	
	private final StringProperty matServ;
	private final IntegerProperty codCargo;
	private final StringProperty dataInicio;
	private final StringProperty dataFim;
	
	/**
	 * Construtor vazio.
	 */
	public Contratado() {
		this.matServ = new SimpleStringProperty("");
		this.codCargo = new SimpleIntegerProperty(0);
		this.dataInicio = new SimpleStringProperty("");
		this.dataFim = new SimpleStringProperty("");
	}
	
	/**
	 * Construtor com parâmetros.
	 * 
	 * @param matServ
	 * @param codCargo
	 * @param dataInicio
	 * @param dataFim
	 */
	public Contratado(String matServ, int codCargo, String dataInicio, String dataFim) {
		this.matServ = new SimpleStringProperty(matServ);
		this.codCargo = new SimpleIntegerProperty(codCargo);
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

	public void setCodCargo(int codCargo) {
		this.codCargo.set(codCargo);
	}

	public int getCodCargo() {
		return codCargo.get();
	}

	public IntegerProperty getCodCargoProperty() {
		return codCargo;
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
