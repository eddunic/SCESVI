package scesvi.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import scesvi.model.Veiculo;
import scesvi.model.dao.DAOVeiculo;

public class VeiculoController {

	@FXML
	private TableView<Veiculo> veicTable;
	
	@FXML
    private TableColumn<Veiculo, String> codCln;

    @FXML
    private TableColumn<Veiculo, String> modCln;

    @FXML
    private TableColumn<Veiculo, String> anoCln;

    @FXML
    private TableColumn<Veiculo, String> respCln;

    @FXML
    private TableColumn<Veiculo, String> placaCln;

    @FXML
    private Label lbCod;

    @FXML
    private Label lbPlaca;

    @FXML
    private Label lbTipo;

    @FXML
    private Label lbRen;

    @FXML
    private Label lbAutoriz;

    @FXML
    private Label lbCat;

    @FXML
    private Label lbInst;

    @FXML
    private Label lbChassi;

    @FXML
    private Label lbMaxP;

    @FXML
    private Label lbObs;

    @FXML
    private Label lbExe;

    @FXML
    private Label lbCombs;

    @FXML
    private Label lbPot;

    @FXML
    private Label lbCor;

    @FXML
    private Label lbMarcaMod;

    @FXML
    private Label lbFabric;

    @FXML
    private Label lbAnoMod;

    @FXML
    private Label lbDataSuperv;

    @FXML
    private Label lbSupervisor;

    @FXML
    private Label lbResp;
	
	private Veiculo veiculo;

	@FXML
	void initialize() {
		veicTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		codCln.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		modCln.setCellValueFactory(new PropertyValueFactory<>("marcaModelo"));
		anoCln.setCellValueFactory(new PropertyValueFactory<>("anoModelo"));
		respCln.setCellValueFactory(new PropertyValueFactory<>("siapeServResponsavel"));
		placaCln.setCellValueFactory(new PropertyValueFactory<>("placa"));

		modCln.setCellFactory(TextFieldTableCell.forTableColumn());
		anoCln.setCellFactory(TextFieldTableCell.forTableColumn());
		respCln.setCellFactory(TextFieldTableCell.forTableColumn());
		placaCln.setCellFactory(TextFieldTableCell.forTableColumn());
		
		veicTable.setItems(DAOVeiculo.list());

		veicTable.getSelectionModel().selectFirst();
		
		modCln.setCellValueFactory(cellData -> cellData.getValue().getMarcaModeloProperty());
		anoCln.setCellValueFactory(cellData -> cellData.getValue().getAnoModeloProperty());
		respCln.setCellValueFactory(cellData -> cellData.getValue().getSiapeServResponsavelProperty());
		placaCln.setCellValueFactory(cellData -> cellData.getValue().getPlacaProperty());
	}

	@FXML
	void atualizaSelect(MouseEvent event) {
		refreshTable();
	}

	@FXML
	void excluiVeic(ActionEvent event) {
		DAOVeiculo.delete(veicTable.getSelectionModel().getSelectedItem().getCodigo());
		refreshTable();
	}

	@FXML
	void editarTable(ActionEvent event) {
		veiculo = new Veiculo(veicTable.getSelectionModel().getSelectedItem().getCodigo(), "a", 
				veicTable.getSelectionModel().getSelectedItem().getPlaca(), "q", "n", "c", "s", "123", 4, 
				"nda", "nenh", "g", 12, "verde", veicTable.getSelectionModel().getSelectedItem().getMarcaModelo(),
				"2012", veicTable.getSelectionModel().getSelectedItem().getAnoModelo(), "121314", "12341", 
				veicTable.getSelectionModel().getSelectedItem().getSiapeServResponsavel());
		DAOVeiculo.update(veiculo);
		refreshTable();
	}

	@FXML
	void novoVeic(ActionEvent event) {
		
	}

	void refreshTable() {
		lbCod.setText(veicTable.getSelectionModel().getSelectedItem().getCodigo());
		lbTipo.setText(DAOVeiculo.consultParam("tipo", veicTable.getSelectionModel().getSelectedItem().getCodigo()));
		lbPlaca.setText(veicTable.getSelectionModel().getSelectedItem().getPlaca());
		lbRen.setText(DAOVeiculo.consultParam("renavam", veicTable.getSelectionModel().getSelectedItem().getCodigo()));
		lbAutoriz.setText(DAOVeiculo.consultParam("autorizado", veicTable.getSelectionModel().getSelectedItem().getCodigo()));
		lbCat.setText(DAOVeiculo.consultParam("categoria", veicTable.getSelectionModel().getSelectedItem().getCodigo()));
		lbInst.setText(DAOVeiculo.consultParam("institucional", veicTable.getSelectionModel().getSelectedItem().getCodigo()));
		lbChassi.setText(DAOVeiculo.consultParam("chassi", veicTable.getSelectionModel().getSelectedItem().getCodigo()));
		lbMaxP.setText(DAOVeiculo.consultParam("maxPassageiros", veicTable.getSelectionModel().getSelectedItem().getCodigo()));
		lbObs.setText(DAOVeiculo.consultParam("observacao", veicTable.getSelectionModel().getSelectedItem().getCodigo()));
		lbExe.setText(DAOVeiculo.consultParam("exercicio", veicTable.getSelectionModel().getSelectedItem().getCodigo()));
		lbCombs.setText(DAOVeiculo.consultParam("tipoCombustivel", veicTable.getSelectionModel().getSelectedItem().getCodigo()));
		lbPot.setText(DAOVeiculo.consultParam("potencia", veicTable.getSelectionModel().getSelectedItem().getCodigo()));
		lbCor.setText(DAOVeiculo.consultParam("cor", veicTable.getSelectionModel().getSelectedItem().getCodigo()));
		lbMarcaMod.setText(veicTable.getSelectionModel().getSelectedItem().getMarcaModelo());
		lbFabric.setText(DAOVeiculo.consultParam("anoFabricacao", veicTable.getSelectionModel().getSelectedItem().getCodigo()));
		lbAnoMod.setText(veicTable.getSelectionModel().getSelectedItem().getAnoModelo());
		lbDataSuperv.setText(DAOVeiculo.consultParam("dataSupervisionado", veicTable.getSelectionModel().getSelectedItem().getCodigo()));
		lbSupervisor.setText(DAOVeiculo.consultParam("siapeServSupervisiona", veicTable.getSelectionModel().getSelectedItem().getCodigo()));
		lbResp.setText(veicTable.getSelectionModel().getSelectedItem().getSiapeServResponsavel());
	}
	
}

