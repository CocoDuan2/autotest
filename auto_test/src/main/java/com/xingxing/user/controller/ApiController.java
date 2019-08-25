package com.xingxing.user.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xingxing.user.dto.ApiDTO;
import com.xingxing.user.pojo.Api;
import com.xingxing.user.pojo.ApiHistory;
import com.xingxing.user.pojo.Group;
import com.xingxing.user.service.ApiService;
import com.xingxing.user.dto.InterfaceDTO;
import com.xingxing.user.service.UserService;
import entity.Result;
import entity.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @Autowired
    UserService userService;

    /**
     * 查询接口
     *
     * @return
     */
    @RequestMapping("/findApiList")
    public Result findAll(@RequestBody InterfaceDTO interfaceDTO) {
        try {
            PageInfo<InterfaceDTO> list = apiService.findApiList(interfaceDTO);
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
    @RequestMapping("/addApi")
    public Result addApi(@RequestBody ApiDTO apiDTO, HttpServletRequest httpServletRequest) {
        try {
            String userId = (String) httpServletRequest.getAttribute("userId");
            apiService.insertApi(apiDTO, userId);

            return new Result(StatusCode.OK, "接口新增成功", null);
        } catch (Exception e) {
            log.error("接口新增失败", e);
            return new Result(StatusCode.ERROR, "接口新增失败", null);
        }
    }

    /**
     * 查询API详情
     *
     * @return
     */
    @RequestMapping("/apiInfo")
    public Result findOne(String project_id, String api_id) {
        try {
            ApiDTO apiInfo = apiService.findOne(project_id, api_id);
            return new Result(StatusCode.OK, "查询接口详情成功", apiInfo);
        } catch (Exception e) {
            log.error("查询接口详情失败", e);
            return new Result(StatusCode.ERROR, "查询接口详情失败", null);
        }
    }


    /**
     * 删除API
     *
     * @return
     */
    @RequestMapping("/deleteApi")
    public Result deleteApi(@RequestBody Api api) {
        try {
            apiService.deleteApi(api);
            return new Result(StatusCode.OK, "删除API成功", null);
        } catch (Exception e) {
            log.error("删除API失败", e);
            return new Result(StatusCode.ERROR, "删除API失败", null);
        }
    }

    /**
     * 更新API
     *
     * @return
     */
    @RequestMapping("/updateApi")
    public Result updateApi(@RequestBody ApiDTO apiDTO, HttpServletRequest httpServletRequest) {
        try {
            String userId = (String) httpServletRequest.getAttribute("userId");
            apiService.updateApi(apiDTO, userId);
            return new Result(StatusCode.OK, "修改API成功", null);
        } catch (Exception e) {
            log.error("修改API失败", e);
            return new Result(StatusCode.ERROR, "修改API失败", null);
        }
    }

    /**
     * 快速测试API
     *
     * @return
     */
    @RequestMapping("/runApi")
    public Result runApi(@RequestBody ApiDTO apiDTO, HttpServletRequest httpServletRequest) {
        try {
            String userId = (String) httpServletRequest.getAttribute("userId");
            //   apiService.runApi(apiDTO, userId);
            return new Result(StatusCode.OK, "快速测试API成功", null);
        } catch (Exception e) {
            log.error("快速测试API失败", e);
            return new Result(StatusCode.ERROR, "快速测试API失败", null);
        }
    }


    /**
     * 测试API历史记录
     *
     * @return
     */
    @RequestMapping("/addHistory")
    public Result addHistory(@RequestBody ApiHistory apiHistory) {
        try {

            apiService.addHistory(apiHistory);
            return new Result(StatusCode.OK, "添加历史记录成功", null);
        } catch (Exception e) {
            log.error("添加历史记录失败", e);
            return new Result(StatusCode.ERROR, "添加历史记录失败", null);
        }
    }


    /**
     * 测试API历史记录
     *
     * @return
     */
    @RequestMapping("/hisotoryList")
    public Result hisotoryList(String interfaceId) {
        try {
            List<ApiHistory> historyList = apiService.hisotoryList(interfaceId);

            return new Result(StatusCode.OK, "查询历史记录成功", historyList);
        } catch (Exception e) {
            log.error("查询历史记录失败", e);
            return new Result(StatusCode.ERROR, "查询历史记录失败", null);
        }
    }


}
