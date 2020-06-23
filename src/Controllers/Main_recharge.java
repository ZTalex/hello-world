package Controllers;

import UI.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Main_recharge {

    @FXML
    private Button confirm;

    @FXML
    private TextField money;

    @FXML
    private TextField id;
    @FXML
    void confirm_event(ActionEvent event) {

        System.out.println("confirm");
    }
    @FXML
    void initialize() {
        //在数据库中读取username对应ID到文本框 或者可以在MainInterController定义一个静态成员user，从中读ID

    }

}