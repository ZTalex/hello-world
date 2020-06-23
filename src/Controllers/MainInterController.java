package Controllers;
import Datatype.Merchandise;
import Datatype.user;
import UI.Main;
import UI.main_info;
import UI.main_myorder;
import UI.main_recharge;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;

import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class MainInterController {

    @FXML
    private TableView<Merchandise> hotlist;
    @FXML
    private TableView<Merchandise> mainlist;
    @FXML
    private TableColumn<Merchandise, CheckBox> check;
    @FXML
    private TableColumn<Merchandise, String> dex;
    @FXML
    private TableColumn<Merchandise, Double> price;
    @FXML
    private TableColumn<Merchandise, String> name;
    @FXML
    private TableColumn<Merchandise, String> id;
    @FXML
    private Button buy;//购买按钮
    @FXML
    private Button clear;//清除按钮
    @FXML
    private TextField minp;//最小价格
    @FXML
    private Button search;//搜索商品按钮
    @FXML
    private Label hellowords;//欢迎语
    @FXML
    private TextField keyword;//关键字
    @FXML
    private TextField maxp;//最大价格
    @FXML
    private Button flash;//刷新按钮
    @FXML
    private Button myorder;//我的订单
    @FXML
    private Button recharge;//充值
    @FXML
    private Button infor;//个人信息
    @FXML
    void infor_event(ActionEvent event) {

        main_info mi= new main_info();
        System.out.println("infor");
    }

    @FXML
    void myorder_event(ActionEvent event) {
        main_myorder mo =new main_myorder();
        System.out.println("myorder");
    }


    @FXML
    void recharge_event(ActionEvent event) {
        main_recharge mr=new main_recharge();
        System.out.println("recharge");
    }


    @FXML
    void serach_event(ActionEvent event) {
        System.out.println("serach");
    }

    @FXML
    void clear_event(ActionEvent event) {
        System.out.println("clear");
    }

    @FXML
    void buy_envent(ActionEvent event) {
        check();
        System.out.println("buy");
    }

    @FXML
    void flush_event(ActionEvent event) {
        System.out.println("flush");
    }
    @FXML
    public void initialize() throws IOException {
        //初始化商品列表示例
        ObservableList<Merchandise> data = FXCollections.observableArrayList(
                new Merchandise("牙刷","10086","可以用来刷牙",100)
        );
        name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().name));
        id.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().ID));
        dex.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().des));
        price.setCellValueFactory(cellData -> new SimpleObjectProperty<Double>(cellData.getValue().price));
        check.setCellValueFactory(cellData ->cellData.getValue().cb.getCheckBox());
        mainlist.setItems(data);
        //菜单按钮添加事件
        infor.setOnMouseEntered(e -> {
            infor.setStyle("-fx-background-color: gray");
        });
        infor.setOnMouseExited(e -> {
            infor.setStyle("-fx-background-color: white");
        });
        myorder.setOnMouseEntered(e -> {
            myorder.setStyle("-fx-background-color: gray");
        });
        myorder.setOnMouseExited(e -> {
            myorder.setStyle("-fx-background-color: white");
        });
        recharge.setOnMouseEntered(e -> {
            recharge.setStyle("-fx-background-color: gray");
        });
        recharge.setOnMouseExited(e -> {
            recharge.setStyle("-fx-background-color: white");
        });

        //初始化热榜



        //初始化商列表


        //初始化欢迎语
        hellowords.setText("欢迎您："+ Main.username);
    }
    @FXML
    public void check()//选择框响应函数 需要时调用即可
    {
        ObservableList<Merchandise> list=mainlist.getItems();
        for(Merchandise o:list)
        {
            if(o.cb.isSelected())
            {
                System.out.println(o.name);
            }
        }
    }
}

