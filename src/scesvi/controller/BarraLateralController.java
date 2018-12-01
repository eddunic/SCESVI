package scesvi.controller;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;

public class BarraLateralController {
	
    @FXML
    public void openMenuInicialAction(ActionEvent a) {
    	ContainerTelasController.loadComponent("MenuInicial");
    }

    @FXML
    void openRegistros(ActionEvent event) {
    	ContainerTelasController.loadComponent("Registros");
    }

    @FXML
    void openRelatorios(ActionEvent event) {
    	ContainerTelasController.loadComponent("Relatorios");
    }

    @FXML
    void openServidores(ActionEvent event) {
    	ContainerTelasController.loadComponent("Servidores");
    }

    @FXML
    void openSolicitacoes(ActionEvent event) {
    	ContainerTelasController.loadComponent("Solicitacoes");
    }

    @FXML
    void openVeiculos(ActionEvent event) {
    	ContainerTelasController.loadComponent("Veiculos");
    }
//	@FXML
//    private void btnOpenMenus(){
//		ContainerTelasController.changeScreens();
//	}
//	
//	@FXML
//    private void changeScreen(ActionEvent event) {
//        JFXButton btn = (JFXButton) event.getSource();
//        System.out.println(btn.getText());
//        switch (btn.getText()) {
//        case "Menu Inicial":
//        	borderPaneContainer.setCenter(graficosFluxo);
//        	graficosFluxo.setAlignment(Pos.CENTER);
//        	break;
//        }
//	}
	
}
