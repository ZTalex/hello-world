package Datatype;

public class Order {
    public String ID;
    public String BuyerID;
    public String ProductID;
    public String Des;
    public int State;
    public MyCheckbox cb=new MyCheckbox();

    public Order(String ID, String buyerID, String productID, int state,String Des) {
        this.ID = ID;
        this.BuyerID = buyerID;
        this.ProductID = productID;
        this.State = state;
        this.Des=Des;
    }

    public Order() {
    }

}
