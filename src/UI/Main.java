package UI;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.net.URL;

public class Main extends Application {

    public static String username;
    @Override
    public void start(Stage primaryStage) throws Exception{
        URL resource = getClass().getResource("../fxmls/login.fxml");
        Parent root = FXMLLoader.load(resource);
        primaryStage.setTitle("登陆");
        primaryStage.setScene(new Scene(root, 550, 370));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
