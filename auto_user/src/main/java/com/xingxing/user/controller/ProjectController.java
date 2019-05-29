package com.xingxing.user.controller;


import com.github.pagehelper.Page;
import com.xingxing.user.dto.ProjectInfoDTO;
import com.xingxing.user.pojo.Project;
import com.xingxing.user.service.ProjectService;
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
@CrossOrigin(origins = "*")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    /**
     * 新增/更新/禁用项目 复用
     *
     * @param project
     * @return
     */
    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public Result addProject(@RequestBody Project project) {

        try {
            projectService.addProject(project);
            return new Result(StatusCode.OK, "项目添加/更新成功", "");
        } catch (Exception e) {
            log.error("项目添加/更新失败", e);
            return new Result(StatusCode.ERROR, "项目添加/更新失败", "");

        }
    }

    /**
     * 分页/条件查询项目
     *
     * @param project
     * @param pageNo
     * @param size
     * @param request
     * @return
     */
    @RequestMapping(value = "/getProjectPageList", method = RequestMethod.POST)
    public Result getProjectPageList(Project project, @RequestParam(name = "pageNo", required = false,
            defaultValue = "1") Integer pageNo, @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
                                     HttpServletRequest request) {
        try {
            Page<Project> projectPageList = projectService.getProjectPageList(project, pageNo, size);

            Map resultMap = new HashMap<>();
            resultMap.put("total", projectPageList.getTotal());
            resultMap.put("data", projectPageList.getResult());

            return new Result(StatusCode.OK, "成功", new PageResult<Project>(projectPageList.getTotal(),
                    projectPageList.getResult()));
        } catch (Exception e) {
            log.error("项目查询失败", e);
            return new Result(StatusCode.ERROR, "项目查询失败", null);
        }
    }

    /**
     * 删除项目
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/del_project", method = RequestMethod.POST)
    public Result delProject(@RequestBody List<String> ids) {

        try {
            projectService.delProject(ids);
            return new Result(StatusCode.OK, "项目删除成功", "");
        } catch (Exception e) {
            log.error("项目删除失败", e);
            return new Result(StatusCode.ERROR, "项目删除失败", "");

        }
    }

    /**
     * 项目详情
     *
     * @param project_id
     * @return
     */
    @RequestMapping(value = "/project_info", method = RequestMethod.GET)
    public Result projectInfo(String project_id) {

        try {
            ProjectInfoDTO projectInfo = projectService.projectInfo(project_id);
            return new Result(StatusCode.OK, "项目删除成功", "");
        } catch (Exception e) {
            log.error("项目删除失败", e);
            return new Result(StatusCode.ERROR, "项目删除失败", "");

        }
    }

}
