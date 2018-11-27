package scesvi.controller;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainApp extends Application {

	private static Stage stage;

	private static Scene loginScene;
	private static Scene userRegisterScene;
	@FXML
	private static Scene containerTelasScene;
	
	protected static BorderPane fxmlContainerTelas;

	protected Parent fxmlLogin;
	
	protected static AnchorPane fxmlUserRegister;
	
	@FXML
	protected static VBox graficosFluxo;
	
	@FXML 
	protected static BorderPane fxmlSolicitacoes;
	
	@FXML 
	protected static BorderPane fxmlVeiculos;
	
	@FXML 
	protected static BorderPane fxmlRegistros;
	
	@FXML 
	protected static BorderPane fxmlServidores;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;

		primaryStage.setTitle("SCESVI: Controle de Veículos");
		
		primaryStage.getIcons().add(new Image("file:ImgPerfil.png"));

		loaderScreens();
		loginScene.setFill(Color.TRANSPARENT);
		userRegisterScene.setFill(null);
		//primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.setScene(loginScene);

		primaryStage.show();
	//	primaryStage.setMaximized(true);
	}

	public void loaderScreens() throws IOException {

		fxmlLogin = FXMLLoader.load(getClass().getResource("../view/LoginScreen.fxml"));
		loginScene = new Scene(fxmlLogin, stage.getWidth(), stage.getHeight());

		fxmlUserRegister = FXMLLoader.load(getClass().getResource("../view/UserRegisterScreen.fxml"));
		userRegisterScene = new Scene(fxmlUserRegister, stage.getWidth(), stage.getHeight());
		
		fxmlContainerTelas = FXMLLoader.load(ContainerTelasController.class.getResource("../view/ContainerTelas.fxml"));
		containerTelasScene = new Scene(fxmlContainerTelas, stage.getWidth(), stage.getHeight());
	
		graficosFluxo = FXMLLoader.load(getClass().getResource("../view/GraficosFluxo.fxml"));
		fxmlSolicitacoes = FXMLLoader.load(getClass().getResource("../view/Solicitacoes.fxml"));
		fxmlVeiculos = FXMLLoader.load(getClass().getResource("../view/Veiculos.fxml"));
		fxmlRegistros = FXMLLoader.load(getClass().getResource("../view/Registros.fxml"));
		fxmlServidores = FXMLLoader.load(getClass().getResource("../view/Servidores.fxml"));
	
	}

	public static void changeScreen(String scr) {
		switch (scr) {
		case "Login":
			stage.setScene(loginScene);
			break;
		case "ContainerTelas":
			stage.setScene(containerTelasScene);
			break;
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
