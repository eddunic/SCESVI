package scesvi.controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

//https://www.youtube.com/watch?v=NQQOPy-jmhA CRUD
//
public class ContainerTelasController {

	@FXML
	private JFXHamburger jfxHamb;

	@FXML
	private JFXDrawer jfxDrawerBar;

	@FXML
	private static VBox menuLateral;
        
    @FXML
    private VBox contemGuias;
	
	@FXML
	public void initialize() throws IOException {
		createComponents();
		barraLateral();
	}

	public void barraLateral() {
		jfxDrawerBar.setSidePane(menuLateral);

		HamburgerBackArrowBasicTransition burgerTask2 = new HamburgerBackArrowBasicTransition(jfxHamb);
		burgerTask2.setRate(-1);
		jfxHamb.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
			burgerTask2.setRate(burgerTask2.getRate() * -1);
			burgerTask2.play();

			if (jfxDrawerBar.isOpened()) {
				jfxDrawerBar.setManaged(false);
				jfxDrawerBar.close();
				//JFXDrawer.setMargin(menuLateral, new Insets(0, menuLateral.translateXProperty().doubleValue(), 0, 0));
			} else {
				jfxDrawerBar.setManaged(true);
				jfxDrawerBar.open();
			}
		});
	}

	@FXML
	private void createComponents() throws IOException {

		menuLateral = FXMLLoader.load(getClass().getResource("../view/BarraLateral.fxml"));
	}
	
	static void loadComponent(String fx) {
		//fxmlContainerTelas.setCenter(null);
		
		switch (fx) {
		case "MenuInicial":
			MainApp.fxmlContainerTelas.setCenter(MainApp.graficosFluxo);
			break;
		case "Solicitacoes":
			MainApp.fxmlContainerTelas.setCenter(MainApp.fxmlSolicitacoes);
			break;
		case "Registros":
			MainApp.fxmlContainerTelas.setCenter(MainApp.fxmlRegistros);
			break;
		case "Veiculos":
			MainApp.fxmlContainerTelas.setCenter(MainApp.fxmlVeiculos);
			break;
		case "Servidores":
			MainApp.fxmlContainerTelas.setCenter(MainApp.fxmlServidores);
			break;
		case "Relatorios":
			break;
			//fxmlContainerTelas.setBottom(graficosFluxo);
			//borderPaneContainer.setAlignment(graficosFluxo, Pos.CENTER);
		}
	}
	
	void nodesButons() {
		JFXButton nr = new JFXButton("A");
		nr.setButtonType(JFXButton.ButtonType.RAISED);
		//borderPaneContainer.setRight(nr);
		//nr.getStyleClass().add
	}
}
