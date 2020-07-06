package com.wondersgroup.cmxm.controller;

import com.wondersgroup.cmxm.dataobject.Login;
import com.wondersgroup.cmxm.dataobject.Solve;
import com.wondersgroup.cmxm.enums.ResultEnum;
import com.wondersgroup.cmxm.exception.CmxmException;
import com.wondersgroup.cmxm.repository.LoginRepository;
import com.wondersgroup.cmxm.service.LoginService;
import com.wondersgroup.cmxm.service.SolveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.*;

/**
 * @Created by Miracle_he
 * @Date 2020/4/12
 */
@Controller
@Transactional
public class loginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private SolveService solveService;

    @PostMapping( "/loginC" )
    @ResponseBody
    private String login(String loginuser, String loginpassword, HttpSession session) {
        String password;
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(loginpassword.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            password = new BigInteger(1, md.digest()).toString(16);
            System.out.println("md5=" + password);
        } catch (Exception e) {
            throw new CmxmException(ResultEnum.MD5_ERROR);
        }
        System.out.println(loginpassword + loginuser);
        Login result = loginService.findOneByLoginUserAndLoginPasswordAndLoginStatus(loginuser, password, 1);
        if (result != null) {
            String userName = result.getLogin_user();
            System.out.println(userName);
            session.setAttribute("loginId", result.getLogin_id());
            session.setAttribute("loginName", result.getLogin_user());
            return "1";
        } else {
            return "用户名或密码有误";
        }

    }

    @RequestMapping( "/registL" )
    @ResponseBody
    private String regist(String loginuser,String loginpassword, HttpSession session) throws Exception {
        //@RequestParam Hashtable login
        String password;
//        System.out.println(login.get("loginuser") + "拿到的map");
//        return "";
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(loginpassword.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
             password =new BigInteger(1, md.digest()).toString(16);
            System.out.println("md5="+password);
        } catch (Exception e) {
            throw new CmxmException(ResultEnum.MD5_ERROR);
        }
        Login lg=new Login();
        lg.setLogin_user(loginuser);
        lg.setLogin_password(password);
        lg.setLogin_status(1);
        Integer result=loginService.findLoginUser(lg);
        if(result!=null){
            return "该用户名已注册";
        }else{
            Integer aa=loginService.save(loginuser,password,1);
            if(aa==1){
                return "1";
            }else{
                return "注册失败";
            }
        }

    }




}
