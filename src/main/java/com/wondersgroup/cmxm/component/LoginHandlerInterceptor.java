package com.wondersgroup.cmxm.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;

/**
 * @Created by Miracle_he
 * @Date 2020/4/23
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginName");
        // 如果获取的request的session中的loginUser参数为空（未登录），就返回登录页，否则放行访问
        if (user==null) {
            // 未登录，给出错误信息，
            System.out.println(user);
            request.setAttribute("msg","登录已过期，请重新登录");
           // JOptionPane.showMessageDialog(null, "信息", "标题", JOptionPane.INFORMATION_MESSAGE);
            // 获取request返回页面到登录页
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        } else {
            // 已登录，放行
            request.setAttribute("msg","");
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
