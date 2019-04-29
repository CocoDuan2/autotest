package com.xingxing.user.controller;


import com.github.pagehelper.Page;
import com.xingxing.user.Project;
import com.xingxing.user.service.ProjectService;
import com.xingxing.user.utils.JwtUtil;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/project")
@Slf4j
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private JwtUtil jwtUtil;


    /*@CrossOrigin("http://localhost:9528")
    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public Result addProject(Project project) {

        try {
            projectService.addProject(project);

            return new Result(StatusCode.OK, "项目添加成功", "");
        } catch (Exception e) {
            log.error("项目添加失败", e);
            return new Result();

        }

    }*/

    @CrossOrigin("http://localhost:9528")
    @RequestMapping(value = "/getProjectPageList", method = RequestMethod.POST)
    public Result getProjectPageList(Project project, @RequestParam(name = "pageNo", required = false, defaultValue =
            "1") Integer pageNo, @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
                                     HttpServletRequest request) {
        try {
            Page<Project> projectPageList = projectService.getProjectPageList(project, pageNo, size);

            Map resultMap = new HashMap<>();
            resultMap.put("total",projectPageList.getTotal());
            resultMap.put("data",projectPageList.getResult());

            return new Result(StatusCode.OK, "成功", new PageResult<Project>(projectPageList.getTotal(),
                    projectPageList.getResult()));
        } catch (Exception e) {
            log.error("项目查询失败", e);
            return new Result(StatusCode.ERROR, "项目查询失败", null);
        }
    }

}
