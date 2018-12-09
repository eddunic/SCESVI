package scesvi.controller;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import javafx.beans.property.SimpleStringProperty;
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
import scesvi.model.dao.DAOServidor;
import scesvi.model.dao.DAOServidorSP;
import scesvi.model.dao.DAOTelefone;
import scesvi.model.dao.DAOVeiculo;

public class AlteracaoServidorController {
	
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
	private JFXTextField cpf;

	@FXML
	private JFXDatePicker dataNasc;

	@FXML
	private JFXTextField nome;

	@FXML
	private JFXTextField telefone;

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
    private ComboBox<String> cbSiape;
	
	@FXML
	private JFXButton bCarregaDados;

	@FXML
	void backAction(ActionEvent event) {
		if (bCadastrar.getText().equals("Alterar")) {
			vDadosIcons.setVisible(true);
			vDados.setVisible(true);

			fMotorista.setVisible(false);
			vAcesso.setVisible(false);
			vServico.setVisible(false);

			bCadastrar.setText("Próximo");
		}
		if (bCadastrar.getText().equals("Próximo")) {
			bVoltar.setVisible(false);
		}
	}

	public String dateFormat() {
		Date dataInicio = new Date();
		formatar = new SimpleDateFormat("ddMMyyyy");
		dataInicioFormatada = formatar.format(dataInicio);

		return dataInicioFormatada;
	}

	public void group() {
		bVoltar.setVisible(false);
		radioGroup = new ToggleGroup();

		rbSim.setToggleGroup(radioGroup);
		rbNao.setToggleGroup(radioGroup);
		rbNao.setSelected(true); // Deixa o nao selecionado por default.

		cbCategoria.setItems(FXCollections.observableArrayList("A", "B", "C", "D", "E"));
		cbDepart.setItems(FXCollections.observableArrayList("DAIC", "DAINFRA", "DQA", "DGP", "DPI", "DTI"));
		cbCargo.setItems(FXCollections.observableArrayList("Coordenador", "Guarda", "Motorista", "Servidor comum"));
		
		cbSiape.setItems(DAOServidor.siapeList());
		cbSiape.getSelectionModel().select(0);
		
		cpf.setText(DAOServidor.consultParam("cpf", cbSiape.getSelectionModel().getSelectedItem())); 
		nome.setText(DAOServidor.consultParam("nome", cbSiape.getSelectionModel().getSelectedItem())); 
		telefone.setText(DAOTelefone.consultTel(cbSiape.getSelectionModel().getSelectedItem())); 
		dataNasc.setValue(DAOServidor.consultDataNasc(cbSiape.getSelectionModel().getSelectedItem()));
		cnh.setText(DAOServidor.consultParam("cnh", cbSiape.getSelectionModel().getSelectedItem())); 
		cbCategoria.getSelectionModel().select(DAOServidor.consultParam("categoria", cbSiape.getSelectionModel().getSelectedItem()));	
		String codDep = DAOLotado.consultLotado(cbSiape.getSelectionModel().getSelectedItem());
		cbDepart.getSelectionModel().select(DAODepartamento.consultDep(codDep));
		String codCargo = DAOContratado.consultContratado(cbSiape.getSelectionModel().getSelectedItem());
		cbCargo.getSelectionModel().select(DAOCargo.consultCargo(codCargo));
		pfSenha.setText(DAOServidor.consultParam("senha", cbSiape.getSelectionModel().getSelectedItem())); 
	}

	@FXML
	public void initialize() {
		group();
	}
	
	@FXML
	private void alterar(ActionEvent e) {
		if (bCadastrar.getText().equals("Próximo") && !nome.getText().equals("") && !cpf.getText().equals("")
				&& !cbSiape.getSelectionModel().getSelectedItem().equals("")) {
			vDadosIcons.setVisible(false);
			vDados.setVisible(false);

			fMotorista.setVisible(true);
			vAcesso.setVisible(true);
			vServico.setVisible(true);

			bCadastrar.setText("Alterar");
			bVoltar.setVisible(true);
		}
		if (bCadastrar.getText().equals("Alterar")  && !pfSenha.getText().equals("")
				&& !sfSenha.getText().equals("") && !cbDepart.getSelectionModel().isEmpty() && !cbCargo.getSelectionModel().isEmpty()
				&& pfSenha.getText().equals(sfSenha.getText())) {
			selectedRadioButton = (JFXRadioButton) radioGroup.getSelectedToggle();

			servidor = new Servidor(cbSiape.getSelectionModel().getSelectedItem(), cpf.getText(), nome.getText(), pfSenha.getText(),
					dataNasc.getValue(), cnh.getText(), cbCategoria.getSelectionModel().getSelectedItem(),
					(selectedRadioButton.getText().equals("Sim")) ? "S" : "N");
			DAOServidor.update(servidor);

			tel = new Telefone(cbSiape.getSelectionModel().getSelectedItem(), telefone.getText());
			DAOTelefone.update(tel);

			codDep = DAODepartamento.searchDepart(cbDepart.getSelectionModel().getSelectedItem());
			lotado = new Lotado(cbSiape.getSelectionModel().getSelectedItem(), codDep, dateFormat(), "");
			DAOLotado.update(lotado);

			codCargo = DAOCargo.searchCargo(cbCargo.getSelectionModel().getSelectedItem());
			contratado = new Contratado(cbSiape.getSelectionModel().getSelectedItem(), codCargo, dateFormat(), "");
			DAOContratado.update(contratado);
		}
	}
	
	@FXML
    void carregarDados(ActionEvent event) {
		cpf.setText(DAOServidor.consultParam("cpf", cbSiape.getSelectionModel().getSelectedItem())); 
		nome.setText(DAOServidor.consultParam("nome", cbSiape.getSelectionModel().getSelectedItem())); 
		telefone.setText(DAOTelefone.consultTel(cbSiape.getSelectionModel().getSelectedItem())); 
		dataNasc.setValue(DAOServidor.consultDataNasc(cbSiape.getSelectionModel().getSelectedItem()));
		cnh.setText(DAOServidor.consultParam("cnh", cbSiape.getSelectionModel().getSelectedItem())); 
		cbCategoria.getSelectionModel().select(DAOServidor.consultParam("categoria", cbSiape.getSelectionModel().getSelectedItem()));	
		String codDep = DAOLotado.consultLotado(cbSiape.getSelectionModel().getSelectedItem());
		cbDepart.getSelectionModel().select(DAODepartamento.consultDep(codDep));
		String codCargo = DAOContratado.consultContratado(cbSiape.getSelectionModel().getSelectedItem());
		cbCargo.getSelectionModel().select(DAOCargo.consultCargo(codCargo));
		pfSenha.setText(DAOServidor.consultParam("senha", cbSiape.getSelectionModel().getSelectedItem())); 
    }	

}
