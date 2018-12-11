package scesvi.controller;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import scesvi.model.Veiculo;
import scesvi.model.dao.DAOServidor;
import scesvi.model.dao.DAOSolicitacao;
import scesvi.model.dao.DAOVeiculo;

public class CadastroVeiculosController {

	@FXML
	private JFXTextArea obs;

	@FXML
	private ComboBox<String> maxPassag;

	@FXML
	private JFXRadioButton sim;

	@FXML
	private JFXRadioButton nao;

	@FXML
	private JFXRadioButton yes;

	@FXML
	private JFXRadioButton no;

	@FXML
	private ComboBox<String> cor;

	@FXML
	private JFXTextField marcaModelo;

	@FXML
	private ComboBox<String> categoria;

	@FXML
	private JFXTextField placa;

	@FXML
	private JFXTextField renavam;

	@FXML
	private JFXTextField dataSuperv;

	@FXML
	private ComboBox<String> siapeResp;

	@FXML
	private ComboBox<String> siapeSupervisor;

	private ToggleGroup autoEst, instituc;

	private ObservableList<String> qtde;

	private Veiculo veiculo;

	private JFXRadioButton selectedRadioButton, selectedRadioButton2;

    @FXML
    private Label codV;
	
	@FXML
	private void initialize() {
		codV.setText(codV.getText() + " " + DAOVeiculo.codVeic());
		group();
	}

	public void group() {
		veiculo = new Veiculo();

		autoEst = new ToggleGroup();
		instituc = new ToggleGroup();

		qtde = FXCollections.observableArrayList();

		sim.setToggleGroup(autoEst);
		nao.setToggleGroup(autoEst);

		yes.setToggleGroup(instituc);
		no.setToggleGroup(instituc);

		nao.setSelected(true);
		no.setSelected(true);

		categoria.setItems(FXCollections.observableArrayList("A", "B", "C", "D", "E"));
		siapeResp.setItems(DAOServidor.siapeList());
		siapeSupervisor.setItems(DAOServidor.siapeList());

		for (int i = 1; i <= 40; i++) {
			qtde.add("" + i);
		}

		maxPassag.setItems(qtde);

		cor.setItems(FXCollections.observableArrayList("Preto", "Azul", "Amarelo", "Padrão instituc.", "Vermelho",
				"Verde", "Cinza", "Branco"));
	}

	@FXML
	void cadastrarVeic(ActionEvent event) {
		selectedRadioButton = (JFXRadioButton) instituc.getSelectedToggle();
		selectedRadioButton2 = (JFXRadioButton) autoEst.getSelectedToggle();

		veiculo = new Veiculo(Integer.parseInt(DAOVeiculo.codVeic()), placa.getText(), renavam.getText(),
				(selectedRadioButton2.getText().equals("Sim")) ? "S" : "N",
				categoria.getSelectionModel().getSelectedItem(),
				(selectedRadioButton.getText().equals("Sim")) ? "S" : "N",
				Integer.parseInt(maxPassag.getSelectionModel().getSelectedItem()), obs.getText(),
				cor.getSelectionModel().getSelectedItem(), marcaModelo.getText(), dataSuperv.getText(),
				siapeResp.getSelectionModel().getSelectedItem(), siapeSupervisor.getSelectionModel().getSelectedItem(),
				"L");

		DAOVeiculo.insert(veiculo);
		
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
	}
}