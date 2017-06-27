package many2many.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 王宁 on 2017/6/19.
 */
public class Role {
    private Integer rid;//角色id
    private String roleName;//角色名称
    private String roleMome;//角色描述

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleMome() {
        return roleMome;
    }

    public void setRoleMome(String roleMome) {
        this.roleMome = roleMome;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    private Set<User> userSet = new HashSet<User>();
}
