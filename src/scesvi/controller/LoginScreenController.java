package scesvi.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

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
	private StackPane stackPane;

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

	public void btOpenContainerAction() {

		//if (!tSiape.equals("") && !pPassword.equals("")) {
			MainApp.changeScreen("ContainerTelas");
		//}
	}

	public void loadDialog(ActionEvent event) {
		JFXDialogLayout dialogo = new JFXDialogLayout();
		dialogo.setHeading(new Text("Atenção"));
		dialogo.setBody(new Text("Presta atenção"));

		JFXDialog caixa = new JFXDialog(stackPane, dialogo, JFXDialog.DialogTransition.CENTER);

	}

}
