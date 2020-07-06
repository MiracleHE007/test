package com.wondersgroup.cmxm.controller;

import com.wondersgroup.cmxm.Util.SessionUtil;
import com.wondersgroup.cmxm.dataobject.ProblemType;
import com.wondersgroup.cmxm.dataobject.Question;
import com.wondersgroup.cmxm.dataobject.Solve;
import com.wondersgroup.cmxm.dataobject.TestA;
import com.wondersgroup.cmxm.repository.SolveRepository;
import com.wondersgroup.cmxm.service.ProblemService;
import com.wondersgroup.cmxm.service.QuestionService;
import com.wondersgroup.cmxm.service.TestAService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Created by Miracle_he
 * @Date 2020/4/20
 */
@Controller
@Slf4j
public class SelectController {



    @Autowired
    private TestAService testAService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private SolveRepository solveRepository;

    @Autowired
    private ProblemService problemService;




    @RequestMapping("/selAll")
    public String selALL(HttpSession session,Model model){
        session.removeAttribute("dcid");
        session.removeAttribute("dcProblemType");
        session.removeAttribute("dcSolveStatus");
        session.removeAttribute("dccjsj1");
        session.removeAttribute("dccjsj2");
        session.removeAttribute("dcxgsj1");
        session.removeAttribute("dcxgsj2");
        session.removeAttribute("dcQuestionDesc");

        Integer loginId= (Integer) session.getAttribute("loginId");
        System.out.println("LoginId==========="+loginId);
        List<TestA> testAList=testAService.selAll(loginId);
        model.addAttribute("testSize",testAList.size());
        model.addAttribute("testList",testAList);
        return "selAll";
    }


    @RequestMapping("/delete_sel")
    public String delete_sel(HttpSession session,Model model,String uid){
        Integer questionId= Integer.parseInt(uid);
        System.out.println("-------------------"+uid);
        Integer result=questionService.deleteForId(questionId);
        Integer loginId= (Integer) session.getAttribute("loginId");
        System.out.println("LoginId==========="+loginId);
        List<TestA> testAList=testAService.selAll(loginId);
        // session.setAttribute("testList",testAList);
        //System.out.println("session"+session.getAttribute("testList"));
        model.addAttribute("testList",testAList);
        model.addAttribute("testSize",testAList.size());
        return "selAll";
    }


    @RequestMapping("/selxiangxi")
    public String xiangxi(String uid,Model model){
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
        return "xiangxi";
    }



    @RequestMapping("/sel")
    public String seltiaojian(Model model){
        List<Solve> solveList =solveRepository.selSolve();
        List<ProblemType> problemTypeList=problemService.selProblem();
        model.addAttribute("solveList",solveList);
        model.addAttribute("problemList",problemTypeList);
        log.info("solveList=={}",solveList);
        log.info("problemList=={}",problemTypeList);
        return "sel";
    }

    @RequestMapping("/seltj")
    public String selTJ(HttpSession session,Model model,String problemType,String solveStatus,String desc,String cjsj1,String cjsj2,String xgsj1,String xgsj2) throws ParseException {
        session.removeAttribute("dcid");
        session.removeAttribute("dcProblemType");
        session.removeAttribute("dcSolveStatus");
        session.removeAttribute("dccjsj1");
        session.removeAttribute("dccjsj2");
        session.removeAttribute("dcxgsj1");
        session.removeAttribute("dcxgsj2");
        session.removeAttribute("dcQuestionDesc");
        log.info("拿到的session为 session=={}",session.getAttribute("loginId"));
           Integer login_id= (Integer) session.getAttribute("loginId");
            Question question = new Question();
            session.setAttribute("dcid",login_id);
            if(null!=login_id) {
                question.setLogin_id(login_id);
            if (problemType != null && problemType != "") {
                Integer a1 = Integer.parseInt(problemType);
                question.setProblem_type(a1);
                session.setAttribute("dcProblemType",a1);
            }else{
                session.setAttribute("dcProblemType","");
            }
            if (solveStatus != null && solveStatus != "") {
                Integer a2 = Integer.parseInt(solveStatus);
                question.setSolve_status(a2);
                session.setAttribute("dcSolveStatus",a2);
            }else{
                session.setAttribute("dcSolveStatus","");
            }
            if (cjsj1 != null && cjsj1 != "") {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                question.setCreate_time(simpleDateFormat.parse(cjsj1));
                session.setAttribute("dccjsj1",cjsj1);
            }else{
                session.setAttribute("dccjsj1","");
            }
            if (cjsj2 != null && cjsj2 != "") {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                question.setCjsj2(simpleDateFormat.parse(cjsj2));
                session.setAttribute("dccjsj2",simpleDateFormat.parse(cjsj2));
            }else{
                session.setAttribute("dccjsj2","");
            }
            if (xgsj1 != null && xgsj1 != "") {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                question.setUpdate_time(simpleDateFormat.parse(xgsj1));
                session.setAttribute("dcxgsj1",simpleDateFormat.parse(xgsj1));
            }else{
                session.setAttribute("dcxgsj1","");
            }
            if (xgsj2 != null && xgsj2 != "") {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                question.setXgsj2(simpleDateFormat.parse(xgsj2));
                session.setAttribute("dcxgsj2",simpleDateFormat.parse(xgsj2));
            }else{
                session.setAttribute("dcxgsj2","");
            }
            question.setQuestion_desc(desc);
            session.setAttribute("dcQuestionDesc",desc);
            System.out.println("写入question的值==" + question.toString());
            List<TestA> aa = testAService.selForXX(question);
            model.addAttribute("testSize", aa.size());
            model.addAttribute("testList", aa);
            return "selAll";
            }else{
                return "defail";
            }
    }

}
