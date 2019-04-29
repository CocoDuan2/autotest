package com.xingxing.user.controller;


import annotation.LoginToken;
import com.xingxing.user.User;
import com.xingxing.user.service.UserService;
import com.xingxing.user.utils.JwtUtil;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;



@RestController
@RequestMapping("/user")
@Slf4j
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private BCryptPasswordEncoder encoder;


    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @LoginToken
    @ApiOperation(value = "用户登录请求")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody User user, HttpServletRequest request) {

        User user1 = userService.login(user);
        if (user1 != null) {
            //签发token
            String token = jwtUtil.createJWT(user1);
            Map resultMap = new HashMap();
            resultMap.put("token", token);
            resultMap.put("username", user1.getUsername());//登陆名
            //JSONObject json = new JSONObject(resultMap);

            request.getSession().setAttribute("token",token);
            return new Result(true, StatusCode.OK, "登录成功",resultMap);


        } else {
            return new Result(false,StatusCode.LOGINERROR, "用户名或密码错误","");

        }


    }


}
