package bean;

/**
 * Created by 王宁 on 2017/6/13.
 */
public class User {
    private int id;
    private String userName;
    private String passWord;
    private String address;
    public   User(){

    }
    public User(String userName,String passWord){
        this.userName=userName;
        this.passWord=passWord;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
