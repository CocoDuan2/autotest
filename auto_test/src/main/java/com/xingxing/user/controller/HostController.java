package com.xingxing.user.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.xingxing.user.dto.HostDTO;
import com.xingxing.user.pojo.Configuration;
import com.xingxing.user.service.HostService;
import entity.Result;
import entity.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Result hostTotal(String project_id, @RequestParam(name = "page", required = false,
            defaultValue = "1") Integer pageNo, @RequestParam(name = "size", required = false, defaultValue = "10") Integer size, String name) {

        try {
            PageInfo pageInfo = hostService.getHostPageList(project_id, pageNo, size, name);
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
     * @RequestParam(name = "ids") String ids, @RequestParam(name = "project_id")  String
     * project_id
     */
    @RequestMapping(value = "/host_delete", method = RequestMethod.POST)
    public Result hostDelete(@RequestBody HostDTO hostDTO) {

        try {
            hostService.hostDelete(hostDTO);
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
    @RequestMapping(value = "/host_update", method = RequestMethod.POST)
    public Result hostUpdate(@RequestBody Configuration configuration) {

        try {
            hostService.hostUpdate(configuration);
            return new Result(StatusCode.OK, "HOST更新成功", null);
        } catch (Exception e) {
            log.error("HOST更新失败", e);
            return new Result(StatusCode.ERROR, "HOST更新失败", null);
        }
    }


}
