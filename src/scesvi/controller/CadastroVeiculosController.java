package scesvi.controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

public class CadastroVeiculosController {

	@FXML
	private JFXTextArea obs;

	@FXML
	private ComboBox<String> maxPassag;

	@FXML
	private HBox AutoEstacion;

	@FXML
	private HBox instit;

	@FXML
	private ComboBox<String> cor;

	@FXML
	private JFXTextField marcaModelo;

	@FXML
	private ComboBox<?> categoria;

	@FXML
	private JFXTextField placa;

	@FXML
	private JFXTextField renavam;

	@FXML
	private ComboBox<?> siapeResp;

	@FXML
	private ComboBox<?> siapeSupervisor;

	@FXML
	void cadastrarVeic(ActionEvent event) {

	}

}
