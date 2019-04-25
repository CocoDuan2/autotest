package com.xingxing.user.controller;


import com.xingxing.user.pojo.Project;
import com.xingxing.user.service.ProjectService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import util.JwtUtil;
import util.UserLoginToken;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/project")
@Slf4j
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private JwtUtil jwtUtil;


    @CrossOrigin("http://localhost:9528")
    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public Result addProject(Project project) {

        try {
            projectService.addProject(project);

            return new Result(StatusCode.OK, "项目添加成功", "");
        } catch (Exception e) {
            log.error("项目添加失败", e);
            return new Result();

        }

    }

    //@UserLoginToken
    @CrossOrigin("http://localhost:9528")
    @RequestMapping(value = "/getProjectPageList", method = RequestMethod.POST)
    public Result getProjectPageList(Project project, @RequestParam(value = "pageNo",required = false) Integer pageNo,
                                     @RequestParam(value = "size",required = false) Integer size,HttpServletRequest
                                                 request) {


        try {
            Page<Project> projectPageList = projectService.getProjectPageList(project, pageNo, size);

            return new Result(StatusCode.OK, "成功", new PageResult<Project>(projectPageList.getTotalElements(),
                    projectPageList.getContent()));
        } catch (Exception e) {
            log.error("项目查询失败", e);
            return new Result(StatusCode.ERROR, "项目查询失败", null);
        }

    }


}
