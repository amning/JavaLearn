package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 王宁 on 2017/7/24.
 */
@Controller
public class FetchController {
    @RequestMapping(value = "fetch")
    public String helloWorld(){
        return "fetch";
    }
    @RequestMapping(value = "getip")
    public String getIp(){
        return "ip";
    }
}
