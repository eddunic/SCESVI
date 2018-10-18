package scesvi.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import scesvi.MainApp;

public class LoginScreenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField tName;

    @FXML
    private JFXPasswordField pPassword;

    @FXML
    private JFXButton bEnter;

    @FXML
    private Label lblCount;

    @FXML
    private Label lblRegister;
    
    private MainApp mainApp;

    public void btRegisterAction() {
    	MainApp.changeScreen("UserRegister");
    }
    
    public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
    
}


