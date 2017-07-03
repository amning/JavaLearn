package action;

import Service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王宁 on 2017/7/3.
 */
public class UserAction extends ActionSupport{
   /* private List<User> list;
    public List<User> getList() {
        return list;
    }
      @Override
    public String execute() throws Exception {
        UserService userService = new UserService();
        list = userService.findAll();
        return "list";
    }*/
   private User user1 = new User();
    private User user2 = new User();
    private List<User> list = new ArrayList<User>();
    /* public User getUser() {
         return user1;
     } */
    public List<User> getList() {
        return list;
    }

    public String execute() throws Exception {
        user1.setUsername("徐宁");
        user1.setPassword("233");
        user1.setEmail("amning@qq.com");
        user2.setEmail("ren@qq.com");
        user2.setUsername("任磊");
        user2.setPassword("250");
        list.add(user1);
        list.add(user2);
        return "success";
    }
}
