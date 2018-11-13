package scesvi.controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;

public class BarraLateralController {
	
    @FXML
    public void openMenuInicialAction(ActionEvent a) {
    	//System.out.println("AAAA");
    	ContainerTelasController.loadComponent("Menuinicial");
    }

    @FXML
    void openRegistros(MouseEvent event) {
    	ContainerTelasController.loadComponent("Registros");
    }

    @FXML
    void openRelatorios(MouseEvent event) {
    	ContainerTelasController.loadComponent("Relatorios");
    }

    @FXML
    void openServidores(MouseEvent event) {
    	ContainerTelasController.loadComponent("Servidores");
    }

    @FXML
    void openSolicitacoes(MouseEvent event) {
    	ContainerTelasController.loadComponent("Solicitacoes");
    }

    @FXML
    void openVeiculos(MouseEvent event) {
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
