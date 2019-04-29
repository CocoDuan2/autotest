package com.pjb.springbootjjwt.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.xingxing.user.User;
import com.xingxing.user.service.UserService;
import com.xingxing.user.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


/**
 * jimisun
 */

public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {

        if (httpServletRequest.getMethod().equals("OPTIONS")) {
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            return true;

        } else {


            // 如果不是映射到方法直接通过
            if (!(object instanceof HandlerMethod)) {
                return true;
            }

            HandlerMethod handlerMethod = (HandlerMethod) object;
            Method method = handlerMethod.getMethod();
           /* //检查是否有LoginToken注释，有则跳过认证
            if (method.isAnnotationPresent(LoginToken.class)) {
                LoginToken loginToken = method.getAnnotation(LoginToken.class);
                if (loginToken.required()) {
                    return true;
                }
            }*/

            //检查有没有需要用户权限的注解
            //  if (method.isAnnotationPresent(CheckToken.class)) {
            //     CheckToken checkToken = method.getAnnotation(CheckToken.class);
            //   if (checkToken.required()) {
            // 从 http 请求头中取出 token
            String authorization = httpServletRequest.getHeader("Authorization");

            // 执行认证
            if (authorization == null) {
                throw new RuntimeException("无token，请重新登录");
            }
            String[] split = authorization.split(" ");
            String token = split[1];
            // 获取 token 中的 user id
            String userId;
            try {

                userId = JWT.decode(token).getClaim("id").asString();
            } catch (JWTDecodeException j) {
                throw new RuntimeException("访问异常！");
            }
            User user = userService.findUserById(userId);
            if (user == null) {
                throw new RuntimeException("用户不存在，请重新登录");
            }
            Boolean verify = jwtUtil.isVerify(token, user);
            if (!verify) {
                throw new RuntimeException("非法访问！");
            }
            return true;
        }


    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


}