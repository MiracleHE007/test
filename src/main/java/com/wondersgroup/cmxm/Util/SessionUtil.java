package com.wondersgroup.cmxm.Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Created by Miracle_he
 * @Date 2020/4/23
 */
public class SessionUtil {
    public String LoginSession(HttpServletRequest request){
        HttpSession session=request.getSession();
        String a= (String) session.getAttribute("loginId");
        if(null!=a&&""!=a){
            return "1";
        }else {
            return "0";
        }
    }


}
