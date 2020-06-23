package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MerinfoCon {

    @FXML
    private TextArea des;

    @FXML
    private TextField price;

    @FXML
    private TextField name;

    @FXML
    private Button commit;
    @FXML
    private TextField ID;

    @FXML
    void commit_event(ActionEvent event) {

    }
    @FXML
    void initialize() {
        //如果是上架新商品，则自动生成ID 其余空白


        //如果是更改商品信息，则自动填上所有信息，只需要更改后点击提交即可



    }

}
