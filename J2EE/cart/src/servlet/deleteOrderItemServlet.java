package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.OrderItem;

public class deleteOrderItemServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int pid = Integer.parseInt(request.getParameter("pid"));//获取要删除的商品id

        List<OrderItem> ois = (List<OrderItem>) request.getSession().getAttribute("ois");//订单产品列表
        List<OrderItem> ois4Delete =new ArrayList<>();//创建删除产品的list
        if(null!=ois){
            for (OrderItem io : ois) {
                if(io.getProduct().getId()==pid){
                    ois4Delete.add(io);//根据产品id将要删产品添加至删除闪屏的list
                }
            }
        }
        ois.removeAll(ois4Delete);//删除
        response.sendRedirect("/listOrderItem");
    }
}