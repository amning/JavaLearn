package bean;

import org.springframework.stereotype.Component;

/**
 * Created by 王宁 on 2017/6/6.
 */

public class User {
   private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
