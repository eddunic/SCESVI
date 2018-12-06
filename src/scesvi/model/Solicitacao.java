package scesvi.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Solicitacao {

	private final IntegerProperty numero;

	private final StringProperty horaCriacao;
	private final StringProperty localViagem;
	private final StringProperty horaAutorizado;

	private final IntegerProperty qtdePassageiros;
	private final StringProperty tipo;
	private final StringProperty finalidade;
	private final StringProperty siapeServAutoriza;
	private final StringProperty siapeServRealiza;

	private final StringProperty dataInicio;
	private final StringProperty dataFim;
	private final StringProperty dataAutorizado;
	private StringProperty dataCriacao;

	private ObjectProperty<LocalDate> dataLocalDate;

	/**
	 * Construtor vazio.
	 */
	public Solicitacao() {
		this.numero = new SimpleIntegerProperty(0);
		this.dataInicio = new SimpleStringProperty("");
		this.dataFim = new SimpleStringProperty("");
		this.horaCriacao = new SimpleStringProperty("");
		this.dataCriacao = new SimpleStringProperty("");
		this.localViagem = new SimpleStringProperty("");
		this.horaAutorizado = new SimpleStringProperty("");
		this.dataAutorizado = new SimpleStringProperty("");
		this.qtdePassageiros = new SimpleIntegerProperty(0);
		this.tipo = new SimpleStringProperty("");
		this.finalidade = new SimpleStringProperty("");
		this.siapeServAutoriza = new SimpleStringProperty("");
		this.siapeServRealiza = new SimpleStringProperty("");

		this.dataLocalDate = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
	}

	/**
	 * Construtor com parametros.
	 * 
	 * @param numero
	 * @param veiculoRequisitado
	 * @param dataVeiculoConfirmado
	 * @param dataInicio
	 * @param dataFim
	 * @param horaCriacao
	 * @param dataCriacao
	 * @param localViagem
	 * @param horaAutorizado
	 * @param dataAutorizado
	 * @param qtdePassageiros
	 * @param tipo
	 * @param finalidade
	 * @param siapeServAutoriza
	 * @param siapeServRealiza
	 */

	public Solicitacao(int numero, String dataIni, String dataF, String dataAut,
			String horaAuto, String dataC, String horaCriacao, String localViagem,
			int qtdePassageiros, String tipo, String finalidade, String siapeServAutoriza, String siapeServRealiza) {
		this.numero = new SimpleIntegerProperty(numero);
		this.horaCriacao = new SimpleStringProperty(horaCriacao);
		this.localViagem = new SimpleStringProperty(localViagem);
		this.qtdePassageiros = new SimpleIntegerProperty(qtdePassageiros);
		this.tipo = new SimpleStringProperty(tipo);
		this.finalidade = new SimpleStringProperty(finalidade);
		this.siapeServAutoriza = new SimpleStringProperty(siapeServAutoriza);
		this.siapeServRealiza = new SimpleStringProperty(siapeServRealiza);
		this.dataCriacao = new SimpleStringProperty(dataC);

		this.dataInicio = new SimpleStringProperty(dataIni);
		this.dataFim = new SimpleStringProperty(dataF);
		this.dataCriacao = new SimpleStringProperty(dataC);
		this.dataAutorizado = new SimpleStringProperty(dataAut);
		
		horaAutorizado = new SimpleStringProperty(horaAuto);
	}

	public void setDataNasc(LocalDate data) {
		this.dataLocalDate.set(data);
	}

	public LocalDate getData() {
		return dataLocalDate.get();
	}

	public String getDataString(String TipoData) {
		switch (TipoData) {
		case "dataInicio":
			return dataInicio.get();
		case "dataFim":
			return dataFim.get();
		case "dataAutorizado":
			return dataAutorizado.get();
		}
		return TipoData;
	}

	// String Property formatada a partir de localDate para armazenar em alguma das
	// datas
	public static StringProperty format(LocalDate date) {
		if (date == null) {
			return null;
		}
		return new SimpleStringProperty((String) date.format(DateTimeFormatter.BASIC_ISO_DATE));
	}

	/* Getters & Setters */
	public void setNumero(int numero) {
		this.numero.set(numero);
	}

	public int getNumero() {
		return numero.get();
	}

	public IntegerProperty getNumeroProperty() {
		return numero;
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

	public void setHoraCriacao(String horaCriacao) {
		this.horaCriacao.set(horaCriacao);
	}

	public String getHoraCriacao() {
		return horaCriacao.get();
	}

	public StringProperty getHoraCriacaoProperty() {
		return horaCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao.set(dataCriacao);
	}

	public String getDataCriacao() {
		return dataCriacao.get();
	}

	public StringProperty getDataCriacaoProperty() {
		return dataCriacao;
	}

	public void setLocalViagem(String localViagem) {
		this.localViagem.set(localViagem);
	}

	public String getLocalViagem() {
		return localViagem.get();
	}

	public StringProperty getLocalViagemProperty() {
		return localViagem;
	}

	public void setHoraAutorizado(String horaAutorizado) {
		this.horaAutorizado.set(horaAutorizado);
	}

	public String getHoraAutorizado() {
		return horaAutorizado.get();
	}

	public StringProperty getHoraAutorizadoProperty() {
		return horaAutorizado;
	}

	public void setDataAutorizado(String dataAutorizado) {
		this.dataAutorizado.set(dataAutorizado);
	}

	public String getDataAutorizado() {
		return dataAutorizado.get();
	}

	public StringProperty getDataAutorizadoProperty() {
		return dataAutorizado;
	}

	public void setQtdePassageiros(int qtdePassageiros) {
		this.qtdePassageiros.set(qtdePassageiros);
	}

	public int getQtdePassageiros() {
		return qtdePassageiros.get();
	}

	public IntegerProperty getQtdePassageirosProperty() {
		return qtdePassageiros;
	}

	public void setTipo(String tipo) {
		this.tipo.set(tipo);
	}

	public String getTipo() {
		return tipo.get();
	}

	public StringProperty getTipoProperty() {
		return tipo;
	}

	public void setFinalidade(String finalidade) {
		this.finalidade.set(finalidade);
	}

	public String getFinalidade() {
		return finalidade.get();
	}

	public StringProperty getFinalidadeProperty() {
		return finalidade;
	}

	public void setSiapeServAutoriza(String siapeServAutoriza) {
		this.siapeServAutoriza.set(siapeServAutoriza);
	}

	public String getSiapeServAutoriza() {
		return siapeServAutoriza.get();
	}

	public StringProperty getSiapeServAutorizaProperty() {
		return siapeServAutoriza;
	}

	public void setSiapeServRealiza(String siapeServRealiza) {
		this.siapeServRealiza.set(siapeServRealiza);
	}

	public String getSiapeServRealiza() {
		return siapeServRealiza.get();
	}

	public StringProperty getSiapeServRealizaProperty() {
		return siapeServRealiza;
	}

}
