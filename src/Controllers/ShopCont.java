package Controllers;

import Datatype.Merchandise;
import Datatype.Order;
import UI.MerInfor;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.print.DocFlavor;

public class ShopCont {

    @FXML
    private Button upnew;//上架

    @FXML
    private TableColumn<Merchandise, Integer> psell;//销量

    @FXML
    private Button recover;//恢复

    @FXML
    private TableColumn<Order, Integer> os;//订单状态

    @FXML
    private ChoiceBox<String> setstats;//设置状态

    @FXML
    private Button changeproduct;//修改商品信息按钮

    @FXML
    private TableColumn<Merchandise, String> pname;//商品名称

    @FXML
    private TableColumn<Merchandise, Double> pprice;//价格

    @FXML
    private TableColumn<Order, String> opid;//订单中商品ID

    @FXML
    private TableColumn<Merchandise, String> pid;//商品ID

    @FXML
    private TableColumn<Order, String> oid;//订单ID

    @FXML
    private Button down;//下架

    @FXML
    private Button confirm;//确定

    @FXML
    private Button search;//搜索

    @FXML
    private Button flush;//刷新

    @FXML
    private TableColumn<Order, CheckBox> ocheck;//订单的选择

    @FXML
    private ChoiceBox<String> searchselect;//复选项

    @FXML
    private TableColumn<Order, String> od;//订单说明

    @FXML
    private TableColumn<Merchandise, String> pdes;//商品说明

    @FXML
    private TableColumn<Merchandise, CheckBox> pcheck;//商品的选择
    @FXML
    private TableView<Merchandise> pt;
    @FXML
    private TableView<Order> ot;
    @FXML
    private TableColumn<Order, String> obid;//订单买家ID
    @FXML
    void flush_event(ActionEvent event) {
        System.out.println("flush");
    }

    @FXML
    void upnew_event(ActionEvent event) {
        //商品更新和上架新商品都可以在一个界面完成
        MerInfor mi =new MerInfor();
        System.out.println("up_new");
    }

    @FXML
    void down_event(ActionEvent event) {
        System.out.println("dowm");
    }

    @FXML
    void chanpro_event(ActionEvent event) {
        MerInfor mi =new MerInfor();
        System.out.println("change");
    }

    @FXML
    void rec_event(ActionEvent event) {
        System.out.println("rec");
    }

    @FXML
    void confirm_event(ActionEvent event) {
        System.out.println("confirm");
    }
    @FXML
    public void initialize(){
        //初始化选择框
        ObservableList<String> search = FXCollections.observableArrayList("根据订单编号","根据订单状态");
        searchselect.setItems(search);
        //初始化设置选择框
        ObservableList<String> set = FXCollections.observableArrayList("未处理","已发货","已退货","已完成");
        setstats.setItems(set);
        //初始化订单列表示例
        ObservableList<Order> odata = FXCollections.observableArrayList(
                new Order("8888","10086","520",1,"说明"),
                new Order("8866","10016","321",0,"说明")
        );
        oid.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().ID));
        obid.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().BuyerID));
        opid.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().ProductID));
        od.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().Des));
        os.setCellValueFactory(cellData -> new SimpleObjectProperty<Integer>(cellData.getValue().State));
        ocheck.setCellValueFactory(cellData ->cellData.getValue().cb.getCheckBox());
        ot.setItems(odata);

        //初始化商品列表
        ObservableList<Merchandise> pdata = FXCollections.observableArrayList(
                new Merchandise("牙刷","10086","可以用来刷牙",100)
        );
        pname.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().name));
        pid.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().ID));
        pdes.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().des));
        pprice.setCellValueFactory(cellData -> new SimpleObjectProperty<Double>(cellData.getValue().price));
        pcheck.setCellValueFactory(cellData ->cellData.getValue().cb.getCheckBox());
        pt.setItems(pdata);
    }

    @FXML
    public void ocheck()//订单选择框响应函数 需要时调用即可
    {
        ObservableList<Order> list=ot.getItems();
        for(Order o:list)
        {
            if(o.cb.isSelected())
            {
                System.out.println(o.ID);
            }
        }
    }
    @FXML
    public void pcheck()//商品选择框响应函数 需要时调用即可
    {
        ObservableList<Merchandise> list=pt.getItems();
        for(Merchandise o:list)
        {
            if(o.cb.isSelected())
            {
                System.out.println(o.ID);
            }
        }
    }
}