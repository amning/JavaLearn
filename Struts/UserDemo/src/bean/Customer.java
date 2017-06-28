package bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 王宁 on 2017/6/17.
 */
public class Customer {
    private Integer cid;
    private String custName;
    private String custLeve1;
    private String custSource;
    private String custPhone;
    private String custMobile;


    //客户实体类里面表示多个联系人，一个客户有多个联系人
    //使用集合表示多的数据----hibernate中使用set集合（无序，无重复集合）
    private Set<Manager> managers= new HashSet<Manager>();

    public Set<Manager> getManagers() {
        return managers;
    }

    public void setManagers(Set<Manager> managers) {
        this.managers = managers;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustLeve1() {
        return custLeve1;
    }

    public void setCustLeve1(String custLeve1) {
        this.custLeve1 = custLeve1;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }
}
