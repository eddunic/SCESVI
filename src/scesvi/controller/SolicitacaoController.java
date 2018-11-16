package scesvi.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import scesvi.model.Solicitacao;
import scesvi.model.dao.DAOSolicitacao;
import scesvi.model.dao.DAOSolicitacaoSP;

public class SolicitacaoController {

	@FXML
	private TableView<Solicitacao> solicitTable;

	@FXML
	private TableColumn<Solicitacao, Integer> numCln;

	@FXML
	private TableColumn<Solicitacao, String> tipoCln;

	@FXML
	private TableColumn<Solicitacao, String> veicCln;

	@FXML
	private TableColumn<Solicitacao, String> criaCln;

	@FXML
	private TableColumn<Solicitacao, String> autorCln;

	@FXML
	private Label lbNum;

	@FXML
	private Label lbTipo;

	@FXML
	private Label lbCria;
	
	private Solicitacao solicitacao;

	@FXML
	void initialize() {
		solicitTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		numCln.setCellValueFactory(new PropertyValueFactory<>("numero"));
		tipoCln.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		veicCln.setCellValueFactory(new PropertyValueFactory<>("veiculoRequisitado"));
		criaCln.setCellValueFactory(new PropertyValueFactory<>("dataCriacao"));
		autorCln.setCellValueFactory(new PropertyValueFactory<>("dataAutorizado"));

		tipoCln.setCellFactory(TextFieldTableCell.forTableColumn());
        
		solicitTable.setItems(DAOSolicitacaoSP.list());

		solicitTable.getSelectionModel().selectFirst();
		
		//Demorei 6 horas pra achar essa solução que altera o valor da célula. #Eddunic
		tipoCln.setCellValueFactory(cellData -> cellData.getValue().getTipoProperty());
	}

	@FXML
	void atualizaSelect(MouseEvent event) {
		lbNum.setText(String.valueOf(solicitTable.getSelectionModel().getSelectedItem().getNumero()));
	}

	@FXML
	void excluiSolicit(ActionEvent event) {
		DAOSolicitacaoSP.delete(solicitTable.getSelectionModel().getSelectedItem().getNumero());
		refreshTable();
	}

	@FXML
	void editarTable(ActionEvent event) {
		solicitacao = new Solicitacao(solicitTable.getSelectionModel().getSelectedItem().getNumero(), "blanck", "132332",
				"122212", "121414", "1213", "903212", "lo3a", "1224", "321312", 4,
				solicitTable.getSelectionModel().getSelectedItem().getTipo(), "nad", "23", "32");
		DAOSolicitacao.update(solicitacao);
		refreshTable();
	}

	@FXML
	void novaSolicit(ActionEvent event) {
//		solicitacao = new Solicitacao();
//		DAOSolicitacaoSP.insert(solicitacao);
//		refreshTable();
	}

	void refreshTable() {
		solicitTable.getItems().clear();
		solicitTable.setItems(DAOSolicitacaoSP.list());
		lbNum.setText("");
	}
	
}
