package scesvi.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.MenuItem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ToggleGroup;
import scesvi.MainApp;
import scesvi.model.DAOServidor;
import scesvi.model.Servidor;

public class UserRegisterScreenController {

	@FXML
	private JFXTextField cnh;

	@FXML
	private MenuButton categoria;

	@FXML
	private MenuItem a;

	@FXML
	private MenuItem b;

	@FXML
	private MenuItem c;

	@FXML
	private MenuItem d;

	@FXML
	private MenuItem e;

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
	private JFXTextField senha;

	@FXML
	private JFXTextField repitaSenha;

	@FXML
	private JFXTextField email;

	@FXML
	private JFXButton bCadastrar;

	@FXML
	private MenuButton depart;

	@FXML
	private MenuButton cargo;

	private MainApp mainApp;

	private Servidor servidor;

	private ToggleGroup radioGroup;

	@FXML
	void btRegisterAction(ActionEvent event) {
		JFXRadioButton selectedRadioButton = (JFXRadioButton) radioGroup.getSelectedToggle();

		Servidor servidor = new Servidor(siape.getText(), cpf.getText(), nome.getText(), senha.getText(),
				dataNasc.getValue(), cnh.getText(), categoria.getText(), selectedRadioButton.getText());
		DAOServidor.insert(servidor);
	}

	void group() {
		radioGroup = new ToggleGroup();

		rbSim.setToggleGroup(radioGroup);
		rbNao.setToggleGroup(radioGroup);

		categoria.getItems();
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	void initialize() {
		group();
	}
}
