package scesvi.controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application{
	
	private static Stage stage;
	
	private static Scene loginScene;
	private static Scene userRegisterScene;
	
	@Override
	public void start(Stage primaryStage) throws Exception {	
		stage = primaryStage;
		
		primaryStage.setTitle("Login");
		
		loaderScreens();		
		primaryStage.setScene(loginScene);
		
		primaryStage.show();
	}
	
	public void loaderScreens() throws IOException {
		Parent fxmlLogin = FXMLLoader.load(getClass().getResource("../view/LoginScreen.fxml"));	
		loginScene = new Scene(fxmlLogin, stage.getWidth(), stage.getHeight());
		
		Parent fxmlUserRegister = FXMLLoader.load(getClass().getResource("../view/UserRegisterScreen.fxml"));		
		userRegisterScene = new Scene(fxmlUserRegister, stage.getWidth(), stage.getHeight());
	}
	
	public static void changeScreen(String scr) {
		switch(scr) {
			case "Login":
				stage.setScene(loginScene);
				break;
			case "UserRegister":
				stage.setScene(userRegisterScene);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}

