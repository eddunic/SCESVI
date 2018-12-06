package scesvi.model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Veiculo {

	private final StringProperty codigo;
	private final StringProperty tipo;
	private final StringProperty placa;
	private final StringProperty renavam;
	private final StringProperty autorizado;
	private final StringProperty categoria;
	private final StringProperty institucional;
	private final StringProperty chassi;
	private final IntegerProperty maxPassageiros;
	private final StringProperty observacao;
	private final StringProperty exercicio;
	private final StringProperty tipoCombustivel;
	private final FloatProperty potencia;
	private final StringProperty cor;
	private final StringProperty marcaModelo;
	private final StringProperty anoFabricacao;
	private final StringProperty anoModelo;
	private final StringProperty dataSupervisionado;
	private final StringProperty situacao;
	private final StringProperty siapeServSupervisiona;
	private final StringProperty siapeServResponsavel;

	/**
	 * Construtor vazio.
	 */
	public Veiculo() {
		this.codigo = new SimpleStringProperty("");
		this.tipo = new SimpleStringProperty("");
		this.placa = new SimpleStringProperty("");
		this.renavam = new SimpleStringProperty("");
		this.autorizado = new SimpleStringProperty("");
		this.categoria = new SimpleStringProperty("");
		this.institucional = new SimpleStringProperty("");
		this.chassi = new SimpleStringProperty("");
		this.maxPassageiros = new SimpleIntegerProperty(0);
		this.observacao = new SimpleStringProperty("");
		this.exercicio = new SimpleStringProperty("");
		this.tipoCombustivel = new SimpleStringProperty("");
		this.potencia = new SimpleFloatProperty(0.0f);
		this.cor = new SimpleStringProperty("");
		this.marcaModelo = new SimpleStringProperty("");
		this.anoFabricacao = new SimpleStringProperty("");
		this.anoModelo = new SimpleStringProperty("");
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
	public Veiculo(String codigo, String tipo, String placa, String renavam, String autorizado, String categoria,
			String institucional, String chassi, int maxPassageiros, String observacao, String exercicio,
			String tipoCombustivel, float potencia, String cor, String marcaModelo, String anoFabricacao,
			String anoModelo, String dataSupervisionado, String siapeServSupervisiona, String siapeServResponsavel, String situ) {
		this.codigo = new SimpleStringProperty(codigo);
		this.tipo = new SimpleStringProperty(tipo);
		this.placa = new SimpleStringProperty(placa);
		this.renavam = new SimpleStringProperty(renavam);
		this.autorizado = new SimpleStringProperty(autorizado);
		this.categoria = new SimpleStringProperty(categoria);
		this.institucional = new SimpleStringProperty(institucional);
		this.chassi = new SimpleStringProperty(chassi);
		this.maxPassageiros = new SimpleIntegerProperty(maxPassageiros);
		this.observacao = new SimpleStringProperty(observacao);
		this.exercicio = new SimpleStringProperty(exercicio);
		this.tipoCombustivel = new SimpleStringProperty(tipoCombustivel);
		this.potencia = new SimpleFloatProperty(potencia);
		this.cor = new SimpleStringProperty(cor);
		this.marcaModelo = new SimpleStringProperty(marcaModelo);
		this.anoFabricacao = new SimpleStringProperty(anoFabricacao);
		this.anoModelo = new SimpleStringProperty(anoModelo);
		this.dataSupervisionado = new SimpleStringProperty(dataSupervisionado);
		this.siapeServSupervisiona = new SimpleStringProperty(siapeServSupervisiona);
		this.siapeServResponsavel = new SimpleStringProperty(siapeServResponsavel);
		this.situacao = new SimpleStringProperty(situ);
	}
	
	/* Getters & Setters */
	public void setCodigo(String codigo) {
		this.codigo.set(codigo);
	}

	public String getCodigo() {
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
	
	public StringProperty getCodigoProperty() {
		return codigo;
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

	public void setChassi(String chassi) {
		this.chassi.set(chassi);
	}

	public String getChassi() {
		return chassi.get();
	}

	public StringProperty getChassiProperty() {
		return chassi;
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

	public void setExercicio(String exercicio) {
		this.exercicio.set(exercicio);
	}

	public String getExercicio() {
		return exercicio.get();
	}

	public StringProperty getExercicioProperty() {
		return exercicio;
	}

	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel.set(tipoCombustivel);
	}

	public String getTipoCombustivel() {
		return tipoCombustivel.get();
	}

	public StringProperty getTipoCombustivelProperty() {
		return tipoCombustivel;
	}

	public void setPotencia(float potencia) {
		this.potencia.set(potencia);
	}

	public float getPotencia() {
		return potencia.get();
	}

	public FloatProperty getPotenciaProperty() {
		return potencia;
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
	
	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao.set(anoFabricacao);
	}
	
	public String getAnoFabricacao() {
		return anoFabricacao.get();
	}
	
	public StringProperty getAnoFabricacaoProperty() {
		return anoFabricacao;
	}
	
	public void setAnoModelo(String anoModelo) {
		this.anoModelo.set(anoModelo);
	}
	
	public String getAnoModelo() {
		return anoModelo.get();
	}
	
	public StringProperty getAnoModeloProperty() {
		return anoModelo;
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
