package scesvi.controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import scesvi.model.Registro;
import scesvi.model.dao.DAORegistro;
import scesvi.model.dao.DAOServidor;
import scesvi.model.dao.DAOSolicitVeiculo;
import scesvi.model.dao.DAOVeiculo;
import scesvi.model.dao.DAORegistro;

public class AlteracaoRegistrosController {
	
	@FXML
    private JFXTextField dataInicio;

    @FXML
    private JFXTextField dataFim;

    @FXML
    private JFXTextField dataSaida;

    @FXML
    private JFXTextField dataEntrada;

    @FXML
    private JFXTextField dataSupervis;

    @FXML
    private JFXTextField horaEntrada;

    @FXML
    private JFXTextField horaSaida;

    @FXML
    private ComboBox<String> codVeic;

    @FXML
    private ComboBox<String> servResp;

    @FXML
    private ComboBox<String> servidorIni;

    @FXML
    private ComboBox<String> servidorEncerra;

    @FXML
    private JFXTextField kmInic;

    @FXML
    private JFXTextField kmFinal;

    @FXML
    private JFXTextArea desc;

    @FXML
    private JFXTextArea obs;

    @FXML
    private Label num;
    
    private Registro registro;
    
	@FXML
	private ComboBox<String> codigos;
    
    @FXML
	public void initialize() {
		group();
	}

	public void group() {
		
		codVeic.setItems(DAOVeiculo.listCod());
		servResp.setItems(DAOServidor.siapeList());
		servidorIni.setItems(DAOServidor.siapeList());
		servidorEncerra.setItems(DAOServidor.siapeList());
		
		codigos.setItems(DAORegistro.codAll());
		codigos.getSelectionModel().select(0);
		
		// solicitVeiculo codVeic.getSelectionModel().select(DAOSolicitVeiculo.consultParam("codVeic", Integer.parseInt(codigos.getSelectionModel().getSelectedItem()))); 
		servResp.getSelectionModel().select(DAORegistro.consultParam("siapeServResponsavel", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		servidorIni.getSelectionModel().select(DAORegistro.consultParam("siapeServInicia", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		servidorEncerra.getSelectionModel().select(DAORegistro.consultParam("siapeServEncerra", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		kmFinal.setText(DAORegistro.consultParam("kmFinal", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		kmInic.setText(DAORegistro.consultParam("kmInicial", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		desc.setText(DAORegistro.consultParam("descricao", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		obs.setText(DAORegistro.consultParam("observacao", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		dataEntrada.setText(DAORegistro.consultParam("dataEntrada", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		dataSaida.setText(DAORegistro.consultParam("dataSaida", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		dataInicio.setText(DAORegistro.consultParam("dataInicia", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		dataFim.setText(DAORegistro.consultParam("dataEncerra", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		dataSupervis.setText(DAORegistro.consultParam("dataSupervisionado", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		horaEntrada.setText(DAORegistro.consultParam("horaEntrada", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
		horaSaida.setText(DAORegistro.consultParam("horaSaida", Integer.parseInt(codigos.getSelectionModel().getSelectedItem())));
	}
    @FXML
    void alterar(ActionEvent event) {
    	registro = new Registro(Integer.parseInt(DAORegistro.numReg()), obs.getText(),
				codVeic.getSelectionModel().getSelectedItem(), servidorIni.getSelectionModel().getSelectedItem(), 
				servidorEncerra.getSelectionModel().getSelectedItem(), servResp.getSelectionModel().getSelectedItem(), dataInicio.getText(),
				dataSaida.getText(), horaSaida.getText(), dataEntrada.getText(), horaEntrada.getText(), dataFim.getText(), 
				desc.getText(), Integer.parseInt(kmInic.getText()), Integer.parseInt(kmFinal.getText()), dataSupervis.getText());

		DAORegistro.update(registro);
    }
    
}
