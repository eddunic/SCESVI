package scesvi.controller;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import scesvi.model.Solicitacao;
import scesvi.model.dao.DAOSolicitacaoSP;

public class SolicitacaoController {

	@FXML
	private TableView<Solicitacao> solicitTable;
	
    @FXML
    private TableColumn<Solicitacao, IntegerProperty> numCln;
    
    @FXML
    private TableColumn<Solicitacao, StringProperty> tipoCln;

    @FXML
    private TableColumn<Solicitacao, StringProperty> veicCln;

    @FXML
    private TableColumn<Solicitacao, StringProperty> criaCln;

    @FXML
    private TableColumn<Solicitacao, StringProperty> autorCln;
    
    @FXML
    private Label lbNum;

    @FXML
    private Label lbTipo;

    @FXML
    private Label lbCria;

	@FXML
    void initialize() {
		solicitTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		numCln.setCellValueFactory(new PropertyValueFactory<>("numero"));
		tipoCln.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		veicCln.setCellValueFactory(new PropertyValueFactory<>("veiculoRequisitado"));
		criaCln.setCellValueFactory(new PropertyValueFactory<>("dataCriacao"));
		autorCln.setCellValueFactory(new PropertyValueFactory<>("dataAutorizado"));
		
		solicitTable.setItems(DAOSolicitacaoSP.list());
		
		solicitTable.getSelectionModel().selectFirst();
	}
	
	@FXML
    void atualizaSelect(MouseEvent event) {
		lbNum.setText(String.valueOf(solicitTable.getSelectionModel().getSelectedItem().getNumero()));
    }

}
