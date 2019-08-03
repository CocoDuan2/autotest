package com.xingxing.user.controller;


import com.github.pagehelper.Page;

import com.xingxing.user.pojo.Interface;
import com.xingxing.user.pojo.Project;
import com.xingxing.user.service.InterfaceService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/interface")
@Slf4j
@CrossOrigin(origins = "*")
public class InterfaceController {


    @Autowired
    private InterfaceService interfaceService;


    @RequestMapping("/getInterfacePageList")
    public Result findAll(Interface i, Integer page, Integer size) {


        try {
            Page<Interface> interfacePageList = interfaceService.getInterfacePageList(i, page, size);

            Map resultMap = new HashMap<>();
            resultMap.put("total", interfacePageList.getTotal());
            resultMap.put("data", interfacePageList.getResult());

            return new Result(StatusCode.OK, "成功", new PageResult<Interface>(interfacePageList.getTotal(),
                    interfacePageList.getResult()));
        } catch (Exception e) {
            log.error("接口查询失败", e);
            return new Result(StatusCode.ERROR, "接口查询失败", null);
        }

    }


    @RequestMapping("/deleteInterfaces")
    public Result deleteInterface(List<String> ids) {

        try {

            interfaceService.deleteByIds(ids);
            return null;

        } catch (Exception e) {
            log.error("删除接口失败", e);
            return new Result(StatusCode.ERROR, "删除接口失败", null);
        }

    }


}
