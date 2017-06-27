package many2many.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 王宁 on 2017/6/19.
 */
public class User {
    private int uid;
    private String userName;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    private String userPassword;

    private Set<Role> roleSet=new HashSet<Role>();
}
