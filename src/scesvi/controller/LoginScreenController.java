package scesvi.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LoginScreenController {

    @FXML
    private JFXTextField tName;

    @FXML
    private JFXPasswordField pPassword;

    @FXML
    private Label lblCount;

    @FXML
    private Label lblRegister;

    public void btOpenRegisterAction() {
    	MainApp.changeScreen("UserRegister");
    }
    
    public void btOpenContainerAction() {
    	MainApp.changeScreen("ContainerTelas");
    }
  
}


