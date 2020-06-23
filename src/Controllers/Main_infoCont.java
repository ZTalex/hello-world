package Controllers;

import UI.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Main_infoCont {

    @FXML
    private TextField nickname;

    @FXML
    private Button save;

    @FXML
    private TextField id;

    @FXML
    private Label account;

    @FXML
    private TextField username;

    @FXML
    void save_event(ActionEvent event) {//保存逻辑

    }
    @FXML
    void initialize() {//初始化
        username.setText(Main.username);
        //根据username从数据库中读数据显示到各文本框

    }

}