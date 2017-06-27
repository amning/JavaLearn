package one2many.bean;

/**
 * Created by 王宁 on 2017/6/17.
 */
public class Manager {
    private Integer mid;
    private String mName;
    private String mGender;
    private String mPhone;

    //在联系人实体类里面表示所述客户，一个联系人只能属于一个客户
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getMid() {

        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmGender() {
        return mGender;
    }

    public void setmGender(String mGender) {
        this.mGender = mGender;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }
}
