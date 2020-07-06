package com.wondersgroup.cmxm.dataobject;

import lombok.Data;

import java.util.Date;

/**
 * @Created by Miracle_he
 * @Date 2020/4/11
 */

@Data
public class Login {

    public Login() {
    }

    private Integer login_id;

    private String login_user;

    private String login_password;

    private Integer login_status;


    private Date create_time;

    private Date update_time;

    public Login(String loginUser, String loginPassword, Integer loginStatus) {
        this.login_password=loginPassword;
        this.login_user=loginUser;
        this.login_status=loginStatus;
    }


}
