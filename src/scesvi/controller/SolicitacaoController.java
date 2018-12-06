package scesvi.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import scesvi.model.SingletonStage;
import scesvi.model.SolicitVeiculo;
import scesvi.model.Solicitacao;
import scesvi.model.dao.DAOSolicitVeiculo;
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
	private TableColumn<Solicitacao, String> criaCln;

	@FXML
	private TableColumn<Solicitacao, String> autorCln;

	@FXML
	private Label lbNum;

	@FXML
	private Label lbVeic;

	@FXML
	private Label lbTipo;

	@FXML
	private Label lbSitu;

	@FXML
	private Label lbDataCria;

	@FXML
	private Label lbHoraCria;

	@FXML
	private Label lbInicio;

	@FXML
	private Label lbFim;

	@FXML
	private Label lbDest;

	@FXML
	private Label lbFinalid;

	@FXML
	private Label lbAutoriz;

	@FXML
	private Label lbPassag;

	@FXML
	private Label lbAutor;

	@FXML
	private Label lbOutor;

	private Solicitacao solicitacao;

	private AnchorPane fxmlAdd;

	@FXML
	private SplitPane split;

	@FXML
	private AnchorPane lateral;

	// private int i = 0;

	// private AnchorPane novaSolic;

	@FXML
	void initialize() throws IOException {
		solicitTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		numCln.setCellValueFactory(new PropertyValueFactory<>("numero"));
		tipoCln.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		criaCln.setCellValueFactory(new PropertyValueFactory<>("dataCriacao"));
		autorCln.setCellValueFactory(new PropertyValueFactory<>("dataAutorizado"));

		tipoCln.setCellFactory(TextFieldTableCell.forTableColumn());
		criaCln.setCellFactory(TextFieldTableCell.forTableColumn());
		autorCln.setCellFactory(TextFieldTableCell.forTableColumn());

		solicitTable.setItems(DAOSolicitacao.list());

		solicitTable.getSelectionModel().selectFirst();

		// Demorei 6 horas pra achar essa solução que altera o valor da célula. #Eddunic
		tipoCln.setCellValueFactory(cellData -> cellData.getValue().getTipoProperty());
		criaCln.setCellValueFactory(cellData -> cellData.getValue().getDataCriacaoProperty());
		autorCln.setCellValueFactory(cellData -> cellData.getValue().getDataAutorizadoProperty());

		fxmlAdd = FXMLLoader.load(getClass().getResource("../view/CadastroSolicitacoes.fxml"));
	}

	@FXML
	void atualizaSelect(MouseEvent event) {
		refreshTable();
	}

	@FXML
	void excluiSolicit(ActionEvent event) {
		DAOSolicitacaoSP.delete(solicitTable.getSelectionModel().getSelectedItem().getNumero());
		solicitTable.setItems(DAOSolicitacaoSP.list());
		solicitTable.getSelectionModel().selectFirst();
		refreshTable();
	}

	@FXML
	void editarTable(ActionEvent event) {
//		solicitacao = new Solicitacao(solicitTable.getSelectionModel().getSelectedItem().getNumero(),
//				solicitTable.getSelectionModel().getSelectedItem().getVeiculoRequisitado(), "133932", "122212",
//				"121414", "1213", solicitTable.getSelectionModel().getSelectedItem().getDataCriacao(), "lo3a", "1224",
//				solicitTable.getSelectionModel().getSelectedItem().getDataAutorizado(), 4,
//				solicitTable.getSelectionModel().getSelectedItem().getTipo(), "nad", "23", "32");
		solicitTable.setItems(DAOSolicitacao.list());
		solicitTable.getSelectionModel().selectFirst();
		refreshTable();
	}

	@FXML
	void novaSolicit(ActionEvent event) throws Exception {
		split.getItems().remove(1);
		split.getItems().add(1, fxmlAdd);
	}

	void refreshTable() {
		lbNum.setText(String.valueOf(solicitTable.getSelectionModel().getSelectedItem().getNumero()));
		lbTipo.setText(solicitTable.getSelectionModel().getSelectedItem().getTipo());
		lbSitu.setText(DAOSolicitVeiculo.listSituacao(String.valueOf(solicitTable.getSelectionModel().getSelectedItem().getNumero())));
		lbDataCria.setText(solicitTable.getSelectionModel().getSelectedItem().getDataCriacao());
		lbHoraCria.setText(DAOSolicitacao.consultParam("horaCriacao",
				solicitTable.getSelectionModel().getSelectedItem().getNumero()));
		lbInicio.setText(DAOSolicitacao.consultParam("dataInicio",
				solicitTable.getSelectionModel().getSelectedItem().getNumero()));
		lbFim.setText(
				DAOSolicitacao.consultParam("dataFim", solicitTable.getSelectionModel().getSelectedItem().getNumero()));
		lbDest.setText(DAOSolicitacao.consultParam("localViagem",
				solicitTable.getSelectionModel().getSelectedItem().getNumero()));
		lbFinalid.setText(DAOSolicitacao.consultParam("finalidade",
				solicitTable.getSelectionModel().getSelectedItem().getNumero()));
		lbAutoriz.setText(solicitTable.getSelectionModel().getSelectedItem().getDataAutorizado());
		lbPassag.setText(DAOSolicitacao.consultParam("qtdePassageiros",
				solicitTable.getSelectionModel().getSelectedItem().getNumero()));
		lbAutor.setText(DAOSolicitacao.consultParam("siapeServRealiza",
				solicitTable.getSelectionModel().getSelectedItem().getNumero()));
		lbOutor.setText(DAOSolicitacao.consultParam("siapeServAutoriza",
				solicitTable.getSelectionModel().getSelectedItem().getNumero()));
	}

	@FXML
	private void back(ActionEvent event) throws IOException {
		split.getItems().remove(1);
		split.getItems().add(1, lateral);
		fxmlAdd = FXMLLoader.load(getClass().getResource("../view/CadastroSolicitacoes.fxml"));		
	}
}
