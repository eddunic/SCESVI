package scesvi.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleGroup;
import scesvi.MainApp;
import scesvi.model.DAOServidor;
import scesvi.model.Servidor;

public class UserRegisterScreenController {

	@FXML
	private JFXTextField cnh;

	@FXML
	private ComboBox<String> cbCategoria;

	@FXML
	private JFXRadioButton rbSim;

	@FXML
	private JFXRadioButton rbNao;

	@FXML
	private JFXTextField siape;

	@FXML
	private JFXTextField cpf;

	@FXML
	private JFXDatePicker dataNasc;

	@FXML
	private JFXTextField nome;

	@FXML
	private JFXTextField telefone;

	@FXML
	private JFXTextField nomeUsuario;

    @FXML
    private JFXPasswordField pfSenha;

	@FXML
	private JFXTextField repitaSenha;

	@FXML
	private JFXTextField email;

	@FXML
	private JFXButton bCadastrar;

	private MainApp mainApp;

	private Servidor servidor;

	private ToggleGroup radioGroup;

	@FXML
	void btRegisterAction(ActionEvent event) {
		JFXRadioButton selectedRadioButton = (JFXRadioButton) radioGroup.getSelectedToggle();

		Servidor servidor = new Servidor(siape.getText(), cpf.getText(), nome.getText(), pfSenha.getText(),
				dataNasc.getValue(), cnh.getText(), cbCategoria.getSelectionModel().getSelectedItem(),
				(selectedRadioButton.getText().equals("Sim"))?"S":"N");
		DAOServidor.insert(servidor);
	}

	void group() {
		radioGroup = new ToggleGroup();

		rbSim.setToggleGroup(radioGroup);
		rbNao.setToggleGroup(radioGroup);

		cbCategoria.setItems(FXCollections.observableArrayList("A", "B", "C", "D", "E"));
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	void initialize() {
		group();
	}
}
