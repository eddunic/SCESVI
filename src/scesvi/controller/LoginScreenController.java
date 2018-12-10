package scesvi.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;
import scesvi.model.dao.DAOContratado;
import scesvi.model.dao.DAOServidor;

public class LoginScreenController {

	@FXML
	private JFXTextField tSiape;

	@FXML
	private JFXPasswordField pPassword;

	@FXML
	private Label lblCount;

	@FXML
	private JFXButton bCad;

	@FXML
	private BorderPane bp;

	@FXML
	private ImageView vBar;

	@FXML
	private AnchorPane anchor;

	TranslateTransition transition;

	@FXML
	void initialize() {
		transition = new TranslateTransition(Duration.seconds(2), vBar);
		screenLogin();
	}

	public void screenLogin() {
		transition.setToX(vBar.getLayoutX() + (anchor.getPrefWidth() - vBar.getFitWidth()));
		transition.play();
	}

	public void btOpenRegisterAction() {
		vBar.setFitWidth(vBar.getFitWidth() - 50);
		transition.setToX(anchor.getLayoutX());
		transition.play();

		bp.setRight(MainApp.fxmlUserRegister);
		
		
		// MainApp.changeScreen("UserRegister");
	}
	
    @FXML
    void volta(ActionEvent event) {
    	screenLogin();
    }

	public void btOpenContainerAction() {
		
		if (DAOContratado.consultContratadoAdmin(tSiape.getText()).equals(tSiape.getText())) {
			if(DAOServidor.consultAdminLogin(tSiape.getText(), pPassword.getText())) {
				MainApp.changeScreen("ContainerTelas");
			}
		}
		
	}

//	public void loadDialog(ActionEvent event) {
//		JFXDialogLayout dialogo = new JFXDialogLayout();
//		dialogo.setHeading(new Text("Atenção"));
//		dialogo.setBody(new Text("Presta atenção"));

		//JFXDialog caixa = new JFXDialog(stackPane, dialogo, JFXDialog.DialogTransition.CENTER);

//	}

}
