package servlet;

import bean.User;
import dao.UserDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class RegisteUserServlet extends HttpServlet{

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        User u = new User();
        String name = request.getParameter("name");
        String password =request.getParameter("password");
        if((null!=name)&(null!=password)){
        u.setName(name);
        u.setPassword(password);
        new UserDAO().addUser(u);
        response.sendRedirect("login.jsp");
        }
        else {
            response.sendRedirect("login.jsp");
        }
    }
}