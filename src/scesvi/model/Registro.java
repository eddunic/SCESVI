package scesvi.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Registro {

	private final IntegerProperty numero;
	private final StringProperty codVeiculo;
	private final StringProperty siapeServInicia;
	private final StringProperty siapeServEncerra;
	private final StringProperty siapeServResponsavel;

	private final StringProperty observacao;
	private final StringProperty descricao;
	private final IntegerProperty kmInicial;
	private final IntegerProperty kmFinal;
	private final IntegerProperty kmPercorridos;
	
	private final StringProperty horaInicia;
	private final StringProperty horaSaida;
	private final StringProperty horaEntrada;
	private final StringProperty horaEncerra;
	
	private final StringProperty dataInicia;
	private final StringProperty dataSaida;
	private final StringProperty dataEntrada;
	private final StringProperty dataEncerra;
	private final StringProperty dataSupervisionado;
	

	/**
	 * Construtor vazio.
	 */
	public Registro() {
		this.numero = new SimpleIntegerProperty(0);
		this.observacao = new SimpleStringProperty("");
		this.codVeiculo = new SimpleStringProperty("");
		this.siapeServInicia = new SimpleStringProperty("");
		this.siapeServEncerra = new SimpleStringProperty("");
		this.siapeServResponsavel = new SimpleStringProperty("");
		this.horaInicia = new SimpleStringProperty("");
		this.dataInicia = new SimpleStringProperty("");
		this.dataSaida = new SimpleStringProperty("");
		this.horaSaida = new SimpleStringProperty("");
		this.dataEntrada = new SimpleStringProperty("");
		this.horaEntrada = new SimpleStringProperty("");
		this.horaEncerra = new SimpleStringProperty("");
		this.dataEncerra = new SimpleStringProperty("");
		this.descricao = new SimpleStringProperty("");
		this.kmInicial = new SimpleIntegerProperty(0);
		this.kmFinal = new SimpleIntegerProperty(0);
		this.kmPercorridos = new SimpleIntegerProperty(0);
		this.dataSupervisionado = new SimpleStringProperty("");
	}

	/**
	 * Construtor com parâmetros.
	 * 
	 * @param numero
	 * @param observacao
	 * @param codVeiculo
	 * @param siapeServInicia
	 * @param siapeServEncerra
	 * @param siapeServResponsavel
	 * @param horaInicia
	 * @param dataInicia
	 * @param dataSaida
	 * @param horaSaida
	 * @param dataEntrada
	 * @param horaEntrada
	 * @param horaEncerra
	 * @param dataEncerra
	 * @param descricao
	 * @param kmInicial
	 * @param kmFinal
	 * @param kmPercorridos
	 * @param dataSupervisionado
	 */
	public Registro(int numero, String observacao, String codVeiculo, String siapeServInicia, String siapeServEncerra,
			String siapeServResponsavel, String horaInicia, String dataInicia, String dataSaida,
			String horaSaida, String dataEntrada, String horaEntrada, String horaEncerra, String dataEncerra,
			String descricao, int kmInicial, int kmFinal, int kmPercorridos, String dataSupervisionado) {
		this.numero = new SimpleIntegerProperty(numero);
		this.observacao = new SimpleStringProperty(observacao);
		this.codVeiculo = new SimpleStringProperty(codVeiculo);
		this.siapeServInicia = new SimpleStringProperty(siapeServInicia);
		this.siapeServEncerra = new SimpleStringProperty(siapeServEncerra);
		this.siapeServResponsavel = new SimpleStringProperty(siapeServResponsavel);
		this.horaInicia = new SimpleStringProperty(horaInicia);
		this.dataInicia = new SimpleStringProperty(dataInicia);
		this.dataSaida = new SimpleStringProperty(dataSaida);
		this.horaSaida = new SimpleStringProperty(horaSaida);
		this.dataEntrada = new SimpleStringProperty(dataEntrada);
		this.horaEntrada = new SimpleStringProperty(horaEntrada);
		this.horaEncerra = new SimpleStringProperty(horaEncerra);
		this.dataEncerra = new SimpleStringProperty(dataEncerra);
		this.descricao = new SimpleStringProperty(descricao);
		this.kmInicial = new SimpleIntegerProperty(kmInicial);
		this.kmFinal = new SimpleIntegerProperty(kmFinal);
		this.kmPercorridos = new SimpleIntegerProperty(kmPercorridos);
		this.dataSupervisionado = new SimpleStringProperty(dataSupervisionado);
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

	public void setObservacao(String observacao) {
		this.observacao.set(observacao);
	}

	public String getObservacao() {
		return observacao.get();
	}

	public StringProperty getObservacaoProperty() {
		return observacao;
	}

	public void setCodVeiculo(String codVeiculo) {
		this.codVeiculo.set(codVeiculo);
	}

	public String getCodVeiculo() {
		return codVeiculo.get();
	}

	public StringProperty getCodVeiculoProperty() {
		return codVeiculo;
	}

	public void setSiapeServInicia(String siapeServInicia) {
		this.siapeServInicia.set(siapeServInicia);
	}

	public String getSiapeServInicia() {
		return siapeServInicia.get();
	}

	public StringProperty getSiapeServIniciaProperty() {
		return siapeServInicia;
	}

	public void setSiapeServEncerra(String siapeServEncerra) {
		this.siapeServEncerra.set(siapeServEncerra);
	}

	public String getSiapeServEncerra() {
		return siapeServEncerra.get();
	}

	public StringProperty getSiapeServEncerraProperty() {
		return siapeServEncerra;
	}

	public void setSiapeServResponsavel(String siapeServResponsavel) {
		this.siapeServResponsavel.set(siapeServResponsavel);
	}

	public String getSiapeServResponsavel() {
		return siapeServResponsavel.get();
	}

	public StringProperty getSiapeServResponsavelProperty() {
		return siapeServResponsavel;
	}

	public void setHoraInicia(String horaInicia) {
		this.horaInicia.set(horaInicia);
	}

	public String getHoraInicia() {
		return horaInicia.get();
	}

	public StringProperty getHoraIniciaProperty() {
		return horaInicia;
	}

	public void setDataInicia(String dataInicia) {
		this.dataInicia.set(dataInicia);
	}

	public String getDataInicia() {
		return dataInicia.get();
	}

	public StringProperty getDataIniciaProperty() {
		return dataInicia;
	}

	public void setHoraSaida(String horaSaida) {
		this.horaSaida.set(horaSaida);
	}

	public String getHoraSaida() {
		return horaSaida.get();
	}

	public StringProperty getHoraSaidaProperty() {
		return horaSaida;
	}

	public void setDataSaida(String dataSaida) {
		this.dataSaida.set(dataSaida);
	}

	public String getDataSaida() {
		return dataSaida.get();
	}

	public StringProperty getDataSaidaProperty() {
		return dataSaida;
	}

	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada.set(dataEntrada);
	}

	public String getDataEntrada() {
		return dataEntrada.get();
	}

	public StringProperty getDataEntradaProperty() {
		return dataEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada.set(horaEntrada);
	}

	public String getHoraEntrada() {
		return horaEntrada.get();
	}

	public StringProperty getHoraEntradaProperty() {
		return horaEntrada;
	}

	public void setDataEncerra(String dataEncerra) {
		this.dataEncerra.set(dataEncerra);
	}

	public String getDataEncerra() {
		return dataEncerra.get();
	}

	public StringProperty getDataEncerraProperty() {
		return dataEncerra;
	}

	public void setHoraEncerra(String horaEncerra) {
		this.horaEncerra.set(horaEncerra);
	}

	public String getHoraEncerra() {
		return horaEncerra.get();
	}

	public StringProperty getHoraEncerraProperty() {
		return horaEncerra;
	}

	public void setDescricao(String descricao) {
		this.descricao.set(descricao);
	}

	public String getDescricao() {
		return descricao.get();
	}

	public StringProperty getDescricaoProperty() {
		return descricao;
	}

	public void setKmInicial(int kmInicial) {
		this.kmInicial.set(kmInicial);
	}

	public int getKmInicial() {
		return kmInicial.get();
	}

	public IntegerProperty getKmInicialProperty() {
		return kmInicial;
	}

	public void setKmFinal(int kmFinal) {
		this.kmFinal.set(kmFinal);
	}

	public int getKmFinal() {
		return kmFinal.get();
	}

	public IntegerProperty getKmFinalProperty() {
		return kmFinal;
	}

	public void setKmPercorridos(int kmPercorridos) {
		this.kmPercorridos.set(kmPercorridos);
	}

	public int getKmPercorridos() {
		return kmPercorridos.get();
	}

	public IntegerProperty getKmPercorridosProperty() {
		return kmPercorridos;
	}

	public void setDataSupervisionado(String dataSupervisionado) {
		this.dataSupervisionado.set(dataSupervisionado);
	}

	public String getDataSupervisionado() {
		return dataSupervisionado.get();
	}

	public StringProperty getDataSupervisionadoProperty() {
		return dataSupervisionado;
	}


}
