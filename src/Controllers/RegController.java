package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegController {

    @FXML
    private PasswordField ipw;//验证密码

    @FXML
    private TextField nc;//昵称

    @FXML
    private Button reg;//注册按钮

    @FXML
    private PasswordField pw;//密码

    @FXML
    private TextField id;//账号 不对应数据库里的ID

    @FXML
    void regist_event(ActionEvent event) {
        //此处编写注册逻辑 需要验证密码和确认密码是否匹配



        if(true){
            Alert alert =new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("注册成功");
            alert.show();
        }
        else {
            Alert alert =new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("信息错误，注册失败");
            alert.show();
        }
    }


}