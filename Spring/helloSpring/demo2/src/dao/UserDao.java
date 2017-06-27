package dao;

import org.springframework.stereotype.Component;

/**
 * Created by 王宁 on 2017/6/6.
 */
@Component(value = "dao")
public class UserDao {
    public void add(){
        System.out.println("dao...");
    }
}
