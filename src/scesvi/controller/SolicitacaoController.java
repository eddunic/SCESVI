package scesvi.controller;

import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import scesvi.model.Solicitacao;
import scesvi.model.dao.DAOSolicitacao;

public class SolicitacaoController {

	@FXML
	private TableView<Solicitacao> solicitTable;
	
    @FXML
    private TableColumn<Solicitacao, IntegerProperty> numCln;

	@FXML
    void initialize() {
		numCln.setCellValueFactory(new PropertyValueFactory<>("numero"));
		
		solicitTable.setItems(DAOSolicitacao.list());
	}

}
