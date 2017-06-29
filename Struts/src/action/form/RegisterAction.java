package action.form;

import com.opensymphony.xwork2.ActionSupport;
import entity.User;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 王宁 on 2017/6/29.
 */
public class RegisterAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
        //获取表单数据
        HttpServletRequest request = ServletActionContext.getRequest();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        //封装数据到实体类对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        System.out.println(user);
        return NONE;
    }
}
