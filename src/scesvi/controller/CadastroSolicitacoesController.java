package scesvi.controller;

import java.util.ArrayList;
import java.util.List;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

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
import scesvi.model.dao.DAOServidor;
import scesvi.model.dao.DAOSolicitacao;

public class CadastroSolicitacoesController {

	@FXML
	private JFXDatePicker dataInicio;

	@FXML
	private JFXDatePicker dataFim;

	@FXML
	private JFXDatePicker dataVeicConf;

	@FXML
	private JFXTextField horaAuto;

	@FXML
	private JFXDatePicker dataSolicitAuto;

	@FXML
	private Label dataCriacao;

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
	public void initialize() {
		group();
	}

	public void group() {
		cbSiapeSolicit.setItems(DAOServidor.siapeList());
		cbTipoSolic.setItems(FXCollections.observableArrayList("Visita técnica", "Visita social",
				"Entrega de documento e/ou material", "Transporte de servidor ou aluno"));
		modelVeic.setItems(FXCollections.observableArrayList("Ônibus", "Carro comum", "Microônibus"));

//    	siapesServs = FXCollections.observableArrayList();
//    	servidores = new DAOServidor.siapeList(); //Aqui você tem uma lista de todos seu produtos
//    	servidores.forEach(p ->{ siapesServs.add(p.getNome());}); // Aqui estamos os nomes do seus Produtos.
//    	//Agora é so adicionar esta lista ao ComboBox
//    	cbSiapeSolicit.getItems().addAll(siapesServs);
	}

	@FXML
	void cadastrarSolic(ActionEvent event) {
		// Para armazenar o tipo no banco
		String tipo = "a";
		String modelV = "veículo";
		if (cbTipoSolic.getSelectionModel().getSelectedItem().equals("Visita técnica")) {
			tipo = "T";
		} else if (cbTipoSolic.getSelectionModel().getSelectedItem().equals("Visita social")) {
			tipo = "S";
		} else if (cbTipoSolic.getSelectionModel().getSelectedItem().equals("Entrega de documento e/ou material")) {
			tipo = "E";
		} else {
			tipo = "D";
		}
		
		if(modelVeic.getSelectionModel().getSelectedItem().equals("Ônibus")) {
			
		}

		solicitacao = new Solicitacao(1, dataVeicConf.getValue(), dataInicio.getValue(), dataFim.getValue(), dataSolicitAuto.getValue(), 
				 horaAuto.getText(), dataCriacao.getText(), "10h", modelVeic.getSelectionModel().getSelectedItem(), tDestino.getText(), Integer.parseInt(cbQTDEpass.getSelectionModel().getSelectedItem()), tipo,
				cbFin.getSelectionModel().getSelectedItem(), "12345678"/* pegar siape do login */,
				cbSiapeSolicit.getSelectionModel().getSelectedItem());

		DAOSolicitacao.insert(solicitacao);

	}
}
