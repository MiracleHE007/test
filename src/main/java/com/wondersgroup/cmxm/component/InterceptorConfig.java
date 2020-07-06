package com.wondersgroup.cmxm.component;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;

/**
 * @Created by Miracle_he
 * @Date 2020/4/23
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截的请求，并排除几个不拦截的请求
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns(
                        "/**/login",
                        "/**/XXXX",
                        "/**/registL",
                        "/**/loginC",
                        "/**/index",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/**/*.jpg",
                        "/**/*.gif",
                        "/**/*.woff",
                        "/**/*.tff");
    }
}
