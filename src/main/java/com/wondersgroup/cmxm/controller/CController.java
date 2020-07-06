package com.wondersgroup.cmxm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Created by Miracle_he
 * @Date 2020/4/16
 * 专门用来跳转的controller
 */
@Controller
public class CController {

    @RequestMapping({"/","/login"})
    private String system(){
        System.out.println("进入系统");
        return "login";
    }

//    @RequestMapping("/tzindex")
//    public String tzindex(HttpSession session){
//        System.out.println(session.getAttribute("loginName"));
//        return "index";
//    }

    @RequestMapping("/tzregist")
    public String  tzregist(){
        return "regist";
    }

    //"selAll"访问selALl的话有两个咋办
    @RequestMapping("/{path}")
    public String toPage(@PathVariable String path){
        System.out.println("path===="+path);
        return path;
    }
}
