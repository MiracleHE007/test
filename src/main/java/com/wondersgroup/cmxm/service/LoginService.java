package com.wondersgroup.cmxm.service;

import com.wondersgroup.cmxm.dataobject.Login;

import java.util.List;

/**
 * @Created by Miracle_he
 * @Date 2020/4/20
 */
public interface LoginService {

    Login findOneByLoginUserAndLoginPasswordAndLoginStatus(String loginUser, String loginPassword, Integer loginStatus);

    Integer findLoginUser(Login login);

    Integer save(String loginUser, String loginPassword,Integer loginStatus);

    Integer findPassword(Integer id,String password,Integer loginStatus);

    Integer updatePassword(Integer id,String password,Integer loginStatus);
}
