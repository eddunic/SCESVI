package scesvi.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import scesvi.model.Servidor;
import scesvi.model.Solicitacao;
import scesvi.model.dao.DAOCargo;
import scesvi.model.dao.DAOContratado;
import scesvi.model.dao.DAODepartamento;
import scesvi.model.dao.DAOLotado;
import scesvi.model.dao.DAOServidor;
import scesvi.model.dao.DAOSolicitVeiculo;
import scesvi.model.dao.DAOSolicitacao;
import scesvi.model.dao.DAOVeiculo;

public class CadastroSolicitacoesController {

	@FXML
	private JFXTextField dataInicio;

	@FXML
	private JFXTextField dataFim;

	@FXML
	private JFXTextField horaAuto;

	@FXML
	private JFXTextField dataSolicitAuto;

	@FXML
	private JFXTextField dataC;

	@FXML
	private ComboBox<String> cbSiapeSolicit;

	@FXML
	private ComboBox<String> cbQTDEpass;

	@FXML
	private ComboBox<String> cbTipoSolic;

	@FXML
	private ComboBox<String> cbFin;

	@FXML
	private JFXTextArea tDestino;

	@FXML
	private ComboBox<String> modelVeic;

	private ObservableList<String> siapesServs;

	private List<Servidor> servidores;

	private Solicitacao solicitacao;

	@FXML
	private Label num;

	private ObservableList<String> qtde;
	
	@FXML
    private JFXTextField horaCria;

    @FXML
    private ComboBox<String> cbSiapeOutorg;

	@FXML
	public void initialize() {
		num.setText(num.getText() + " " + DAOSolicitacao.numSolic());
		group();
	}

	public void group() {

		qtde = FXCollections.observableArrayList();

		cbSiapeSolicit.setItems(DAOServidor.siapeList());
		cbSiapeOutorg.setItems(DAOServidor.siapeList());
		cbFin.setItems(FXCollections.observableArrayList("Visita técnica", "Visita social",
				"Entrega de documento e/ou material", "Transporte de servidor ou aluno"));

		modelVeic.setItems(DAOVeiculo.listMarcaModelox());

		for (int i = 1; i <= 40; i++) {
			qtde.add("" + i);
		}

		cbQTDEpass.setItems(qtde);

		cbTipoSolic.setItems(FXCollections.observableArrayList("Ativ. administrativas", "Ativ. de pesquisa ou extensão",
				"Ativ. cultural ou esportiva"));

		// siapesServs = FXCollections.observableArrayList();
//    	servidores = new DAOServidor.siapeList(); //Aqui você tem uma lista de todos seu produtos
//    	servidores.forEach(p ->{ siapesServs.add(p.getNome());}); // Aqui estamos os nomes do seus Produtos.
//    	//Agora é so adicionar esta lista ao ComboBox
//    	cbSiapeSolicit.getItems().addAll(siapesServs);
	}

	@FXML
	void cadastrarSolic(ActionEvent event) {
		if (!modelVeic.getItems().isEmpty()) {
			// Para armazenar o tipo no banco
			String tipo = "a";
			if (cbTipoSolic.getSelectionModel().getSelectedItem().equals("Visita técnica")) {
				tipo = "T";
			} else if (cbTipoSolic.getSelectionModel().getSelectedItem().equals("Visita social")) {
				tipo = "S";
			} else if (cbTipoSolic.getSelectionModel().getSelectedItem().equals("Entrega de documento e/ou material")) {
				tipo = "E";
			} else {
				tipo = "D";
			}

			solicitacao = new Solicitacao(Integer.parseInt(DAOSolicitacao.numSolic()), dataInicio.getText(),
					dataFim.getText(), dataSolicitAuto.getText(), horaAuto.getText(), dataC.getText(), horaCria.getText(),
					tDestino.getText(), Integer.parseInt(cbQTDEpass.getSelectionModel().getSelectedItem()), tipo,
					cbFin.getSelectionModel().getSelectedItem(), cbSiapeOutorg.getSelectionModel().getSelectedItem(),
					cbSiapeSolicit.getSelectionModel().getSelectedItem());

			DAOSolicitacao.insert(solicitacao);
			modelVeic.setItems(DAOVeiculo.listMarcaModelox());
			
		}
	}

}
