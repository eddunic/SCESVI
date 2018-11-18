package scesvi.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import scesvi.model.Servidor;
import scesvi.model.dao.DAOServidor;

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
	void initialize() {
		servTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		siapeCln.setCellValueFactory(new PropertyValueFactory<>("siape"));
		nomeCln.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cnhCln.setCellValueFactory(new PropertyValueFactory<>("cnh"));
		catCln.setCellValueFactory(new PropertyValueFactory<>("categoria"));
		instCln.setCellValueFactory(new PropertyValueFactory<>("autorizadoVeicInstitucional"));

		nomeCln.setCellFactory(TextFieldTableCell.forTableColumn());
		cnhCln.setCellFactory(TextFieldTableCell.forTableColumn());
		catCln.setCellFactory(TextFieldTableCell.forTableColumn());
		instCln.setCellFactory(TextFieldTableCell.forTableColumn());
		
		//Linha Com erro por causa do LocalDate
//		servTable.setItems(DAOServidor.list());

		servTable.getSelectionModel().selectFirst();
		
		nomeCln.setCellValueFactory(cellData -> cellData.getValue().getNomeProperty());
		cnhCln.setCellValueFactory(cellData -> cellData.getValue().getCnhProperty());
		catCln.setCellValueFactory(cellData -> cellData.getValue().getCategoriaProperty());
		instCln.setCellValueFactory(cellData -> cellData.getValue().getAutorizadoVeicInstitucionalProperty());
	}

	@FXML
	void atualizaSelect(MouseEvent event) {
		refreshTable();
	}

	@FXML
	void excluiServ(ActionEvent event) {
		DAOServidor.delete(servTable.getSelectionModel().getSelectedItem().getSiape());
		refreshTable();
	}

	@FXML
	void editarTable(ActionEvent event) {
		//Com inconsistência LocalDate - String
//		servidor = new Servidor(servTable.getSelectionModel().getSelectedItem().getSiape(), "453", 
//				servTable.getSelectionModel().getSelectedItem().getNome(), "1133", "112211", 
//				servTable.getSelectionModel().getSelectedItem().getCnh(), servTable.getSelectionModel().getSelectedItem().getCategoria(),
//				servTable.getSelectionModel().getSelectedItem().getAutorizadoVeicInstitucional());
//		DAOServidor.update(servidor);
		refreshTable();
	}

	@FXML
	void novoServ(ActionEvent event) {
		
	}

	void refreshTable() {
		lbSiape.setText(servTable.getSelectionModel().getSelectedItem().getSiape());
		lbCpf.setText(DAOServidor.consultParam("cpf", servTable.getSelectionModel().getSelectedItem().getSiape()));
		lbNome.setText(servTable.getSelectionModel().getSelectedItem().getNome());
		lbSenha.setText(DAOServidor.consultParam("senha", servTable.getSelectionModel().getSelectedItem().getSiape()));
		lbNasc.setText(DAOServidor.consultParam("dataNasc", servTable.getSelectionModel().getSelectedItem().getSiape()));
		lbCnh.setText(servTable.getSelectionModel().getSelectedItem().getCnh());
		lbCat.setText(servTable.getSelectionModel().getSelectedItem().getCategoria());
		lbInst.setText(servTable.getSelectionModel().getSelectedItem().getAutorizadoVeicInstitucional());
	}
	
}

