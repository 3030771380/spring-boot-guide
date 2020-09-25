package com.rui.springbootdemo.intercepter;

import lombok.extern.slf4j.Slf4j;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * token拦截器
 */
@Slf4j
@Component
public class AccessTokenVerifyInterceptor extends HandlerInterceptorAdapter {

    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.info("AccessToken executing ...");
        boolean flag = false;
        // token
        String accessToken = request.getParameter("token");
        if (StringUtils.isNotBlank(accessToken)) {
            if(accessToken.equals("123")){
                flag = true;
            }

        }
        if (!flag) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.getWriter().print("AccessToken ERROR");
        }
        return flag;
    }
}
