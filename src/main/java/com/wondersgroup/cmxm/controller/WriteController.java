package com.wondersgroup.cmxm.controller;

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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Created by Miracle_he
 * @Date 2020/4/23
 */
@Controller
@Slf4j
public class WriteController {


    @Autowired
    private TestAService testAService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private SolveRepository solveRepository;

    @Autowired
    private ProblemService problemService;


    @RequestMapping("/ins")
    public String ins(Model model){
        List<Solve> solveList =solveRepository.selSolve();
        List<ProblemType> problemTypeList=problemService.selProblem();
        model.addAttribute("solveList",solveList);
        model.addAttribute("problemList",problemTypeList);
        log.info("solveList=={}",solveList);
        log.info("problemList=={}",problemTypeList);
        return "ins";
    }


    @RequestMapping("/insertQues")
    @ResponseBody
    public String insertQues(HttpSession session, String problemType, String solveStatus, String desc){
        Integer id= (Integer) session.getAttribute("loginId");
        Question question=new Question();
        question.setLogin_id(id);
        if (problemType != null && problemType != "") {
            Integer a1 = Integer.parseInt(problemType);
            question.setProblem_type(a1);
        }
        if (solveStatus != null && solveStatus != "") {
            Integer a2 = Integer.parseInt(solveStatus);
            question.setSolve_status(a2);
        }
        question.setQuestion_desc(desc);
        Integer result=questionService.insertQuestion(question);
        if(result==1){
            return "1";
        }else{
            return "2";
        }

    }
    @RequestMapping("/updatejj")
    public String updatejj(HttpSession session,Model model,String uid){
        Integer questionId= Integer.parseInt(uid);
        Integer result=questionService.updateQuestionId(questionId);
        Integer loginId= (Integer) session.getAttribute("loginId");
        System.out.println("LoginId==========="+loginId);
        List<TestA> testAList=testAService.selAll(loginId);
        // session.setAttribute("testList",testAList);
        //System.out.println("session"+session.getAttribute("testList"));
        model.addAttribute("testList",testAList);
        model.addAttribute("testSize",testAList.size());
        return "selAll";
    }




}
