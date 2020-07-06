package com.wondersgroup.cmxm.controller;

import com.wondersgroup.cmxm.Util.ExportUtils;
import com.wondersgroup.cmxm.dataobject.Question;
import com.wondersgroup.cmxm.dataobject.TestA;
import com.wondersgroup.cmxm.enums.ResultEnum;
import com.wondersgroup.cmxm.exception.CmxmException;
import com.wondersgroup.cmxm.service.QuestionService;
import com.wondersgroup.cmxm.service.TestAService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Created by Miracle_he
 * @Date 2020/4/28
 */

@Controller
public class ExportController {

    @Autowired
    private TestAService testAService;

    @RequestMapping("/XXXX")
    @ResponseBody
    public void exportBfhtresw(HttpSession session, HttpServletRequest request, HttpServletResponse response, String fileName) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Question question = new Question();
        if(session.getAttribute("dcid")!=""&&session.getAttribute("dcid")!=null) {
            Integer a1 = Integer.valueOf(session.getAttribute("dcid").toString());
            question.setLogin_id(a1);
        }
        if(session.getAttribute("dcProblemType")!=""&&session.getAttribute("dcProblemType")!=null) {
            Integer a2 = Integer.valueOf(session.getAttribute("dcProblemType").toString());
            question.setProblem_type(a2);
        }
        if(session.getAttribute("dcSolveStatus")!=""&&session.getAttribute("dcSolveStatus")!=null) {
        Integer a3= Integer.valueOf(session.getAttribute("dcSolveStatus").toString());
        question.setSolve_status(a3);
        }
        if(session.getAttribute("dccjsj1")!=""&&session.getAttribute("dccjsj1")!=null) {
            question.setCreate_time(simpleDateFormat.parse((String) session.getAttribute("dccjsj1")));
        }
        if(session.getAttribute("dccjsj2")!=""&&session.getAttribute("dccjsj2")!=null) {
            question.setCreate_time(simpleDateFormat.parse((String) session.getAttribute("dccjsj2")));
        }
        if(session.getAttribute("dcxgsj1")!=""&&session.getAttribute("dcxgsj1")!=null) {
            question.setCreate_time(simpleDateFormat.parse((String) session.getAttribute("dcxgsj1")));
        }
        if(session.getAttribute("dcxgsj2")!=""&&session.getAttribute("dcxgsj2")!=null) {
            question.setCreate_time(simpleDateFormat.parse((String) session.getAttribute("dcxgsj2")));
        }
        question.setQuestion_desc((String) session.getAttribute("dcQuestionDesc"));
        System.out.println(question.toString());
        if (question.getLogin_id() != null && question.getLogin_id() != 0) {


            List<TestA> bfhtreswList = testAService.exportBfhtreswExcel(question);
            // 创建工作簿
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 创建表
            HSSFSheet sheet = workbook.createSheet("问题备份明细数据");
            //文件名称
            fileName = "问题备份明细数据";
            // 创建行
            HSSFRow row = sheet.createRow(0);
            // 创建单元格样式
            HSSFCellStyle cellStyle = workbook.createCellStyle();
            // 表头
            String[] headTitle = {
                    "id", "问题描述", "归属人", "问题备注", "问题类型", "解决状态", "创建时间", "修改时间"};
            HSSFCell cell;
            // 设置表头
            for (int iHead = 0; iHead < headTitle.length; iHead++) {
                cell = row.createCell(iHead);
                cell.setCellValue(headTitle[iHead]);
                cell.setCellStyle(cellStyle);
            }
            // 设置表格内容
            for (int iBody = 0; iBody < bfhtreswList.size(); iBody++) {
                row = sheet.createRow(iBody + 1);
                TestA p = bfhtreswList.get(iBody);
                String[] posArray = new String[60];
                posArray[0] = String.valueOf(p.getId());
                posArray[1] = p.getQuestion_desc();
                posArray[2] = p.getLogin_user();
                posArray[3] = p.getQuestion_bz();
                posArray[4] = p.getProblem_name();
                posArray[5] = p.getSolve_name();
                posArray[6] = String.valueOf(p.getCreate_time());
                posArray[7] = String.valueOf(p.getUpdate_time());
                for (int iArray = 0; iArray < posArray.length; iArray++) {
                    row.createCell(iArray).setCellValue(posArray[iArray]);
                }
            }
            // 生成Excel文件
            ExportUtils.createFile(response, workbook, fileName);


        } else {
            throw new CmxmException(ResultEnum.ENTRY_ERROR);
        }

    }
}