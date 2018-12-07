package scesvi.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import scesvi.model.Registro;
import scesvi.model.dao.DAORegistro;
import scesvi.model.dao.DAOSolicitacao;
import scesvi.model.dao.DAOSolicitacaoSP;

public class RegistroController {

	@FXML
    private TableView<Registro> regTable;

    @FXML
    private TableColumn<Registro, Integer> numCln;

    @FXML
    private TableColumn<Registro, String> codVeicCln;

    @FXML
    private TableColumn<Registro, String> respCln;

    @FXML
    private TableColumn<Registro, String> horaEntCln;

    @FXML
    private TableColumn<Registro, String> horaSaidaCln;

    @FXML
    private Label lbNum;

    @FXML
    private Label lbCodVeic;

    @FXML
    private Label lbObs;

    @FXML
    private Label lbSiapeInicia;

    @FXML
    private Label lbSiapeEncerra;

    @FXML
    private Label lbSiapeResp;

    @FXML
    private Label lbDataInicia;

    @FXML
    private Label lbDataEncerra;

    @FXML
    private Label lbHoraSaida;

    @FXML
    private Label lbHoraEntrada;

    @FXML
    private Label lbDataSaida;

    @FXML
    private Label lbDataEntrada;

    @FXML
    private Label lbDesc;

    @FXML
    private Label lbKmIni;

    @FXML
    private Label lbKmFin;

    @FXML
    private Label lbSupervisao;
    
    @FXML
    private SplitPane split;
	
	private Registro registro;
	
	private AnchorPane fxmlAdd, fxmlAdd2;
	
    @FXML
    private AnchorPane lateral;

	@FXML
	void initialize() throws IOException {
		regTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		numCln.setCellValueFactory(new PropertyValueFactory<>("numero"));
		codVeicCln.setCellValueFactory(new PropertyValueFactory<>("codVeiculo"));
		respCln.setCellValueFactory(new PropertyValueFactory<>("siapeServResponsavel"));
		horaEntCln.setCellValueFactory(new PropertyValueFactory<>("horaEntrada"));
		horaSaidaCln.setCellValueFactory(new PropertyValueFactory<>("horaSaida"));

		codVeicCln.setCellFactory(TextFieldTableCell.forTableColumn());
		respCln.setCellFactory(TextFieldTableCell.forTableColumn());
		horaEntCln.setCellFactory(TextFieldTableCell.forTableColumn());
		horaSaidaCln.setCellFactory(TextFieldTableCell.forTableColumn());
	
		regTable.setItems(DAORegistro.list());

		regTable.getSelectionModel().selectFirst();
		
		codVeicCln.setCellValueFactory(cellData -> cellData.getValue().getCodVeiculoProperty());
		respCln.setCellValueFactory(cellData -> cellData.getValue().getSiapeServResponsavelProperty());
		horaEntCln.setCellValueFactory(cellData -> cellData.getValue().getHoraEntradaProperty());
		horaSaidaCln.setCellValueFactory(cellData -> cellData.getValue().getHoraSaidaProperty());
		
		fxmlAdd = FXMLLoader.load(getClass().getResource("../view/CadastroRegistros.fxml"));
		//fxmlAdd2 = FXMLLoader.load(getClass().getResource("../view/AlteracaoRegistros.fxml"));

	}

	@FXML
	void atualizaSelect(MouseEvent event) throws IOException {
		refreshTable();
//		split.getItems().remove(1);
//		split.getItems().add(1, fxmlAdd2);
	}

	@FXML
	void excluiReg(ActionEvent event) {
		DAORegistro.delete(regTable.getSelectionModel().getSelectedItem().getNumero());
		regTable.setItems(DAORegistro.list());
		regTable.getSelectionModel().selectFirst();
		refreshTable();
	}

	@FXML
	void editarTable(ActionEvent event) {
//		registro = new Registro(regTable.getSelectionModel().getSelectedItem().getNumero(), "a", 
//				regTable.getSelectionModel().getSelectedItem().getCodVeiculo(), "q", "n", 
//				regTable.getSelectionModel().getSelectedItem().getSiapeServResponsavel(), "s", "123", "4", 
//				regTable.getSelectionModel().getSelectedItem().getHoraSaida(), "nenh", 
//				regTable.getSelectionModel().getSelectedItem().getHoraEntrada(), "12", "vere", "d", 12, 13, 
//				17, "14");
//		DAORegistro.update(registro);
		
		regTable.setItems(DAORegistro.list());
		regTable.getSelectionModel().selectFirst();
		refreshTable();
	}

	@FXML
	void novoReg(ActionEvent event) {
		split.getItems().remove(1);
		split.getItems().add(1, fxmlAdd);
	}

	void refreshTable() {
		lbNum.setText(String.valueOf(regTable.getSelectionModel().getSelectedItem().getNumero()));
		lbObs.setText(DAORegistro.consultParam("observacao", regTable.getSelectionModel().getSelectedItem().getNumero()));
		lbCodVeic.setText(regTable.getSelectionModel().getSelectedItem().getCodVeiculo());
		lbSiapeInicia.setText(DAORegistro.consultParam("siapeServInicia", regTable.getSelectionModel().getSelectedItem().getNumero()));
		lbSiapeEncerra.setText(DAORegistro.consultParam("siapeServEncerra", regTable.getSelectionModel().getSelectedItem().getNumero()));
		lbSiapeResp.setText(regTable.getSelectionModel().getSelectedItem().getSiapeServResponsavel());
		lbDataInicia.setText(DAORegistro.consultParam("dataInicia", regTable.getSelectionModel().getSelectedItem().getNumero()));
		lbDataEncerra.setText(DAORegistro.consultParam("dataEncerra", regTable.getSelectionModel().getSelectedItem().getNumero()));
		lbHoraSaida.setText(regTable.getSelectionModel().getSelectedItem().getHoraSaida());
		lbHoraEntrada.setText(regTable.getSelectionModel().getSelectedItem().getHoraEntrada());
		lbDataSaida.setText(DAORegistro.consultParam("dataSaida", regTable.getSelectionModel().getSelectedItem().getNumero()));
		lbDataEntrada.setText(DAORegistro.consultParam("dataEntrada", regTable.getSelectionModel().getSelectedItem().getNumero()));
		lbDesc.setText(DAORegistro.consultParam("descricao", regTable.getSelectionModel().getSelectedItem().getNumero()));
		lbKmIni.setText(DAORegistro.consultParam("kmInicial", regTable.getSelectionModel().getSelectedItem().getNumero()));
		lbKmFin.setText(DAORegistro.consultParam("kmFinal", regTable.getSelectionModel().getSelectedItem().getNumero()));
		lbSupervisao.setText(DAORegistro.consultParam("dataSupervisionado", regTable.getSelectionModel().getSelectedItem().getNumero()));
	}
	
    @FXML
    private void back(ActionEvent event) throws IOException {
		split.getItems().remove(1);
		split.getItems().add(1, lateral);
		fxmlAdd = FXMLLoader.load(getClass().getResource("../view/CadastroRegistros.fxml"));	

    }
	
}

