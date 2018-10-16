package scesvi.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class LoginScreenController {

    @FXML
    private AnchorPane loginScene;

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

}

