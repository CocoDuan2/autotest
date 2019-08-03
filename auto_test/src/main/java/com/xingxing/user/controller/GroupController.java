package com.xingxing.user.controller;

import com.xingxing.user.pojo.Group;
import com.xingxing.user.service.GroupService;
import entity.Result;
import entity.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.IdWorker;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/api")
public class GroupController {

    @Autowired
    private GroupService groupService;


    /**
     * 查询分组
     * @return
     */
    @RequestMapping("/findGroupList")
    public Result findAll(String project_id) {
        try {
            List<Map> list = groupService.findGroupList(project_id);
            return new Result(StatusCode.OK, "接口分组查询成功", list);
        } catch (Exception e) {
            log.error("接口分组查询", e);
            return new Result(StatusCode.ERROR, "接口分组查询失败", "");

        }
    }


    /**
     * 新增/更新分组
     * @param group
     * @return
     */
    @RequestMapping("/addGroup")
    public Result addGroup(@RequestBody Group group) {
        try {
            groupService.addGroup(group);
            return new Result(StatusCode.OK, "接口分组新增成功", "");
        } catch (Exception e) {
            log.error("接口分组新增失败", e);
            return new Result(StatusCode.ERROR, "接口分组新增失败", "");

        }
    }


    @RequestMapping("/deleteGroup")
    public Result deleteGroup(@RequestBody Group group) {
        try {
            groupService.deleteGroup(group);
            return new Result(StatusCode.OK, "接口分组删除成功", "");
        } catch (Exception e) {
            log.error("接口分组删除失败", e);
            return new Result(StatusCode.ERROR, "接口分组删除失败", "");

        }
    }
}
