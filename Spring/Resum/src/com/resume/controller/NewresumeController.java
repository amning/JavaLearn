package com.resume.controller;

import com.resume.model.Basic;
import com.resume.model.Educational;
import com.resume.model.User;
import com.resume.model.Work;
import com.resume.service.NewResumeService;
import com.resume.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 王宁 on 2017/7/26.
 */
@Controller
public class NewresumeController {
    @Autowired
    public NewResumeService newResumeService;
    @RequestMapping("/basic")
    public String insertbasic(Basic basic, HttpServletRequest request,HttpSession session) {
        int userid = Integer.parseInt(request.getParameter("Userid"));
        basic.setUserId(userid);
        session.setAttribute("loginuser",userid);
        try{
            newResumeService.insertbasic(basic);
            return "Educational";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }
    /*
     *  添加教育信息
    */
    @RequestMapping("/addEducation")
        public String addEducation(Educational educational,HttpServletRequest request,HttpSession session){
        int userid = Integer.parseInt(request.getParameter("Userid"));
        educational.setUserId(userid);
        session.setAttribute("loginuser",userid);
        try{
            newResumeService.addEducational(educational);
            return "addEsuccess";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        }
        @RequestMapping("/addWork")
    public String addWork(Work work,HttpServletRequest request,HttpSession session){
            int userid = Integer.parseInt(request.getParameter("Userid"));
            work.setUserId(userid);
            session.setAttribute("loginuser",userid);
            try {
                newResumeService.addWork(work);
                return "addWsuccess";
            }catch (Exception e){
                e.printStackTrace();
                return "error";
            }
        }
    @RequestMapping("/addIntroduce")
    public String addIntroduce(Basic basic,HttpServletRequest request,HttpSession session){
        int userid = Integer.parseInt(request.getParameter("Userid"));
        basic.setUserId(userid);
        session.setAttribute("loginuser",userid);
        try{
            newResumeService.addIntroduce(basic);
            return "addIsuccess";
        }catch (Exception e){
            System.out.println(e);
            return "error";
        }
    }
    @RequestMapping("/download")
    public String preview(HttpServletRequest request,HttpSession session){
        int userid = Integer.parseInt(request.getParameter("Userid"));
        session.setAttribute("loginuser",userid);
        try {
            List<Basic> basics = newResumeService.selectBasic(userid);
            List<Educational> educationals =newResumeService.selectEducation(userid);
            List<Work> works = newResumeService.selectWork(userid);
            /* 调用工具类，根据模板ftl文件生成word文档
            WordGenerator wordGenerator = new WordGenerator();
            wordGenerator.createDoc(basic_info, educational_info,work_info);*/
            return "over";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }
}
