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
    private Label lbVeic;

	@FXML
	private Label lbTipo;
	
    @FXML
    private Label lbConfirm;
    
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

	@FXML
	void initialize() {
		solicitTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		numCln.setCellValueFactory(new PropertyValueFactory<>("numero"));
		tipoCln.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		veicCln.setCellValueFactory(new PropertyValueFactory<>("veiculoRequisitado"));
		criaCln.setCellValueFactory(new PropertyValueFactory<>("dataCriacao"));
		autorCln.setCellValueFactory(new PropertyValueFactory<>("dataAutorizado"));

		tipoCln.setCellFactory(TextFieldTableCell.forTableColumn());
		veicCln.setCellFactory(TextFieldTableCell.forTableColumn());
		criaCln.setCellFactory(TextFieldTableCell.forTableColumn());
		autorCln.setCellFactory(TextFieldTableCell.forTableColumn());
		
		solicitTable.setItems(DAOSolicitacaoSP.list());

		solicitTable.getSelectionModel().selectFirst();
		
		//Demorei 6 horas pra achar essa solução que altera o valor da célula. #Eddunic
		tipoCln.setCellValueFactory(cellData -> cellData.getValue().getTipoProperty());
		veicCln.setCellValueFactory(cellData -> cellData.getValue().getVeiculoRequisitadoProperty());
		criaCln.setCellValueFactory(cellData -> cellData.getValue().getDataCriacaoProperty());
		autorCln.setCellValueFactory(cellData -> cellData.getValue().getDataAutorizadoProperty());
	}

	@FXML
	void atualizaSelect(MouseEvent event) {
		lbNum.setText(String.valueOf(solicitTable.getSelectionModel().getSelectedItem().getNumero()));
		lbVeic.setText(solicitTable.getSelectionModel().getSelectedItem().getVeiculoRequisitado());
		lbTipo.setText(solicitTable.getSelectionModel().getSelectedItem().getTipo());
		lbConfirm.setText(solicitTable.getSelectionModel().getSelectedItem().getDataVeiculoConfirmado());
		lbDataCria.setText(solicitTable.getSelectionModel().getSelectedItem().getDataCriacao());
		lbHoraCria.setText(solicitTable.getSelectionModel().getSelectedItem().getHoraCriacao());
		lbInicio.setText(solicitTable.getSelectionModel().getSelectedItem().getDataInicio());
		lbFim.setText(solicitTable.getSelectionModel().getSelectedItem().getDataFim());
		lbDest.setText(solicitTable.getSelectionModel().getSelectedItem().getLocalViagem());
		lbFinalid.setText(solicitTable.getSelectionModel().getSelectedItem().getFinalidade());
		lbAutoriz.setText(solicitTable.getSelectionModel().getSelectedItem().getDataAutorizado());
		lbPassag.setText(String.valueOf(solicitTable.getSelectionModel().getSelectedItem().getQtdePassageiros()));
		lbAutor.setText(solicitTable.getSelectionModel().getSelectedItem().getSiapeServRealiza());
		lbOutor.setText(solicitTable.getSelectionModel().getSelectedItem().getSiapeServAutoriza());
	}

	@FXML
	void excluiSolicit(ActionEvent event) {
		DAOSolicitacaoSP.delete(solicitTable.getSelectionModel().getSelectedItem().getNumero());
		refreshTable();
	}

	@FXML
	void editarTable(ActionEvent event) {
		solicitacao = new Solicitacao(solicitTable.getSelectionModel().getSelectedItem().getNumero(), 
				solicitTable.getSelectionModel().getSelectedItem().getVeiculoRequisitado(),"133932", "122212", "121414", "1213", 
				solicitTable.getSelectionModel().getSelectedItem().getDataCriacao(), "lo3a", "1224", 
				solicitTable.getSelectionModel().getSelectedItem().getDataAutorizado(), 4, 
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
		lbVeic.setText("");
		lbTipo.setText("");
		lbConfirm.setText("");
		lbDataCria.setText("");
		lbHoraCria.setText("");
		lbInicio.setText("");
		lbFim.setText("");
		lbDest.setText("");
		lbFinalid.setText("");
		lbAutoriz.setText("");
		lbPassag.setText("");
		lbAutor.setText("");
		lbOutor.setText("");
	}
	
}
