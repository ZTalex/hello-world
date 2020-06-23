package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Shop extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmls/shop.fxml"));
        primaryStage.setTitle("商家端");
        primaryStage.setScene(new Scene(root, 1035, 665));
        primaryStage.show();
    }
}
