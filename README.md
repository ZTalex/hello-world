
# JavaFx

前端使用javaFX

所有的编程都在目录src下

每个界面由三个文件组成：

Controller：负责事件处理

main：负责启动界面

fxml文件：记录界面样式

基本所有按钮的事件处理我都已经把函数写在相应的Controller类中了
所以你们只需要去填就可以了

#说明
UI ：保存各个界面的main  
Main:登陆界面、main_info:主界面的个人信息窗口、main_myorder：主界面的订单信息窗口、main_recharge：主界面的充值窗口、MainInterface:主界面、Regist:注册界面、Shop：商家端界面、MerInfor：商家端界面中商品信息页

resource:保存一些资源文件，其中有个属性文件keyvalue，可以用来保存一些必要的字段，比如关于数据库的

fxmls：保存所有的界面文件

Datatype：保存数据结构，里面的类我只写了构造方法，如果需要别的方法要自己添加

Controllers:保存所有的界面控制器



#BUG
存在一个当前无法解决的bug，设置自动登陆后，启动登陆程序，自动登录后登陆程序窗口无法自动关闭，需要手动关闭

