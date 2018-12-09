package scesvi.controller;

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
import scesvi.model.Veiculo;
import scesvi.model.dao.DAOServidor;
import scesvi.model.dao.DAOVeiculo;

public class AlteracaoVeiculoController {

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

	@FXML
	private ComboBox<String> codigos;
	
	private ToggleGroup autoEst, instituc;

	private ObservableList<String> qtde;

	Veiculo veiculo;
	
	int cod;

	private JFXRadioButton selectedRadioButton, selectedRadioButton2;
	
    @FXML
    private Label codV;
	
	@FXML
	private void initialize() {
		group();
	}

	public void group() {

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
		
		codigos.setItems(DAOVeiculo.codAll());
		codigos.getSelectionModel().select(0);
		
		placa.setText(DAOVeiculo.consultParam("placa", Integer.parseInt(codigos.getSelectionModel().getSelectedItem()))); 
		renavam.setText(DAOVeiculo.consultParam("renavam", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		categoria.getSelectionModel().select(DAOVeiculo.consultParam("categoria", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		cor.getSelectionModel().select(DAOVeiculo.consultParam("cor", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		siapeResp.getSelectionModel().select(DAOVeiculo.consultParam("siapeServResponsavel", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		siapeSupervisor.getSelectionModel().select(DAOVeiculo.consultParam("siapeServSupervisiona", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		maxPassag.getSelectionModel().select(DAOVeiculo.consultParam("maxPassageiros", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		obs.setText(DAOVeiculo.consultParam("observacao", Integer.parseInt(DAOVeiculo.codVeic())));
		dataSuperv.setText(DAOVeiculo.consultParam("dataSupervisionado", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		marcaModelo.setText(DAOVeiculo.consultParam("marcaModelo", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
	}

	@FXML
	void alterar(ActionEvent event) {
		selectedRadioButton = (JFXRadioButton) instituc.getSelectedToggle();
		selectedRadioButton2 = (JFXRadioButton) autoEst.getSelectedToggle();

		veiculo = new Veiculo(Integer.parseInt(codigos.getSelectionModel().getSelectedItem()), placa.getText(), renavam.getText(),
				(selectedRadioButton2.getText().equals("Sim")) ? "S" : "N",
				categoria.getSelectionModel().getSelectedItem(),
				(selectedRadioButton.getText().equals("Sim")) ? "S" : "N",
				Integer.parseInt(maxPassag.getSelectionModel().getSelectedItem()), obs.getText(),
				cor.getSelectionModel().getSelectedItem(), marcaModelo.getText(), dataSuperv.getText(),
				siapeResp.getSelectionModel().getSelectedItem(), siapeSupervisor.getSelectionModel().getSelectedItem(),
				"L");

		DAOVeiculo.update(veiculo);
	}
}

