package scesvi.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleGroup;
import scesvi.model.Servidor;
import scesvi.model.Telefone;
import scesvi.model.dao.DAOServidor;
import scesvi.model.dao.DAOTelefone;

public class UserRegisterScreenController {

	@FXML
	private JFXTextField cnh;

	@FXML
	private ComboBox<String> cbCategoria;

	@FXML
	private JFXRadioButton rbSim;

	@FXML
	private JFXRadioButton rbNao;

	@FXML
	private JFXTextField siape;

	@FXML
	private JFXTextField cpf;

	@FXML
	private JFXDatePicker dataNasc;

	@FXML
	private JFXTextField nome;

	@FXML
	private JFXTextField telefone;

	@FXML
	private JFXTextField nomeUsuario;

	@FXML
	private JFXPasswordField pfSenha;

	@FXML
	private JFXTextField repitaSenha;

	@FXML
	private JFXTextField email;

	@FXML
	private JFXButton bCadastrar;

	private Servidor servidor;
	
	private Telefone tel;

	private ToggleGroup radioGroup;

	@FXML
	public void btRegisterAction(ActionEvent event) {
		JFXRadioButton selectedRadioButton = (JFXRadioButton) radioGroup.getSelectedToggle();

		servidor = new Servidor(siape.getText(), cpf.getText(), nome.getText(), pfSenha.getText(),
				dataNasc.getValue(), cnh.getText(), cbCategoria.getSelectionModel().getSelectedItem(),
				(selectedRadioButton.getText().equals("Sim"))?"S":"N");
		DAOServidor.insert(servidor);
		
		tel = new Telefone(siape.getText(), telefone.getText());
		DAOTelefone.insert(tel);
	}

	public void group() {
		radioGroup = new ToggleGroup();

		rbSim.setToggleGroup(radioGroup);
		rbNao.setToggleGroup(radioGroup);

		cbCategoria.setItems(FXCollections.observableArrayList("A", "B", "C", "D", "E"));
	}

	@FXML
	public void initialize() {
		group();
	}
}
