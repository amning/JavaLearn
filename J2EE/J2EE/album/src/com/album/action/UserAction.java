package com.album.action;


import com.album.dao.ImageDao;
import com.album.dao.UserDao;
import com.album.domain.Image;
import com.album.domain.User;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 王宁 on 2017/6/12.
 */
public class UserAction extends HttpServlet {
    private static final long serialVersionUID=1L;

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out= response.getWriter();
        UserDao userDao = new UserDao();
        ImageDao imageDao = new ImageDao();
        Integer type=Integer.valueOf(request.getParameter("type"));
        if(type==1){
           String username=request.getParameter("username");
           String password=request.getParameter("password");
           String result=null;
            User user= null;
            if(username.isEmpty()){
                result="1";
            }else if(password.isEmpty()){
                result="2";
            }else if((user=userDao.getUser(username))==null){
                result="3";
            }else {
                if(!user.getPassWord().equals(password)){
                    result="4";
                }else {
                    request.getSession().setAttribute("user",user);
                    request.getSession().setAttribute("imageList",imageDao.getByUserId(user.getId()));
                    result="5";
                }
            }
            out.print(result);
        }else if(type==2){
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            String repassword=request.getParameter("repassword");
            String result=null;

            if(username.isEmpty()){
                result="1";
            }else if(password.isEmpty()){
                result="2";
            }else if(repassword.isEmpty()){
                result="3";
            }else if(!repassword.equals(password)){
                result="4";
            }else if(userDao.getUser(username)!=null){
                result = "5";
            }else {
                User user=new User(username,password);
                userDao.add(user);
                result="6";
            }
            out.print(result);
        }else if(type==3){
            request.getSession().invalidate();
        }
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        this.doGet(request,response);
    }

}
