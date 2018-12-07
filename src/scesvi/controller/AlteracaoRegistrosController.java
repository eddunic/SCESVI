package scesvi.controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import scesvi.model.Registro;
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
	public void initialize() {
		//num.setText(num.getText() + " " + DAORegistro.numReg());
		group();
	}
    
    public void group() {
    	dataInicio.setText("");
    }
    
    @FXML
    void atualizarRegistro(ActionEvent event) {
		
    }
    
}
