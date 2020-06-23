package Datatype;

import Datatype.MyCheckbox;

public class Merchandise {//商品数据类
    public String name;
    public String ID;
    public String des;
    public double price;
    public MyCheckbox cb=new MyCheckbox();
    public Merchandise(String name,String ID,String des,double price)
    {
        this.name=name;
        this.ID=ID;
        this.des=des;
        this.price=price;
    }
}
