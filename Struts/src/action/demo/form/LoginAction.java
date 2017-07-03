package action.demo.form;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by 王宁 on 2017/6/29.
 */
public class LoginAction extends ActionSupport {

    public String execute() throws Exception {
 /*
        //使用ActionContext类获取
        ActionContext actionContext = ActionContext.getContext();//使用静态方法获取ActionContext对象
        Map<String,Object> map=actionContext.getParameters();//返回值为map集合   key为表单输入项name值，value为输入值
        Set<String> keys = map.keySet();
        for (String key :keys){
            Object[] obj = (Object[])map.get(key);//根据key得到value value为数组形式
            System.out.println(Arrays.toString(obj));
        }

       //使用ServletActionContext获取
       HttpServletRequest request = ServletActionContext.getRequest();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String email = request.getParameter("email");

        System.out.println(username);
*/
        //request域
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("req","reqValue");
        //session域
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("sess","sessValue");
        //ServletContext域
        ServletContext context  = ServletActionContext.getServletContext();
        context.setAttribute("context","contextValue");
        return SUCCESS;
    }


}
