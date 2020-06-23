package Datatype;

public class Order {
    public String ID;
    public String BuyerID;
    public String ProductID;
    public int State;
    public MyCheckbox cb=new MyCheckbox();

    public Order(String ID, String buyerID, String productID, int state) {
        this.ID = ID;
        BuyerID = buyerID;
        ProductID = productID;
        State = state;
    }

    public Order() {
    }

}
