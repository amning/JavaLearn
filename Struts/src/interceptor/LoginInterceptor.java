package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 王宁 on 2017/7/4.
 */
public class LoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        //得到session
        HttpServletRequest request = ServletActionContext.getRequest();
        Object obj = request.getSession().getAttribute("username");
        if (obj!=null){
            //登录状态
            //放行之后执行action
            return actionInvocation.invoke();
        }else {
            //未登录状态，不执行aciton方法，返回登录界面
            return "login";
        }
    }
}
