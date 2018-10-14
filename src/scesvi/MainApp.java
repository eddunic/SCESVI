package scesvi;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import scesvi.model.DAO;
import scesvi.view.UserRegisterScreenController;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Login");
		changeScene("view/RootLayout.fxml");
		showLoginOverview();
	}

	public void changeScene(String directory) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource(directory));
			rootLayout = (BorderPane) loader.load();
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showLoginOverview() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/LoginScreen.fxml"));
			AnchorPane loginScreen = (AnchorPane) loader.load();

			// Define a overview no centro do root layout.
			rootLayout.setCenter(loginScreen);

			// D� ao controlador acesso � the main app.
			//UserRegisterScreenController controller = loader.getController();
	        //controller.setMainApp(this);
			
			DAO.getConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
