package scesvi.view;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import scesvi.MainApp;

public class UserRegisterScreenController {

    @FXML
    private JFXButton bNextStep;

    @FXML
    private JFXButton bBackSceneLogin;
    
    private MainApp mainApp;

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

}
