package com.xingxing.user.controller;

import com.github.pagehelper.PageInfo;
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
}
