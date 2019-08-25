package com.xingxing.user.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xingxing.user.dto.ApiDTO;
import com.xingxing.user.dto.InterfaceDTO;
import com.xingxing.user.dto.OldApiAddCaseDTO;
import com.xingxing.user.pojo.Case;
import com.xingxing.user.pojo.Group;
import com.xingxing.user.pojo.Interface;
import com.xingxing.user.pojo.Project;
import com.xingxing.user.service.*;
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
import java.util.stream.Collectors;

/**
 * 自动化测试
 */
@RestController
@Slf4j
@RequestMapping("/automation")
public class AutomationController {


    @Autowired
    private GroupService groupService;


    @Autowired
    private ProjectService projectService;


    @Autowired
    private InterfaceService interfaceService;

    @Autowired
    private ApiService apiService;

    @Autowired
    CaseService caseService;

    /**
     * 查询分组
     *
     * @return
     */
    @RequestMapping("/group")
    public Result findAll(String project_id) {
        try {
            List<Map> list = groupService.findGroupList(project_id);

            List<Map> group_type = list.stream().filter(map -> map.get("group_type").equals(1)).collect(Collectors.toList());

            return new Result(StatusCode.OK, "接口分组查询成功", group_type);
        } catch (Exception e) {
            log.error("接口分组查询", e);
            return new Result(StatusCode.ERROR, "接口分组查询失败", "");

        }
    }

    /**
     * 新增/更新分组
     *
     * @param group
     * @return
     */
    @RequestMapping("/add_group")
    public Result addGroup(@RequestBody Group group) {
        try {
            group.setGroup_type(1);
            groupService.addGroup(group);
            return new Result(StatusCode.OK, "接口分组新增成功", "");
        } catch (Exception e) {
            log.error("接口分组新增失败", e);
            return new Result(StatusCode.ERROR, "接口分组新增失败", "");

        }
    }

    @RequestMapping("/del_group")
    public Result deleteGroup(@RequestBody Group group) {
        try {
            groupService.deleteGroup(group);
            return new Result(StatusCode.OK, "接口分组删除成功", "");
        } catch (Exception e) {
            log.error("接口分组删除失败", e);
            return new Result(StatusCode.ERROR, "接口分组删除失败", "");

        }
    }

    /**
     * 用例
     *
     * @return
     */
    @RequestMapping("/case_list")
    public Result findAll(@RequestBody Case ca) {
        try {
            PageInfo<Case> list = caseService.findAll(ca);

            return new Result(StatusCode.OK, "用例查询成功", list);
        } catch (Exception e) {
            log.error("用例查询失败", e);
            return new Result(StatusCode.ERROR, "用例查询失败", null);
        }
    }

    /**
     * 新增用例
     *
     * @return
     */
    @RequestMapping("/add_case")
    public Result addCase(@RequestBody Case ca, HttpServletRequest httpServletRequest) {
        try {
            String userId = (String) httpServletRequest.getAttribute("userId");
            caseService.insertCas(ca, userId);

            return new Result(StatusCode.OK, "用例新增成功", null);
        } catch (Exception e) {
            log.error("用例新增失败", e);
            return new Result(StatusCode.ERROR, "用例新增失败", null);
        }
    }

    /**
     * 更新用例
     *
     * @return
     */
    @RequestMapping("/update_case")
    public Result updateCase(@RequestBody Case ca, HttpServletRequest httpServletRequest) {
        try {
            String userId = (String) httpServletRequest.getAttribute("userId");
            caseService.updateCase(ca, userId);

            return new Result(StatusCode.OK, "用例更新成功", null);
        } catch (Exception e) {
            log.error("用例更新失败", e);
            return new Result(StatusCode.ERROR, "用例更新失败", null);
        }
    }

    /**
     * 删除用例
     *
     * @return
     */
    @RequestMapping("/del_case")
    public Result delCase(@RequestBody Case ca, HttpServletRequest httpServletRequest) {
        try {
            String userId = (String) httpServletRequest.getAttribute("userId");
            caseService.delCase(ca, userId);

            return new Result(StatusCode.OK, "用例删除成功", null);
        } catch (Exception e) {
            log.error("用例删除失败", e);
            return new Result(StatusCode.ERROR, "用例删除失败", null);
        }
    }



    /**
     * 用例接口详情
     *
     * @return
     */
    @RequestMapping("/api_list")
    public Result apiList(@RequestBody Case ca, HttpServletRequest httpServletRequest) {
        try {
            String userId = (String) httpServletRequest.getAttribute("userId");
            caseService.apiList(ca, userId);

            return new Result(StatusCode.OK, "用例接口详情查看成功", null);
        } catch (Exception e) {
            log.error("用例接口详情查看失败", e);
            return new Result(StatusCode.ERROR, "用例接口详情查看失败", null);
        }
    }

    /**
     * 用例添加老接口
     *
     * @return
     */
    @RequestMapping("/add_old_api")
    public Result addOldApi(@RequestBody OldApiAddCaseDTO ca, HttpServletRequest httpServletRequest) {
        try {
            String userId = (String) httpServletRequest.getAttribute("userId");
            caseService.addOldApi(ca, userId);

            return new Result(StatusCode.OK, "用例添加老接口成功", null);
        } catch (Exception e) {
            log.error("用例添加老接口失败", e);
            return new Result(StatusCode.ERROR, "用例添加老接口失败", null);
        }
    }
}
