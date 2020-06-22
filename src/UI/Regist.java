package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Regist extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public Regist() {
        Stage stage = new Stage();
        try {
            start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("regist.fxml"));
        primaryStage.setTitle("注册");
        primaryStage.setScene(new Scene(root, 462, 391));
        primaryStage.show();
    }


}
