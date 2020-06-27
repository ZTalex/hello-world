package Controllers;

import Datatype.Merchandise;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MerinfoCon {


    @FXML
    private AnchorPane abc;

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
        String Name,describle,Price1; //商品名称和商品描述和价格
        double Price;   //商品价格
        Name=name.getText();
        Price1=price.getText();
        describle=des.getText();
        Price=Double.valueOf(Price1);
        //将新生成的信息传入到数据库
        //先比较名称，如果数据库中有相同的名称的，则是更新数据，否则为添加数据
        new Merchandise(Name,"233",describle,200);
        try{
            Stage stage = (Stage) abc.getScene().getWindow();
            stage.hide();
        }catch (Exception e){
            System.out.println(e.toString());
        }



    }
    @FXML
    void initialize() {
        //如果是上架新商品，则自动生成ID 其余空白

        //如果是更改商品信息，则自动填上所有信息，只需要更改后点击提交即可



    }

}
