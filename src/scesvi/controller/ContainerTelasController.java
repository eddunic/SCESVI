package scesvi.controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


//https://www.youtube.com/watch?v=NQQOPy-jmhA CRUD
//
public class ContainerTelasController {

	@FXML
	private static BorderPane borderPaneContainer;

	@FXML
	private JFXHamburger jfxHamb;

	@FXML
	private JFXDrawer jfxDrawerBar;

	@FXML
	private static VBox menuLateral;

	@FXML
	private static VBox graficosFluxo;
	
	@FXML 
	private static BorderPane fxmlSolicitacoes;
	
	@FXML
	private static Scene containerTelasScene;
	
	private static BorderPane fxmlContainerTelas;
	
	public static Scene getScene(Stage stage) {
		try {
			fxmlContainerTelas = FXMLLoader.load(ContainerTelasController.class.getResource("../view/ContainerTelas.fxml"));
			containerTelasScene = new Scene(fxmlContainerTelas, stage.getWidth(), stage.getHeight());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return containerTelasScene;
	}
	
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
		//borderPaneContainer = new BorderPane();
				
		menuLateral = FXMLLoader.load(getClass().getResource("../view/BarraLateral.fxml"));
		graficosFluxo = FXMLLoader.load(getClass().getResource("../view/GraficosFluxo.fxml"));
		fxmlSolicitacoes = FXMLLoader.load(getClass().getResource("../view/Solicitacoes.fxml"));
	}
	
	static void loadComponent(String fx) {
		//fxmlContainerTelas.setCenter(null);
		
		switch (fx) {
		case "Menuinicial":
			fxmlContainerTelas.setCenter(graficosFluxo);
			break;
		case "Solicitacoes":
			fxmlContainerTelas.setCenter(fxmlSolicitacoes);
			break;
		case "Registros":
			break;
		case "Veiculos":
			break;
		case "Servidores":
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
		borderPaneContainer.setRight(nr);
		//nr.getStyleClass().add
	}
}
