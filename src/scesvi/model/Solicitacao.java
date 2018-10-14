package scesvi.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Solicitacao {

	private final IntegerProperty veiculoRequisitado;
	private final StringProperty dataVeiculoConfirmado;
	private final StringProperty dataInicio;
	private final StringProperty dataFim;
	private final StringProperty horaCriacao;
	private final StringProperty dataCriacao;
	private final StringProperty localViagem;
	private final StringProperty horaAutorizado;
	private final StringProperty dataAutorizado;
	private final IntegerProperty qtdePassageiros;
	private final StringProperty tipo;
	private final StringProperty finalidade;
	private final StringProperty matServAutoriza;
	private final StringProperty matServRealiza;
	private final StringProperty codVeiculoAtende;

	/**
	 * Construtor vazio.
	 */
	public Solicitacao() {
		this.veiculoRequisitado = new SimpleIntegerProperty(0);
		this.dataVeiculoConfirmado = new SimpleStringProperty("");
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
		this.matServAutoriza = new SimpleStringProperty("");
		this.matServRealiza = new SimpleStringProperty("");
		this.codVeiculoAtende = new SimpleStringProperty("");
	}
	
	/**
	 * Construtor com parâmetros.
	 * 
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
	 * @param matServAutoriza
	 * @param matServRealiza
	 * @param codVeiculoAtende
	 */
	public Solicitacao(int veiculoRequisitado, String dataVeiculoConfirmado, String dataInicio, String dataFim,
			String horaCriacao, String dataCriacao, String localViagem, String horaAutorizado, String dataAutorizado,
			int qtdePassageiros, String tipo, String finalidade, String matServAutoriza, String matServRealiza,
			String codVeiculoAtende) {
		this.veiculoRequisitado = new SimpleIntegerProperty(veiculoRequisitado);
		this.dataVeiculoConfirmado = new SimpleStringProperty(dataVeiculoConfirmado);
		this.dataInicio = new SimpleStringProperty(dataInicio);
		this.dataFim = new SimpleStringProperty(dataFim);
		this.horaCriacao = new SimpleStringProperty(horaCriacao);
		this.dataCriacao = new SimpleStringProperty(dataCriacao);
		this.localViagem = new SimpleStringProperty(localViagem);
		this.horaAutorizado = new SimpleStringProperty(horaAutorizado);
		this.dataAutorizado = new SimpleStringProperty(dataAutorizado);
		this.qtdePassageiros = new SimpleIntegerProperty(qtdePassageiros);
		this.tipo = new SimpleStringProperty(tipo);
		this.finalidade = new SimpleStringProperty(finalidade);
		this.matServAutoriza = new SimpleStringProperty(matServAutoriza);
		this.matServRealiza = new SimpleStringProperty(matServRealiza);
		this.codVeiculoAtende = new SimpleStringProperty(codVeiculoAtende);
	}
	
	/* Getters & Setters */
	public void setVeiculoRequisitado(int veiculoRequisitado) {
		this.veiculoRequisitado.set(veiculoRequisitado);
	}

	public int getVeiculoRequisitado() {
		return veiculoRequisitado.get();
	}

	public IntegerProperty getVeiculoRequisitadoProperty() {
		return veiculoRequisitado;
	}

	public void setDataVeiculoConfirmado(String dataVeiculoConfirmado) {
		this.dataVeiculoConfirmado.set(dataVeiculoConfirmado);
	}

	public String getDataVeiculoConfirmado() {
		return dataVeiculoConfirmado.get();
	}

	public StringProperty getDataVeiculoConfirmadoProperty() {
		return dataVeiculoConfirmado;
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

	public void setMatServAutoriza(String matServAutoriza) {
		this.matServAutoriza.set(matServAutoriza);
	}

	public String getMatServAutoriza() {
		return matServAutoriza.get();
	}

	public StringProperty getMatServAutorizaProperty() {
		return matServAutoriza;
	}

	public void setMatServRealiza(String matServRealiza) {
		this.matServRealiza.set(matServRealiza);
	}

	public String getMatServRealiza() {
		return matServRealiza.get();
	}

	public StringProperty getMatServRealizaProperty() {
		return matServRealiza;
	}

	public void setCodVeiculoAtende(String codVeiculoAtende) {
		this.codVeiculoAtende.set(codVeiculoAtende);
	}

	public String getCodVeiculoAtende() {
		return codVeiculoAtende.get();
	}

	public StringProperty getCodVeiculoAtendeProperty() {
		return codVeiculoAtende;
	}


	
}
