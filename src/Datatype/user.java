package Datatype;

public class user {
    public String username;
    public String userID;
    public String account;

    //定义了三个构造函数满足需要
    public user(String username, String userID, String account) {
        this.username = username;
        this.userID = userID;
        this.account = account;
    }

    public user(String username) {
        this.username = username;
    }
    public user() {

    }
}
