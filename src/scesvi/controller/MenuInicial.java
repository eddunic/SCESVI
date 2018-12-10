package scesvi.controller;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import scesvi.model.SolicitVeiculo;
import scesvi.model.dao.DAOSolicitVeiculo;
import scesvi.model.SolicitVeiculo;

public class MenuInicial {

    @FXML
    private TableView<SolicitVeiculo> SolicitVeiculoTable;

    @FXML
    private TableColumn<SolicitVeiculo, String> numCln;
    
    @FXML
    private TableColumn<SolicitVeiculo, CheckBox> solicC;

    @FXML
    private TableColumn<SolicitVeiculo, CheckBox> conf;

    @FXML
    private TableColumn<SolicitVeiculo, CheckBox> cancel;

    @FXML
    private TableView<SolicitVeiculo> situVeicTable;

    @FXML
    private TableColumn<SolicitVeiculo, String> codV;

    @FXML
    private TableColumn<SolicitVeiculo, CheckBox> situVeic;
    
    @FXML
    void initialize() {
    	//SolicitVeiculoTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    	//situVeicTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    	
    	//SolicitVeiculoTable.setItems(DAOSolicitVeiculo.list());
    	
    	//solicC.setCellValueFactory(c -> new SimpleBooleanProperty(c.));
    	//solicC.setCellFactory(tc -> new CheckBoxTableCell<>());
    	//conf.setCellFactory(tc -> new CheckBoxTableCell<>());
    	//cancel.setCellFactory(tc -> new CheckBoxTableCell<>());
    }
}
