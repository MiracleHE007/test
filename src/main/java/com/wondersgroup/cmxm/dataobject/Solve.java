package com.wondersgroup.cmxm.dataobject;

import lombok.Data;

import java.util.Date;

/**
 * @Created by Miracle_he
 * @Date 2020/4/17
 * 解决状态表
 */
@Data

public class Solve {
    public Solve() {
    }

    private Integer id;

    private String solve_name;

    private Integer solve_status;


    private Date create_time;

    private Date update_time;

    public Solve(String solveName,Integer solveStatus) {
        this.solve_name=solveName;
        this.solve_status=solveStatus;
    }
}
