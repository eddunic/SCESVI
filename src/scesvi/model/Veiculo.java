package scesvi.model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Veiculo {

	private final IntegerProperty codigo;
	private final StringProperty placa;
	private final StringProperty renavam;
	private final StringProperty autorizado;
	private final StringProperty categoria;
	private final StringProperty institucional;
	private final IntegerProperty maxPassageiros;
	private final StringProperty observacao;
	private final StringProperty cor;
	private final StringProperty marcaModelo;
	private final StringProperty dataSupervisionado;
	private final StringProperty situacao;
	private final StringProperty siapeServSupervisiona;
	private final StringProperty siapeServResponsavel;

	/**
	 * Construtor vazio.
	 */
	public Veiculo() {
		this.codigo = new SimpleIntegerProperty(0);
		this.placa = new SimpleStringProperty("");
		this.renavam = new SimpleStringProperty("");
		this.autorizado = new SimpleStringProperty("");
		this.categoria = new SimpleStringProperty("");
		this.institucional = new SimpleStringProperty("");
		this.maxPassageiros = new SimpleIntegerProperty(0);
		this.observacao = new SimpleStringProperty("");
		this.cor = new SimpleStringProperty("");
		this.marcaModelo = new SimpleStringProperty("");
		this.dataSupervisionado = new SimpleStringProperty("");
		this.siapeServSupervisiona = new SimpleStringProperty("");
		this.siapeServResponsavel = new SimpleStringProperty("");
		this.situacao = new SimpleStringProperty("");
	}

	/**
	 * Construtor com parametros.
	 * 
	 * @param codigo
	 * @param tipo
	 * @param placa
	 * @param renavam
	 * @param autorizado
	 * @param categoria
	 * @param institucional
	 * @param chassi
	 * @param maxPassageiros
	 * @param observacao
	 * @param exercicio
	 * @param tipoCombustivel
	 * @param potencia
	 * @param cor
	 * @param marcaModelo
	 * @param anoFabricacao
	 * @param anoModelo
	 * @param dataSupervisionado
	 * @param siapeServSupervisiona
	 * @param siapeServResponsavel
	 */
	public Veiculo(int codigo, String placa, String renavam, String autorizado, String categoria,
			String institucional, int maxPassageiros, String observacao, String cor, String marcaModelo,
			String dataSupervisionado, String siapeServSupervisiona, String siapeServResponsavel, String situ) {
		this.codigo = new SimpleIntegerProperty(codigo);
		this.placa = new SimpleStringProperty(placa);
		this.renavam = new SimpleStringProperty(renavam);
		this.autorizado = new SimpleStringProperty(autorizado);
		this.categoria = new SimpleStringProperty(categoria);
		this.institucional = new SimpleStringProperty(institucional);
		this.maxPassageiros = new SimpleIntegerProperty(maxPassageiros);
		this.observacao = new SimpleStringProperty(observacao);
		this.cor = new SimpleStringProperty(cor);
		this.marcaModelo = new SimpleStringProperty(marcaModelo);
		this.dataSupervisionado = new SimpleStringProperty(dataSupervisionado);
		this.siapeServSupervisiona = new SimpleStringProperty(siapeServSupervisiona);
		this.siapeServResponsavel = new SimpleStringProperty(siapeServResponsavel);
		this.situacao = new SimpleStringProperty(situ);
	}

	/* Getters & Setters */
	public void setCodigo(int codigo) {
		this.codigo.set(codigo);
	}

	public int getCodigo() {
		return codigo.get();
	}

	public String getSituacao() {
		return situacao.get();
	}

	public void setSituacao(String situ) {
		this.situacao.set(situ);
	}

	public StringProperty getSituacaoProperty() {
		return situacao;
	}

	public IntegerProperty getCodigoProperty() {
		return codigo;
	}

	public void setPlaca(String placa) {
		this.placa.set(placa);
	}

	public String getPlaca() {
		return placa.get();
	}

	public StringProperty getPlacaProperty() {
		return placa;
	}

	public void setRenavam(String renavam) {
		this.renavam.set(renavam);
	}

	public String getRenavam() {
		return renavam.get();
	}

	public StringProperty getRenavamProperty() {
		return renavam;
	}

	public void setAutorizado(String autorizado) {
		this.autorizado.set(autorizado);
	}

	public String getAutorizado() {
		return autorizado.get();
	}

	public StringProperty getAutorizadoProperty() {
		return autorizado;
	}

	public void setCategoria(String categoria) {
		this.categoria.set(categoria);
	}

	public String getCategoria() {
		return categoria.get();
	}

	public StringProperty getCategoriaProperty() {
		return categoria;
	}

	public void setInstitucional(String institucional) {
		this.institucional.set(institucional);
	}

	public String getInstitucional() {
		return institucional.get();
	}

	public StringProperty getInstitucionalProperty() {
		return institucional;
	}

	public void setMaxPassageiros(int maxPassageiros) {
		this.maxPassageiros.set(maxPassageiros);
	}

	public int getMaxPassageiros() {
		return maxPassageiros.get();
	}

	public IntegerProperty getMaxPassageirosProperty() {
		return maxPassageiros;
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

	public void setCor(String cor) {
		this.cor.set(cor);
	}

	public String getCor() {
		return cor.get();
	}

	public StringProperty getCorProperty() {
		return cor;
	}

	public void setMarcaModelo(String marcaModelo) {
		this.marcaModelo.set(marcaModelo);
	}

	public String getMarcaModelo() {
		return marcaModelo.get();
	}

	public StringProperty getMarcaModeloProperty() {
		return marcaModelo;
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

	public void setSiapeServSupervisiona(String siapeServSupervisiona) {
		this.siapeServSupervisiona.set(siapeServSupervisiona);
	}

	public String getSiapeServSupervisiona() {
		return siapeServSupervisiona.get();
	}

	public StringProperty getSiapeServSupervisionaProperty() {
		return siapeServSupervisiona;
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

}
