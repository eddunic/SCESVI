package scesvi.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.FlowPane;
import scesvi.model.Servidor;
import scesvi.model.dao.DAOServidor;

public class CadastroSolicitacoesController {

	@FXML
    private FlowPane fxmlAdd;

    @FXML
    private ComboBox<Servidor> cbSiapeSolicit;
    
    @FXML
	public void initialize() {
		group();
	}
    
    public void group() {
		//cbSiapeSolicit.setItems(FXCollections.observableArrayList(DAOServidor.siapeList()));
	}
    
}
