package scesvi.controller;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import scesvi.model.Registro;
import scesvi.model.Solicitacao;
import scesvi.model.dao.DAORegistro;
import scesvi.model.dao.DAOServidor;
import scesvi.model.dao.DAOSolicitacao;
import scesvi.model.dao.DAOVeiculo;

public class CadastroRegistrosController {
	
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
	public void initialize() {
		num.setText(num.getText() + " " + DAORegistro.numReg());
		group();
	}
	
	public void group() {
		
		codVeic.setItems(DAOVeiculo.codAll());
		servResp.setItems(DAOServidor.siapeList());
		servidorIni.setItems(DAOServidor.siapeList());
		servidorEncerra.setItems(DAOServidor.siapeList());
		
	}
	
	@FXML
    void cadastrarRegistro(ActionEvent event) {
		
		registro = new Registro(Integer.parseInt(DAORegistro.numReg()), obs.getText(),
				codVeic.getSelectionModel().getSelectedItem(), servidorIni.getSelectionModel().getSelectedItem(), 
				servidorEncerra.getSelectionModel().getSelectedItem(), servResp.getSelectionModel().getSelectedItem(), dataInicio.getText(),
				dataSaida.getText(), horaSaida.getText(), dataEntrada.getText(), horaEntrada.getText(), dataFim.getText(), 
				desc.getText(), Integer.parseInt(kmInic.getText()), Integer.parseInt(kmFinal.getText()), dataSupervis.getText());

		DAORegistro.insert(registro);
		
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
    }

}
