package Controllers;

import UI.Main;
import UI.MainInterface;
import UI.Regist;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.Properties;

//此文件用于写关于登陆界面的控制程序
public class Controller {

    @FXML
    private AnchorPane lgwin;
    @FXML
    private Button lg;//登陆按钮
    @FXML
    private Button rg;//注册按钮
    @FXML
    private ImageView bg;
    @FXML
    private ImageView id;
    @FXML
    private ImageView pw;
    @FXML
    private javafx.scene.control.TextField idf;//用户名输入框
    @FXML
    private PasswordField pwf;//密码输入框
    @FXML
    private CheckBox remp;//记住账号密码
    @FXML
    private CheckBox autolg;//自动登陆

    @FXML
    void login_event(ActionEvent event) {//登陆点击监听
        String username =idf.getText();//接收用户名
        String password=pwf.getText();//接收密码

        if(autolg.isSelected()){
            Properties p = new Properties();
            InputStream in = Controller.class.getClassLoader().getResourceAsStream("resource/keyvalue");
            try {
                p.load(in);//
                in.close();
                p.setProperty("autologin", "true");
                FileOutputStream out = new FileOutputStream("src\\resource\\keyvalue");//输出流
                p.store(out, "test");//设置属性头，如不想设置，请把后面一个用""替换掉
                out.flush();//清空缓存，写入磁盘
                out.close();//关闭输出流
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            Properties p = new Properties();
            InputStream in = Controller.class.getClassLoader().getResourceAsStream("resource/keyvalue");
            try {
                p.load(in);//
                in.close();
                p.setProperty("autologin", "false");
                FileOutputStream out = new FileOutputStream("src\\resource\\keyvalue");//输出流
                p.store(out, "test");//设置属性头，如不想设置，请把后面一个用""替换掉
                out.flush();//清空缓存，写入磁盘
                out.close();//关闭输出流
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(remp.isSelected()) {//记住账号密码被选中
            Properties p = new Properties();
            InputStream in = Controller.class.getClassLoader().getResourceAsStream("resource/keyvalue");
            try {
                p.load(in);//
                in.close();
                p.setProperty("savenp", "true");
                p.setProperty("savedusername",username);
                p.setProperty("savedpassword",password);
                FileOutputStream out = new FileOutputStream("src\\resource\\keyvalue");//输出流
                p.store(out, "111");//设置属性头，如不想设置，请把后面一个用""替换掉
                out.flush();//清空缓存，写入磁盘
                out.close();//关闭输出流
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            Properties p = new Properties();
            InputStream in = Controller.class.getClassLoader().getResourceAsStream("resource/keyvalue");
            try {
                p.load(in);//
                in.close();
                p.setProperty("savedusername", "");//设置属性值，如不属性不存在新建
                p.setProperty("savedpassword", "");
                p.setProperty("savenp", "false");
                FileOutputStream out = new FileOutputStream("src\\resource\\keyvalue");//输出流
                p.store(out, "");//设置属性头，如不想设置，请把后面一个用""替换掉
                out.flush();//清空缓存，写入磁盘
                out.close();//关闭输出流
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Main.username=username;
//        Properties p = new Properties();
//        InputStream in = Controller.class.getClassLoader().getResourceAsStream("resource/keyvalue");
//        try {
//            p.load(in);//
//            in.close();
//            p.setProperty("username", username);//设置属性值，如不属性不存在新建
//            FileOutputStream out = new FileOutputStream("src\\resource\\keyvalue");//输出流
//            p.store(out, "");//设置属性头，如不想设置，请把后面一个用""替换掉
//            out.flush();//清空缓存，写入磁盘
//            out.close();//关闭输出流
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        //此处编辑登陆逻辑







//        Alert alert =new Alert(Alert.AlertType.INFORMATION);
//        alert.setContentText("hello");
//        alert.show();

        Stage stage = (Stage) lgwin.getScene().getWindow();//获得stage
        stage.close();//关闭窗口
        MainInterface mi =new MainInterface();
    }

    @FXML
    void re_event(ActionEvent event) {
        Regist re =new Regist();
    }
    @FXML
    public void initialize(){
        //初始化图片信息
        bg.setImage(new Image("resource/lg_bg.png"));
        bg.setPreserveRatio(false);
        bg.setFitWidth(550);
        bg.setFitHeight(164);
        id.setImage(new Image("resource/id.png"));
        id.setPreserveRatio(false);
        id.setFitWidth(34);
        id.setFitHeight(34);
        pw.setImage(new Image("resource/pw.png"));
        pw.setPreserveRatio(false);
        pw.setFitWidth(34);
        pw.setFitHeight(34);
        //记住账号密码逻辑
        Properties props = new Properties();
        InputStream is = Controller.class.getClassLoader().getResourceAsStream("resource/keyvalue");
        try {
            props.load(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        idf.setText(props.getProperty("savedusername"));
        pwf.setText(props.getProperty("savedpassword"));
        if (props.getProperty("savenp").equals("true")){
            remp.setSelected(true);
        }
        if (props.getProperty("autologin").equals("true")){
            autolg.setSelected(true);
            this.login_event(new ActionEvent());
        }

    }

}