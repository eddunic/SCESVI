package scesvi.controller;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import scesvi.model.SolicitVeiculo;
import scesvi.model.Veiculo;
import scesvi.model.dao.DAOSolicitVeiculo;
import scesvi.model.dao.DAOVeiculo;
import scesvi.model.SolicitVeiculo;

public class MenuInicial {

    @FXML
    private TableView<SolicitVeiculo> solicitVeicTable;

    @FXML
    private TableColumn<SolicitVeiculo, String> numCln;
      @FXML
    private TableColumn<SolicitVeiculo, String> situS;

    @FXML
    private TableView<Veiculo> situVeicTable;

    @FXML
    private TableColumn<Veiculo, String> codV;

    @FXML
    private TableColumn<Veiculo, String> situVeic;
    
    @FXML
    void initialize() {
    	solicitVeicTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    	situVeicTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    	
    	solicitVeicTable.setItems(DAOSolicitVeiculo.list());
    	solicitVeicTable.getSelectionModel().selectFirst();
    	
    	situS.setCellValueFactory(cellData -> cellData.getValue().getSituacaoProperty());
    	numCln.setCellValueFactory(cellData -> cellData.getValue().getNumSolicitProperty());
    	
    	situVeicTable.setItems(DAOVeiculo.listCodSitu());
		situVeicTable.getSelectionModel().selectFirst();

		codV.setCellValueFactory(cellData -> cellData.getValue().getMarcaModeloProperty());
		situVeic.setCellValueFactory(cellData -> cellData.getValue().getSituacaoProperty());
		
    }
}
