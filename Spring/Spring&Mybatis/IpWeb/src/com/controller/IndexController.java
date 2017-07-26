package com.controller;

import com.page.PageParam;
import com.service.TableIpService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 王宁 on 2017/7/24.
 */
@Controller
    public class IndexController {
    @Resource
    TableIpService tableIpService ;//spring自动依赖注入
   PageParam pageParam =new PageParam();
    @RequestMapping(value = "index")
    public String helloWorld(HttpServletRequest request){
        String currPageStr = request.getParameter("page");
        int currPage = 1;
        try{
            currPage = Integer.parseInt(currPageStr);
        }catch (Exception e ){
            e.printStackTrace();
        }
        int rowCount = tableIpService.getRowCount();

        pageParam.setRowCount(rowCount);
        if(pageParam.getTotalPage()<currPage){
            currPage = pageParam.getTotalPage();
        }
        pageParam.setCurrPage(currPage);
        pageParam = tableIpService.getIpListByPage(pageParam);
        request.setAttribute("pageParam",pageParam);
        return "index";
    }
}
