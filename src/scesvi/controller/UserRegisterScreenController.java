package scesvi.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import scesvi.model.Contratado;
import scesvi.model.Lotado;
import scesvi.model.Servidor;
import scesvi.model.Telefone;
import scesvi.model.dao.DAOCargo;
import scesvi.model.dao.DAOContratado;
import scesvi.model.dao.DAODepartamento;
import scesvi.model.dao.DAOLotado;
import scesvi.model.dao.DAOServidorSP;
import scesvi.model.dao.DAOTelefone;

public class UserRegisterScreenController {

	@FXML
	private JFXTextField cnh;

	@FXML
	private ComboBox<String> cbCategoria;

	@FXML
	private ComboBox<String> cbDepart;

	@FXML
	private ComboBox<String> cbCargo;

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
	private JFXPasswordField sfSenha;

	@FXML
	private JFXTextField email;

	@FXML
	private JFXButton bCadastrar, bVoltar;

	private ToggleGroup radioGroup;

	private JFXRadioButton selectedRadioButton;

	static Servidor servidor;

	private Telefone tel;

	private Lotado lotado;

	private Contratado contratado;

	private int codDep;

	private int codCargo;

	private SimpleDateFormat formatar;

	private String dataInicioFormatada;

	@FXML
	private VBox vServico;

	@FXML
	private VBox vAcesso;

	@FXML
	private FlowPane fMotorista;

	@FXML
	private VBox vDados;

	@FXML
	private VBox vDadosIcons;

	@FXML
	public void btRegisterAction(ActionEvent event) {

		if (bCadastrar.getText().equals("Próximo") && !nome.getText().equals("") && !cpf.getText().equals("")
				&& !siape.getText().equals("")) {
			vDadosIcons.setVisible(false);
			vDados.setVisible(false);

			fMotorista.setVisible(true);
			vAcesso.setVisible(true);
			vServico.setVisible(true);

			bCadastrar.setText("Cadastrar");
		}
		if (bCadastrar.getText().equals("Cadastrar") && !pfSenha.getText().equals("")
				&& !sfSenha.getText().equals("") && !cbDepart.getSelectionModel().isEmpty() && !cbCargo.getSelectionModel().isEmpty()) {
			selectedRadioButton = (JFXRadioButton) radioGroup.getSelectedToggle();

			servidor = new Servidor(siape.getText(), cpf.getText(), nome.getText(), pfSenha.getText(),
					dataNasc.getValue(), cnh.getText(), cbCategoria.getSelectionModel().getSelectedItem(),
					(selectedRadioButton.getText().equals("Sim")) ? "S" : "N");
			DAOServidorSP.insert(servidor);

			tel = new Telefone(siape.getText(), telefone.getText());
			DAOTelefone.insert(tel);

			codDep = DAODepartamento.searchDepart(cbDepart.getSelectionModel().getSelectedItem());
			lotado = new Lotado(siape.getText(), codDep, dateFormat(), "");
			DAOLotado.insert(lotado);

			codCargo = DAOCargo.searchCargo(cbCargo.getSelectionModel().getSelectedItem());
			contratado = new Contratado(siape.getText(), codCargo, dateFormat(), "");
			DAOContratado.insert(contratado);

			// backAction(event);
		}
	}

	@FXML
	void backAction(ActionEvent event) {
		if (bCadastrar.getText().equals("Cadastrar")) {
			vDadosIcons.setVisible(true);
			vDados.setVisible(true);

			fMotorista.setVisible(false);
			vAcesso.setVisible(false);
			vServico.setVisible(false);

			bCadastrar.setText("Próximo");
		}
	}

	public String dateFormat() {
		Date dataInicio = new Date();
		formatar = new SimpleDateFormat("ddMMyyyy");
		dataInicioFormatada = formatar.format(dataInicio);

		return dataInicioFormatada;
	}

	public void group() {
		radioGroup = new ToggleGroup();

		rbSim.setToggleGroup(radioGroup);
		rbNao.setToggleGroup(radioGroup);
		rbNao.setSelected(true); // Deixa o nao selecionado por default.

		cbCategoria.setItems(FXCollections.observableArrayList("A", "B", "C", "D", "E"));
		cbDepart.setItems(FXCollections.observableArrayList("DAIC", "DAINFRA", "DQA", "DGP", "DPI", "DTI"));
		cbCargo.setItems(FXCollections.observableArrayList("Coordenador", "Guarda", "Motorista", "Servidor comum"));
	}

	@FXML
	public void initialize() {
		group();
	}
	
}
