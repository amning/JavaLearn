package bean;

import org.springframework.stereotype.Component;

/**
 * Created by 王宁 on 2017/6/6.
 */
@Component(value = "user")
public class User {
    public void add(){
        System.out.println("user__add...");
    }
}
