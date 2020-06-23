package Controllers;

import Datatype.Merchandise;
import Datatype.Order;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Main_myordcont {

    @FXML
    private Button ret;//退货按钮

    @FXML
    private Button flush;//刷新按钮

    @FXML
    private TableColumn<Order, String > merName;

    @FXML
    private TableColumn<Order, String > orID;

    @FXML
    private TableColumn<Order, String > merID;

    @FXML
    private TableColumn<Order, CheckBox> check;

    @FXML
    private TableColumn<Order, Integer> state;

    @FXML
    private Button canc;//取消按钮

    @FXML
    private TableView<Order> ordlist;//列表

    @FXML
    void flush_event(ActionEvent event) {
        System.out.println("flush");
    }

    @FXML
    void canc_event(ActionEvent event) {
        check();
        System.out.println("canc");
    }

    @FXML
    void ret_event(ActionEvent event) {
        System.out.println("ret");
    }
    @FXML
    public void initialize(){
        //初始化订单列表示例
        ObservableList<Order> data = FXCollections.observableArrayList(
                new Order("8888","10086","520",1),
                new Order("8866","10016","321",0)
        );
        merName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().ID));
        orID.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().ID));
        merID.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().ProductID));
        state.setCellValueFactory(cellData -> new SimpleObjectProperty<Integer>(cellData.getValue().State));
        check.setCellValueFactory(cellData ->cellData.getValue().cb.getCheckBox());
        ordlist.setItems(data);

    }
    @FXML
    public void check()//选择框响应函数 需要时调用即可
    {
        ObservableList<Order> list=ordlist.getItems();
        for(Order o:list)
        {
            if(o.cb.isSelected())
            {
                System.out.println(o.ID);
            }
        }
    }
}
