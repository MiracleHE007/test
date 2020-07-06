package com.wondersgroup.cmxm.repository;

import com.wondersgroup.cmxm.dataobject.Login;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LoginRepository {

    Login findOneByLoginUserAndLoginPasswordAndLoginStatus(String loginUser, String loginPassword,Integer loginStatus);

    Integer save(String loginUser, String loginPassword,Integer loginStatus);

    Integer findLoginUser(Login login);

    Integer findPassword(Integer login_id,String login_password,Integer login_status);

    Integer updatePassword(Integer login_id,String login_password,Integer login_status);

}
