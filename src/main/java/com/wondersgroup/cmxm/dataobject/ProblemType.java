package com.wondersgroup.cmxm.dataobject;

import lombok.Data;

import java.util.Date;

/**
 * @Created by Miracle_he
 * @Date 2020/4/17
 */
@Data
public class ProblemType {
    public ProblemType() {
    }


    private Integer id;

    private String problem_name;

    private Integer problem_type;


    private Date create_time;


    private Date update_time;

    public ProblemType(String problemName,Integer problemType) {
        this.problem_name=problemName;
        this.problem_type=problemType;
    }

}
