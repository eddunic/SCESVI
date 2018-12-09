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
import scesvi.model.Contratado;
import scesvi.model.Lotado;
import scesvi.model.Servidor;
import scesvi.model.Telefone;
import scesvi.model.dao.DAOCargo;
import scesvi.model.dao.DAOCargoSP;
import scesvi.model.dao.DAOContratado;
import scesvi.model.dao.DAODepartamento;
import scesvi.model.dao.DAOLotado;
import scesvi.model.dao.DAOServidor;
import scesvi.model.dao.DAOSolicitacaoSP;
import scesvi.model.dao.DAOTelefone;
import scesvi.model.dao.DAOTelefoneSP;

public class ServidorController {

	@FXML
	private TableView<Servidor> servTable;

	@FXML
	private TableColumn<Servidor, String> siapeCln;

	@FXML
	private TableColumn<Servidor, String> nomeCln;

	@FXML
	private TableColumn<Servidor, String> cnhCln;

	@FXML
	private TableColumn<Servidor, String> catCln;

	@FXML
	private TableColumn<Servidor, String> instCln;

	@FXML
	private Label lbSiape;

	@FXML
	private Label lbNome;

	@FXML
	private Label lbCpf;

	@FXML
	private Label lbSenha;

	@FXML
	private Label lbNasc;

	@FXML
	private Label lbCnh;

	@FXML
	private Label lbCat;

	@FXML
	private Label lbInst;

	private Servidor servidor;

	@FXML
	private Label lbCarg;

	@FXML
	private Label lbDep;
	

	private AnchorPane fxmlAlterar;

	@FXML
	private Label lbTel;

	@FXML
	private AnchorPane lateral;

	@FXML
	private SplitPane split;

	private String codDep;
	
	private String codCargo;
	
	@FXML
	void initialize() throws IOException {
		servTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		// campos table
		siapeCln.setCellValueFactory(new PropertyValueFactory<>("siape"));
		nomeCln.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cnhCln.setCellValueFactory(new PropertyValueFactory<>("cnh"));
		catCln.setCellValueFactory(new PropertyValueFactory<>("categoria"));
		instCln.setCellValueFactory(new PropertyValueFactory<>("autorizadoVeicInstitucional"));

		nomeCln.setCellFactory(TextFieldTableCell.forTableColumn());
		cnhCln.setCellFactory(TextFieldTableCell.forTableColumn());
		catCln.setCellFactory(TextFieldTableCell.forTableColumn());
		instCln.setCellFactory(TextFieldTableCell.forTableColumn());

		servTable.setItems(DAOServidor.list());

		servTable.getSelectionModel().selectFirst();

		nomeCln.setCellValueFactory(cellData -> cellData.getValue().getNomeProperty());
		cnhCln.setCellValueFactory(cellData -> cellData.getValue().getCnhProperty());
		catCln.setCellValueFactory(cellData -> cellData.getValue().getCategoriaProperty());
		instCln.setCellValueFactory(cellData -> cellData.getValue().getAutorizadoVeicInstitucionalProperty());
		

		fxmlAlterar = FXMLLoader.load(getClass().getResource("../view/AlteracaoServidor.fxml"));
	}

	@FXML
	void atualizaSelect(MouseEvent event) {
		refreshTable();
	}

	@FXML
	void excluiServ(ActionEvent event) {
		DAOServidor.delete(servTable.getSelectionModel().getSelectedItem().getSiape());
		servTable.setItems(DAOServidor.list());
		servTable.getSelectionModel().selectFirst();
		refreshTable();
	}

	@FXML
	void editarTable(ActionEvent event) {
		servTable.setItems(DAOServidor.list());
	    servTable.getSelectionModel().selectFirst();
		refreshTable();
//		servidor = new Servidor(servTable.getSelectionModel().getSelectedItem().getSiape(), 
//				DAOServidor.consultParam("cpf", servTable.getSelectionModel().getSelectedItem().getSiape()),
//				servTable.getSelectionModel().getSelectedItem().getNome(), 
//				pfSenha.getText(),
//				dataNasc.getValue(), cnh.getText(), cbCategoria.getSelectionModel().getSelectedItem(),
//				(selectedRadioButton.getText().equals("Sim")) ? "S" : "N");
//		DAOServidor.update(servidor);
//
//		tel = new Telefone(siape.getText(), telefone.getText());
//		DAOTelefone.update(tel);
//
//		codDep = DAODepartamento.searchDepart(cbDepart.getSelectionModel().getSelectedItem());
//		lotado = new Lotado(siape.getText(), codDep, dateFormat(), "");
//		DAOLotado.update(lotado);
//
//		codCargo = DAOCargo.searchCargo(cbCargo.getSelectionModel().getSelectedItem());
//		contratado = new Contratado(siape.getText(), codCargo, dateFormat(), "");
//		DAOContratado.update(contratado);
	}

	@FXML
	void novoServ(ActionEvent event) {
		split.getItems().remove(1);
		split.getItems().add(1, MainApp.fxmlUserRegister);
	}

	void refreshTable() {
		lbSiape.setText(servTable.getSelectionModel().getSelectedItem().getSiape());
		lbCpf.setText(DAOServidor.consultParam("cpf", servTable.getSelectionModel().getSelectedItem().getSiape()));
		lbNome.setText(servTable.getSelectionModel().getSelectedItem().getNome());
		lbNasc.setText(
				DAOServidor.consultParam("dataNasc", servTable.getSelectionModel().getSelectedItem().getSiape()));
		lbCnh.setText(servTable.getSelectionModel().getSelectedItem().getCnh());
		lbCat.setText(servTable.getSelectionModel().getSelectedItem().getCategoria());
		lbInst.setText(
				(servTable.getSelectionModel().getSelectedItem().getAutorizadoVeicInstitucional().equals("S") ? "Sim"
						: "Não"));
		lbTel.setText(DAOTelefoneSP.consultTel(servTable.getSelectionModel().getSelectedItem().getSiape()));
		codDep = DAOLotado.consultLotado(servTable.getSelectionModel().getSelectedItem().getSiape());
		lbDep.setText(DAODepartamento.consultDep(codDep));
		codCargo = DAOContratado.consultContratado(servTable.getSelectionModel().getSelectedItem().getSiape());
		lbCarg.setText(DAOCargo.consultCargo(codCargo));
	}

	@FXML
	private void back(ActionEvent event) {
		split.getItems().remove(1);
		split.getItems().add(1, lateral);
	}
	
	@FXML
	void alterar(ActionEvent event) {
		split.getItems().remove(1);
		split.getItems().add(1, fxmlAlterar);
	}

}
