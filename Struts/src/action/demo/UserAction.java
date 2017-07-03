package action.demo;

import Service.UserService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import entity.User;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王宁 on 2017/6/28.
 */
public class UserAction extends ActionSupport {
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
        UserService userService = new UserService();
        list = userService.findAll();
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("list",list);
        return "success";
    }
}
