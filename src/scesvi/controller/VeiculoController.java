package scesvi.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import scesvi.model.Veiculo;
import scesvi.model.dao.DAOServidor;
import scesvi.model.dao.DAOSolicitacaoSP;
import scesvi.model.dao.DAOVeiculo;

public class VeiculoController {

	@FXML
	private TableView<Veiculo> veicTable;

	@FXML
	private TableColumn<Veiculo, String> codCln;

	@FXML
	private TableColumn<Veiculo, String> modCln;

	@FXML
	private TableColumn<Veiculo, String> situacaoCln;

	@FXML
	private TableColumn<Veiculo, String> respCln;

	@FXML
	private TableColumn<Veiculo, String> placaCln;

	@FXML
	private Label lbCod;

	@FXML
	private Label lbPlaca;

	@FXML
	private Label lbRen;

	@FXML
	private Label lbAutoriz;

	@FXML
	private Label lbCat;

	@FXML
	private Label lbInst;

	@FXML
	private Label lbMaxP;

	@FXML
	private Label lbObs;

	@FXML
	private Label lbCor;

	@FXML
	private Label lbMarcaMod;

	@FXML
	private Label lbDataSuperv;

	@FXML
	private Label lbSupervisor;

	@FXML
	private Label lbResp;

	private Veiculo veiculo;

	@FXML
	private SplitPane split;

	private AnchorPane fxmlAdd;

	private AnchorPane fxmlAlterar;

	@FXML
	private AnchorPane lateral;

	@FXML
	void initialize() throws IOException {
		veicTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		codCln.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		modCln.setCellValueFactory(new PropertyValueFactory<>("marcaModelo"));
		situacaoCln.setCellValueFactory(new PropertyValueFactory<>("situacao"));
		respCln.setCellValueFactory(new PropertyValueFactory<>("siapeServResponsavel"));
		placaCln.setCellValueFactory(new PropertyValueFactory<>("placa"));

		modCln.setCellFactory(TextFieldTableCell.forTableColumn());
		situacaoCln.setCellFactory(TextFieldTableCell.forTableColumn());
		respCln.setCellFactory(TextFieldTableCell.forTableColumn());
		placaCln.setCellFactory(TextFieldTableCell.forTableColumn());

		veicTable.setItems(DAOVeiculo.list());

		veicTable.getSelectionModel().selectFirst();

		modCln.setCellValueFactory(cellData -> cellData.getValue().getMarcaModeloProperty());
		respCln.setCellValueFactory(cellData -> cellData.getValue().getSiapeServResponsavelProperty());
		placaCln.setCellValueFactory(cellData -> cellData.getValue().getPlacaProperty());
		situacaoCln.setCellValueFactory(cellData -> cellData.getValue().getSituacaoProperty());

		fxmlAdd = FXMLLoader.load(getClass().getResource("../view/CadastroVeiculos.fxml"));

		fxmlAlterar = FXMLLoader.load(getClass().getResource("../view/AlteracaoVeiculo.fxml"));
	}

	@FXML
	void atualizaSelect(MouseEvent event) {
		refreshTable();
	}

	@FXML
	void excluiVeic(ActionEvent event) {
		DAOVeiculo.delete(veicTable.getSelectionModel().getSelectedItem().getCodigo());
		veicTable.setItems(DAOVeiculo.list());
		veicTable.getSelectionModel().selectFirst();
		refreshTable();
		JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
	}

	@FXML
	void editarTable(ActionEvent event) {
		veicTable.setItems(DAOVeiculo.list());
		veicTable.getSelectionModel().selectFirst();
		refreshTable();
	}

	@FXML
	void novoVeic(ActionEvent event) {
		split.getItems().remove(1);
		split.getItems().add(1, fxmlAdd);
	}

	void refreshTable() {
		lbCod.setText(String.valueOf(veicTable.getSelectionModel().getSelectedItem().getCodigo()));
		lbPlaca.setText(veicTable.getSelectionModel().getSelectedItem().getPlaca());
		lbRen.setText(DAOVeiculo.consultParam("renavam", veicTable.getSelectionModel().getSelectedItem().getCodigo()));
		lbAutoriz.setText(
				DAOVeiculo.consultParam("autorizado", veicTable.getSelectionModel().getSelectedItem().getCodigo()));
		lbCat.setText(
				DAOVeiculo.consultParam("categoria", veicTable.getSelectionModel().getSelectedItem().getCodigo()));
		lbInst.setText(
				DAOVeiculo.consultParam("institucional", veicTable.getSelectionModel().getSelectedItem().getCodigo()));
		lbMaxP.setText(
				DAOVeiculo.consultParam("maxPassageiros", veicTable.getSelectionModel().getSelectedItem().getCodigo()));
		lbObs.setText(
				DAOVeiculo.consultParam("observacao", veicTable.getSelectionModel().getSelectedItem().getCodigo()));
		lbCor.setText(DAOVeiculo.consultParam("cor", veicTable.getSelectionModel().getSelectedItem().getCodigo()));
		lbMarcaMod.setText(veicTable.getSelectionModel().getSelectedItem().getMarcaModelo());
		lbDataSuperv.setText(DAOVeiculo.consultParam("dataSupervisionado",
				veicTable.getSelectionModel().getSelectedItem().getCodigo()));
		lbSupervisor.setText(DAOVeiculo.consultParam("siapeServSupervisiona",
				veicTable.getSelectionModel().getSelectedItem().getCodigo()));
		lbResp.setText(veicTable.getSelectionModel().getSelectedItem().getSiapeServResponsavel());
	}

	@FXML
	private void back(ActionEvent event) throws IOException {
		split.getItems().remove(1);
		split.getItems().add(1, lateral);
		fxmlAdd = FXMLLoader.load(getClass().getResource("../view/CadastroVeiculos.fxml"));

	}

	@FXML
	void alterar(ActionEvent event) {
		split.getItems().remove(1);
		split.getItems().add(1, fxmlAlterar);
	}

}
