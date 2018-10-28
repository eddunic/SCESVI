package scesvi.controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ContainerTelasController {

	@FXML
	private static BorderPane borderPaneContainer;

	@FXML
	private JFXHamburger jfxHamb;

	@FXML
	private JFXDrawer jfxDrawerBar;

	@FXML
	private VBox menuLateral;

	@FXML
	private static VBox graficosFluxo;

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
				jfxDrawerBar.close();
			} else {
				jfxDrawerBar.open();
			}

		});
	}

	@FXML
	private void createComponents() throws IOException {
		menuLateral = FXMLLoader.load(getClass().getResource("../view/BarraLateral.fxml"));
		graficosFluxo = FXMLLoader.load(getClass().getResource("../view/GraficosFluxo.fxml"));
	}

	static void loadComponent(String fx) {
		//borderPaneContainer.setCenter(null);

//		switch (fx) {
//		case "Menu inicial":
//			borderPaneContainer.setCenter(graficosFluxo);
//			graficosFluxo.setAlignment(Pos.CENTER);
//			break;
//		}
	}
	
	void nodesButons() {
		JFXButton nr = new JFXButton("A");
		nr.setButtonType(JFXButton.ButtonType.RAISED);
		borderPaneContainer.setRight(nr);
		//nr.getStyleClass().add
	}
}
