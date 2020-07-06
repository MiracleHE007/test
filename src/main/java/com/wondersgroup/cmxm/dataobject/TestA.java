package com.wondersgroup.cmxm.dataobject;

import lombok.Data;

import java.util.Date;

/**
 * @Created by Miracle_he
 * @Date 2020/4/18
 */

@Data
public class TestA {

    public TestA() {
    }

    private Integer id;

    private  String question_desc;

    private String problem_name;

    private String solve_name;

    private String login_user;

    private String question_bz;

    private Date create_time;

    private Date update_time;


}
