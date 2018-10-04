package ch.makery.scesvi.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe Model para um Servidor
 * 
 * @author Daniela Ferreira
 */

public class Servidor {

	private final StringProperty nome, senha;

	/**
	 * Construtor com alguns dados iniciais.
	 * 
	 * @param Nome  - nome de usuário do Servidor.
	 * @param Senha - codigo de entrada.
	 */
	public Servidor(String nome, String senha) {
		this.nome = new SimpleStringProperty(nome);
		this.senha = new SimpleStringProperty(senha);
	}

	public String getNome() {
		return nome.get();
	}

	public void setNome(String nome) {
		this.nome.set(nome);
	}

	public String getSenha() {
		return senha.get();
	}

	public void setSenha(String senha) {
		this.senha.set(senha);
	}
}
