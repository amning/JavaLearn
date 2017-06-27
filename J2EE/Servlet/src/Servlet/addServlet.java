package Servlet;

import DAO.HeroDAO;
import Bean.Hero;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 王宁 on 2017/4/21.
 */
public class addServlet extends HttpServlet{


         protected void service(HttpServletRequest request, HttpServletResponse response)
                 throws ServletException, IOException {

             request.setCharacterEncoding("UTF-8");

             Hero hero = new Hero();
             hero.setName(request.getParameter("name"));
             hero.setHp(Float.parseFloat(request.getParameter("hp")));
             hero.setDamage(Integer.parseInt(request.getParameter("damage")));

             new HeroDAO().add(hero);

             response.sendRedirect("/listHero");

         }
        }


