package servlet;

import bean.User;
import dao.UserDAO;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 王宁 on 2017/4/27.
 */
public class UserLoginServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if((null!=name)&(null!=password)){
        User user = new UserDAO().getUser(name,password);
        if (null!=user){
            request.getSession().setAttribute("user",user);

            response.sendRedirect("/listProduct");
        }
        else
            response.sendRedirect("login.jsp");
        }else {
            response.sendRedirect("login.jsp");
        }
    }
}
