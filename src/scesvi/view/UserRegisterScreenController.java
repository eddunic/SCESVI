package scesvi.view;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import scesvi.MainApp;
import scesvi.model.DAOServidor;
import scesvi.model.Servidor;

public class UserRegisterScreenController {

    @FXML
    private JFXTextField tName31;

    @FXML
    private JFXTextField tName3;

    @FXML
    private JFXTextField tName1;

    @FXML
    private JFXTextField tName111;

    @FXML
    private JFXTextField tName11;

    @FXML
    private JFXTextField tName21;

    @FXML
    private JFXTextField tName;

    @FXML
    private JFXTextField tName2;

    @FXML
    private JFXTextField tName22;

    @FXML
    private JFXTextField tName32;
    
    private MainApp mainApp;
    
    private Servidor servidor;
    
    public void btRegisterAction() {
    	//Servidor.servidor(String matricula, String nomeUsuario, String dataNasc, String senha, String CNH, String categoria,
    		//	String siape, String autorizadoVeicInstitucional, tName111, tName21, tName32);
    	//DAOServidor.insert(servidor);
    }

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

}
