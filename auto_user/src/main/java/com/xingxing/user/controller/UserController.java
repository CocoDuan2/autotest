package com.xingxing.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.xingxing.user.pojo.User;
import com.xingxing.user.service.UserService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import util.JwtUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
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
    @ApiOperation(value = "用户登录请求")
    @CrossOrigin("http://localhost:9528")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody User user,HttpServletRequest request) {

        User user1 = userService.login(user);
        System.out.println(user1);

        if (user1 != null) {

            //签发token
            String token = jwtUtil.createJWT(user.getId(), user.getUsername());
            Map resultMap = new HashMap();
            resultMap.put("token", token);
            resultMap.put("username", user.getUsername());//登陆名
            //JSONObject json = new JSONObject(resultMap);


          // request.getSession().setAttribute("token",token);
            return new Result(true, StatusCode.OK, "登录成功",resultMap);


        } else {
            return new Result(false,StatusCode.LOGINERROR, "用户名或密码错误","");

        }


    }


}
