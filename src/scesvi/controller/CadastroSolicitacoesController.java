package scesvi.controller;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.FlowPane;
import scesvi.model.Servidor;
import scesvi.model.Solicitacao;
import scesvi.model.dao.DAOServidor;

public class CadastroSolicitacoesController {

    @FXML
    private ComboBox<Servidor> cbSiapeSolicit;
    
    private ObservableList<String> siapesServs;
    
    private List<Servidor> servidores;
    
    @FXML
	public void initialize() {
		group();
	}
    
    public void group() {
		//cbSiapeSolicit.setItems(FXCollections.observableArrayList(DAOServidor.siapeList()));
    	
//    	siapesServs = FXCollections.observableArrayList();
//    	servidores = new DAOServidor.siapeList(); //Aqui você tem uma lista de todos seu produtos
//    	servidores.forEach(p ->{ siapesServs.add(p.getNome());}); // Aqui estamos os nomes do seus Produtos.
//    	//Agora é so adicionar esta lista ao ComboBox
//    	cbSiapeSolicit.getItems().addAll(siapesServs);
    }
    
}
