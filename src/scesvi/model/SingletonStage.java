package scesvi.model;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SingletonStage {

    private static SingletonStage singStage = null;
    
    private Stage stage;

    private SingletonStage(Stage stage) {
        this.stage = stage;
    }

    public static SingletonStage instance(Stage stage) {
        if (singStage == null) {
            singStage = new SingletonStage(stage);
        }
        return singStage;
    }

    public Stage getStage() {
        return this.stage;
    }

    public void loadNewStage(Parent fxml) {
        if (stage != null) {
            Parent root = fxml;
            Scene scene = new Scene(root);
            stage.setScene(scene);
        }
    }
}
