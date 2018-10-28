package scesvi.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Contratado {
	
	private final StringProperty siapeServ;
	private final IntegerProperty codCargo;
	private final StringProperty dataInicio;
	private final StringProperty dataFim;
	
	/**
	 * Construtor vazio.
	 */
	public Contratado() {
		this.siapeServ = new SimpleStringProperty("");
		this.codCargo = new SimpleIntegerProperty(0);
		this.dataInicio = new SimpleStringProperty("");
		this.dataFim = new SimpleStringProperty("");
	}
	
	/**
	 * Construtor com parametros.
	 * 
	 * @param siapeServ
	 * @param codCargo
	 * @param dataInicio
	 * @param dataFim
	 */
	public Contratado(String siapeServ, int codCargo, String dataInicio, String dataFim) {
		this.siapeServ = new SimpleStringProperty(siapeServ);
		this.codCargo = new SimpleIntegerProperty(codCargo);
		this.dataInicio = new SimpleStringProperty(dataInicio);
		this.dataFim = new SimpleStringProperty(dataFim);
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
