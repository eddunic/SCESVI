package scesvi.controller;

import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import scesvi.model.Servidor;
import scesvi.model.Solicitacao;
import scesvi.model.dao.DAOServidor;
import scesvi.model.dao.DAOSolicitacao;
import scesvi.model.dao.DAOVeiculo;
import scesvi.model.dao.DAOSolicitacao;

public class AlteracaoSolicitacoesController {
	
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
	private ComboBox<String> codigos;

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
    private JFXButton bCarregaDados;
	
	@FXML
	public void initialize() {
		group();
	}

	public void group() {

		qtde = FXCollections.observableArrayList();

		cbSiapeSolicit.setItems(DAOServidor.siapeList());
		cbFin.setItems(FXCollections.observableArrayList("Visita técnica", "Visita social",
				"Entrega de documento e/ou material", "Transporte de servidor ou aluno"));

		modelVeic.setItems(DAOVeiculo.listMarcaModelox());

		for (int i = 1; i <= 40; i++) {
			qtde.add("" + i);
		}

		cbQTDEpass.setItems(qtde);

		cbTipoSolic.setItems(FXCollections.observableArrayList("Ativ. administrativas", "Ativ. de pesquisa ou extensão",
				"Ativ. cultural ou esportiva"));
		
		
		codigos.setItems(DAOSolicitacao.codAll());
		codigos.getSelectionModel().select(0);
		
		dataInicio.setText(DAOSolicitacao.consultParam("dataInicio", Integer.parseInt(codigos.getSelectionModel().getSelectedItem()))); 
		dataFim.setText(DAOSolicitacao.consultParam("dataFim", Integer.parseInt(codigos.getSelectionModel().getSelectedItem()))); 
		dataSolicitAuto.setText(DAOSolicitacao.consultParam("dataAutorizado", Integer.parseInt(codigos.getSelectionModel().getSelectedItem()))); 
		dataC.setText(DAOSolicitacao.consultParam("dataCriacao", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		horaAuto.setText(DAOSolicitacao.consultParam("horaAutorizado", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
			
		tDestino.setText(DAOSolicitacao.consultParam("localViagem", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		cbSiapeSolicit.getSelectionModel().select(DAOSolicitacao.consultParam("siapeServRealiza", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		cbFin.getSelectionModel().select(DAOSolicitacao.consultParam("finalidade", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		cbTipoSolic.getSelectionModel().select(DAOSolicitacao.consultParam("tipo", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		cbQTDEpass.getSelectionModel().select(DAOSolicitacao.consultParam("qtdePassageiros", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
	}

	@FXML
	void alterar(ActionEvent event) {
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
					dataFim.getText(), dataSolicitAuto.getText(), horaAuto.getText(), dataC.getText(), "10h",
					tDestino.getText(), Integer.parseInt(cbQTDEpass.getSelectionModel().getSelectedItem()), tipo,
					cbFin.getSelectionModel().getSelectedItem(), "44444444"/* pegar siape do login */,
					cbSiapeSolicit.getSelectionModel().getSelectedItem());

			DAOSolicitacao.update(solicitacao);
			
		}
	}
	
	@FXML
    void carregarDados(ActionEvent event) {
		dataInicio.setText(DAOSolicitacao.consultParam("dataInicio", Integer.parseInt(codigos.getSelectionModel().getSelectedItem()))); 
		dataFim.setText(DAOSolicitacao.consultParam("dataFim", Integer.parseInt(codigos.getSelectionModel().getSelectedItem()))); 
		dataSolicitAuto.setText(DAOSolicitacao.consultParam("dataAutorizado", Integer.parseInt(codigos.getSelectionModel().getSelectedItem()))); 
		dataC.setText(DAOSolicitacao.consultParam("dataCriacao", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		horaAuto.setText(DAOSolicitacao.consultParam("horaAutorizado", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
			
		tDestino.setText(DAOSolicitacao.consultParam("localViagem", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		cbSiapeSolicit.getSelectionModel().select(DAOSolicitacao.consultParam("siapeServRealiza", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		cbFin.getSelectionModel().select(DAOSolicitacao.consultParam("finalidade", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		cbTipoSolic.getSelectionModel().select(DAOSolicitacao.consultParam("tipo", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		cbQTDEpass.getSelectionModel().select(DAOSolicitacao.consultParam("qtdePassageiros", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
    }

}
