package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainInterface extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public MainInterface() {
        Stage stage = new Stage();
        try {
            start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../fxmls/MainInter.fxml"));
        primaryStage.setTitle("主界面");
        primaryStage.setScene(new Scene(root, 1334, 747));
        primaryStage.show();
    }
}
