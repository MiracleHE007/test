package com.wondersgroup.cmxm.controller;

import com.wondersgroup.cmxm.dataobject.Login;
import com.wondersgroup.cmxm.dataobject.TestA;
import com.wondersgroup.cmxm.enums.ResultEnum;
import com.wondersgroup.cmxm.exception.CmxmException;
import com.wondersgroup.cmxm.service.LoginService;
import com.wondersgroup.cmxm.service.QuestionService;
import com.wondersgroup.cmxm.service.SolveService;
import com.wondersgroup.cmxm.service.TestAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

/**
 * @Created by Miracle_he
 * @Date 2020/4/27
 */
@Controller
public class UpdateConntroller {
    @Autowired
    private LoginService loginService;

    @Autowired
    private SolveService solveService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private TestAService testAService;


    @RequestMapping("updateP")
    @ResponseBody
    private String updatePassword(String loginpassword, String loginpassword1, HttpSession session) throws Exception {
        String password;
        String password1;
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
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(loginpassword1.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            password1 = new BigInteger(1, md.digest()).toString(16);
            System.out.println("md5=" + password1);
        } catch (Exception e) {
            throw new CmxmException(ResultEnum.MD5_ERROR);
        }
        Integer id= (Integer) session.getAttribute("loginId");
        Integer result1=loginService.findPassword(id,password,1);
        if(result1!=null){
            System.out.println("茶油此人");
            Integer result2=loginService.updatePassword(id,password1,1);
            if(result2!=null){
                return "1";
            }else{
                return "修改失败";
            }
        }else{
            return "原密码不正确或此人已注销，修改失败";
        }


    }

    /**
     * 添加备注
     */
    @RequestMapping("/inBZ")
    @ResponseBody
    public String inbz(HttpSession session, Model model,String questionId,String questionBz){
        System.out.println("question_id=="+questionId);
        Integer question_id=Integer.parseInt(questionId);
        System.out.println("question_id=="+question_id);

        Integer result1=questionService.inserBz(question_id,questionBz);
        List<TestA> aa=testAService.selxiangxi(question_id);
        for(TestA result:aa) {
            model.addAttribute("question_id", result.getId());
            model.addAttribute("question_desc", result.getQuestion_desc());
            model.addAttribute("problem_name", result.getProblem_name());
            model.addAttribute("solve_name", result.getSolve_name());
            model.addAttribute("login_user", result.getLogin_user());
            model.addAttribute("question_bz", result.getQuestion_bz());
            model.addAttribute("create_time", result.getCreate_time());
            model.addAttribute("update_time", result.getUpdate_time());
            System.out.println(result.toString());
        }
        return "1";

    }


    @RequestMapping("tjbz")
    public String tjbz(String uid,Model model){
    Integer questionId= Integer.parseInt(uid);
        System.out.println("拿到的id为-------------------"+questionId);
    List<TestA> aa=testAService.selxiangxi(questionId);
        for(TestA result:aa) {
        model.addAttribute("question_id", result.getId());
        model.addAttribute("question_desc", result.getQuestion_desc());
        model.addAttribute("problem_name", result.getProblem_name());
        model.addAttribute("solve_name", result.getSolve_name());
        model.addAttribute("login_user", result.getLogin_user());
        model.addAttribute("question_bz", result.getQuestion_bz());
        model.addAttribute("create_time", result.getCreate_time());
        model.addAttribute("update_time", result.getUpdate_time());
        System.out.println(result.toString());
    }
        return "insertBZ";
    }
}
