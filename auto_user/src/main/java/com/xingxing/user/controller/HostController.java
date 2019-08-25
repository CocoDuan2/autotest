package com.xingxing.user.controller;

import com.github.pagehelper.PageInfo;
import com.xingxing.user.pojo.Configuration;
import com.xingxing.user.service.HostService;
import entity.Result;
import entity.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/host")
@Slf4j
@CrossOrigin(origins = "*")
public class HostController {

    @Autowired
    HostService hostService;

    /**
     * HOST查询
     *
     * @param project_id
     * @return
     */
    @RequestMapping(value = "/host_total", method = RequestMethod.GET)
    public Result hostTotal(String project_id, Integer page, String name) {

        try {
            PageInfo pageInfo = hostService.hostTotal(project_id, page, name);
            return new Result(StatusCode.OK, "HOST查询成功", pageInfo);
        } catch (Exception e) {
            log.error("HOST查询失败", e);
            return new Result(StatusCode.ERROR, "HOST查询失败", null);
        }
    }

    /**
     * 删除
     *
     * @param hostId
     * @return
     */
    @RequestMapping(value = "/host_delete", method = RequestMethod.GET)
    public Result hostDelete(String hostId) {

        try {
            hostService.hostDelete(hostId);
            return new Result(StatusCode.OK, "HOST删除成功", null);
        } catch (Exception e) {
            log.error("HOST查询失败", e);
            return new Result(StatusCode.ERROR, "HOST删除失败", null);
        }
    }

    /**
     * 更新
     *
     * @param configuration
     * @return
     */
    @RequestMapping(value = "/host_update", method = RequestMethod.GET)
    public Result hostUpdate(Configuration configuration) {

        try {
            hostService.hostUpdate(configuration);
            return new Result(StatusCode.OK, "HOST删除成功", null);
        } catch (Exception e) {
            log.error("HOST查询失败", e);
            return new Result(StatusCode.ERROR, "HOST删除失败", null);
        }
    }

    @RequestMapping(value = "/host_find_one", method = RequestMethod.GET)
    public Result hostFindOne(String id) {

        try {
            hostService.selectById(id);
            return new Result(StatusCode.OK, "HOST删除成功", null);
        } catch (Exception e) {
            log.error("HOST查询失败", e);
            return new Result(StatusCode.ERROR, "HOST删除失败", null);
        }
    }
}
