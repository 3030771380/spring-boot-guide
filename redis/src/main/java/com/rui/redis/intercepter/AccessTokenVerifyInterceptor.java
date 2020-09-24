package com.rui.redis.intercepter;

import lombok.extern.slf4j.Slf4j;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Access Token拦截器
 * <p/>
 * Created by bysocket on 16/4/18.
 */
@Slf4j
@Component
public class AccessTokenVerifyInterceptor extends HandlerInterceptorAdapter {
//    @Autowired
//    ValidationService validationService;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.info("AccessToken executing ...");
        boolean flag = false;
        // token
        String accessToken = request.getParameter("token");
        if (StringUtils.isNotBlank(accessToken)) {
//            ValidationModel v = validationService.verifyAccessToken(accessToken);
            // 时间过期
            // 用户验证
//            if (v != null) {
//                User user = userService.findById(v.getUid());
//                if(user != null) {
//                    request.setAttribute(CommonConst.PARAM_USER, user);
//                    log.info("AccessToken SUCCESS ...  user:" + user.getUserName() + " - " + accessToken);
//                    flag = true;
//                }
//            }
        }
//        if (!flag) {
//            response.setStatus(HttpStatus.FORBIDDEN.value());
//            response.getWriter().print("AccessToken ERROR");
//        }
        return true;
    }
}
