package com.wondersgroup.cmxm.dataobject;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Created by Miracle_he
 * @Date 2020/4/17
 */

public class Question {

    public Question() {
    }

    private Integer id;

    private  String question_desc;

    private Integer solve_status;

    private Integer login_id;

    private Integer problem_type;

    private String question_bz;

    private Date create_time;

    private Date update_time;

    private  Date cjsj2;

    private Date xgsj2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion_desc() {
        return question_desc;
    }

    public void setQuestion_desc(String question_desc) {
        this.question_desc = question_desc;
    }

    public Integer getSolve_status() {
        return solve_status;
    }

    public void setSolve_status(Integer solve_status) {
        this.solve_status = solve_status;
    }

    public Integer getLogin_id() {
        return login_id;
    }

    public void setLogin_id(Integer login_id) {
        this.login_id = login_id;
    }

    public Integer getProblem_type() {
        return problem_type;
    }

    public void setProblem_type(Integer problem_type) {
        this.problem_type = problem_type;
    }

    public String getQuestion_bz() {
        return question_bz;
    }

    public void setQuestion_bz(String question_bz) {
        this.question_bz = question_bz;
    }

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Date getCjsj2() {
        return cjsj2;
    }

    public void setCjsj2(Date cjsj2) {
        this.cjsj2 = cjsj2;
    }

    public Date getXgsj2() {
        return xgsj2;
    }

    public void setXgsj2(Date xgsj2) {
        this.xgsj2 = xgsj2;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question_desc='" + question_desc + '\'' +
                ", solve_status=" + solve_status +
                ", login_id=" + login_id +
                ", problem_type=" + problem_type +
                ", question_bz='" + question_bz + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", cjsj2=" + cjsj2 +
                ", xgsj2=" + xgsj2 +
                '}';
    }
}
