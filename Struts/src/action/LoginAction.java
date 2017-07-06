package action;

import Service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import dao.UserDao;
import entity.User;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 王宁 on 2017/7/4.
 */
public class LoginAction extends ActionSupport{
    private User user;
    public String login(){
        //得到request对象
        HttpServletRequest request = ServletActionContext.getRequest();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //查询数据库判断用户名和密码是否正确
     if((null!=username)&&(null!=password)){
           User user = new UserService().getUser(username);
           if(null!=user){
               if(user.getPassword().equals(password)){
                  request.getSession().setAttribute("username",username);
                   return "login";
               }else return "login_error";
           }else return "login_error";
       }else return "login_error";
    }
      /* if(username.equals("aaa")&&(password.equals("122"))){
         request.getSession().setAttribute("username",username);
         return SUCCESS;
     }else return ERROR;
    }*/
}
