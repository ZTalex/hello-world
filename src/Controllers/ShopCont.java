package Controllers;

import Datatype.Merchandise;
import Datatype.Order;
import UI.MerInfor;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

import javax.print.DocFlavor;

public class ShopCont {

    @FXML
    private TextField err;

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
    void flush_event(ActionEvent event) {    //刷新
        System.out.println("flush");
        //从数据库中获取最新的信息，先将之前的信息全部删除，在将当前的数据显示出来
        ObservableList<Merchandise> pdata1 = FXCollections.observableArrayList(
                new Merchandise("手机","233","上网",200)
        );
        pt.getItems().clear();
        pt.setItems(pdata1);
    }

    @FXML
    void upnew_event(ActionEvent event) {    //更新
        //商品更新和上架新商品都可以在一个界面完成
        MerInfor mi =new MerInfor();
        System.out.println("up_new");
    }

    @FXML
    void down_event(ActionEvent event) {     //下架
        ObservableList<Merchandise> list=pt.getItems();
        for(Merchandise o:list)
        {
            if(o.cb.isSelected())
            {
                System.out.println(o.ID);
                //选中行的ID，在数据库中将其删除，然后刷新。
                ObservableList<Merchandise> pdata2 = FXCollections.observableArrayList(
                        new Merchandise("手机","233","上网",200)
                );

            }
        }

        ObservableList<Merchandise> pdata1 = FXCollections.observableArrayList(
                new Merchandise("手机","233","上网",200)
        );
        pt.getItems().clear();
        pt.setItems(pdata1);


        System.out.println("dowm");
    }

    @FXML
    void chanpro_event(ActionEvent event) {  //修改信息
        MerInfor mi =new MerInfor();
        System.out.println("change");
    }

    @FXML
    void rec_event(ActionEvent event) {      //恢复
        err.setText("");
        //从数据库中获取信息，更新订单信息
        ObservableList<Order> odata1 = FXCollections.observableArrayList(
                new Order("8823","10023","230",1,"说明"),
                new Order("8222","10344","234",0,"我我")

        );
        ot.getItems().clear();
        ot.setItems(odata1);
        System.out.println("rec");
    }

    @FXML
    void search_event(ActionEvent event) {
        String database;
        database=err.getText();
        System.out.println(searchselect.getValue());
        //根据数据库语句找出数据库中相匹配的，下面表示查找的依据
        //从数据库中找出后，输出
        ObservableList<Order> odata1 = FXCollections.observableArrayList(
                new Order("8823","10023","230",1,"说明"),
                new Order("8222","10344","234",0,"我我")

        );
        ot.getItems().clear();
        ot.setItems(odata1);
    }
    @FXML
    void confirm_event(ActionEvent event) {
        //setstats为订单状态，根据订单号和结果，修改数据库中的结果，再更新
        ObservableList<Order> list=ot.getItems();
        for(Order o:list)
        {
            if(o.cb.isSelected())
            {
                System.out.println(o.ID);
                System.out.println(setstats.getValue());

            }
        }
        ObservableList<Order> odata1 = FXCollections.observableArrayList(
                new Order("8823","10023","230",1,"说明"),
                new Order("8222","10344","234",0,"我我")

        );
        ot.getItems().clear();
        ot.setItems(odata1);
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
                new Merchandise("牙刷","10086","可以用来刷牙",100),
                new Merchandise("手机","222","上网",200),
                new Merchandise("电视","133","看电视",3000)
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