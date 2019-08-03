package com.xingxing.user.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xingxing.user.dto.ApiDTO;
import com.xingxing.user.pojo.Group;
import com.xingxing.user.service.ApiService;
import com.xingxing.user.dto.InterfaceDTO;
import entity.Result;
import entity.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ApiService apiService;


    /**
     * 查询接口
     *
     * @return
     */
    @RequestMapping("/findApiList")
    public Result findAll(@RequestBody InterfaceDTO interfaceDTO) {
        try {
            Page<InterfaceDTO> list = apiService.findApiList(interfaceDTO);
            return new Result(StatusCode.OK, "接口查询成功", list);
        } catch (Exception e) {
            log.error("接口查询失败", e);
            return new Result(StatusCode.ERROR, "接口查询失败", null);
        }
    }

    /**
     * 新增API
     *
     * @return
     */
    @RequestMapping("/add_api")
    public Result addApi(@RequestBody ApiDTO apiDTO) {
        try {
            apiService.addApi(apiDTO);
            return new Result(StatusCode.OK, "接口新增成功", null);
        } catch (Exception e) {
            log.error("接口新增失败", e);
            return new Result(StatusCode.ERROR, "接口新增失败", null);
        }
    }


}
