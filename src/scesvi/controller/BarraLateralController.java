package scesvi.controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;

public class BarraLateralController {
	
    @FXML
    public void openMenuInicialAction(ActionEvent a) {
    	System.out.println("AAAA");
    	//ContainerTelasController.loadComponent("Menu inicial");
    }

    @FXML
    void openRegistros(MouseEvent event) {

    }

    @FXML
    void openRelatorios(MouseEvent event) {

    }

    @FXML
    void openServidores(MouseEvent event) {

    }

    @FXML
    void openSolicitacoes(MouseEvent event) {

    }

    @FXML
    void openVeiculos(MouseEvent event) {

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
