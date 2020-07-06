package com.wondersgroup.cmxm.service.impl;

import com.wondersgroup.cmxm.dataobject.Login;
import com.wondersgroup.cmxm.repository.LoginRepository;
import com.wondersgroup.cmxm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Created by Miracle_he
 * @Date 2020/4/20
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginRepository loginRepository;
    @Override
    public Login findOneByLoginUserAndLoginPasswordAndLoginStatus(String loginUser, String loginPassword, Integer loginStatus) {
        Login result =loginRepository.findOneByLoginUserAndLoginPasswordAndLoginStatus(loginUser,loginPassword,loginStatus);
        return result;
    }

    @Override
    public Integer findLoginUser(Login login) {
        Integer result=loginRepository.findLoginUser(login);
        return result;
    }

    @Override
    public Integer save(String loginUser, String loginPassword, Integer loginStatus) {
        Integer result=loginRepository.save(loginUser,loginPassword,loginStatus);
        return result;
    }

    @Override
    public Integer findPassword(Integer id, String password, Integer loginStatus) {
        Integer re=loginRepository.findPassword(id,password,loginStatus);
        return re;
    }

    @Override
    public Integer updatePassword(Integer id, String password, Integer loginStatus) {
        Integer result=loginRepository.updatePassword(id,password,loginStatus);
        return result;
    }
}
