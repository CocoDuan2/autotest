package com.xingxing.user.controller;

import com.github.pagehelper.PageInfo;
import com.xingxing.user.service.UserService;
import entity.Result;
import entity.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@Slf4j
@CrossOrigin(origins = "*")
public class MemberController {

    @Autowired
    UserService userService;

    /**
     * 项目人员
     *
     * @param project_id
     * @return
     */
    @RequestMapping(value = "/project_member", method = RequestMethod.GET)
    public Result projectMember(String project_id, Integer page) {

        try {
            PageInfo pageInfo = userService.projectMember(project_id, page);
            return new Result(StatusCode.OK, "项目人员查询成功", pageInfo);
        } catch (Exception e) {
            log.error("项目详情查询失败", e);
            return new Result(StatusCode.ERROR, "项目人员查询失败", null);
        }
    }
}
