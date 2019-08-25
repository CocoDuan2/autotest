package com.xingxing.user.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.xingxing.user.constant.Constant;
import com.xingxing.user.controller.BusinessException;
import com.xingxing.user.dao.*;
import com.xingxing.user.dto.*;
import com.xingxing.user.pojo.Api;
import com.xingxing.user.pojo.ApiHistory;
import com.xingxing.user.pojo.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import util.IdWorker;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApiService {
    @Autowired
    private IdWorker idWorker;


    @Autowired
    UserService userService;

    @Autowired
    ApiDao apiDao;

    @Autowired
    ApiHeadDao apiHeadDao;

    @Autowired
    APIRequestDao apiRequestDao;

    @Autowired
    APIResponseDao apiResponseDao;

    @Autowired
    UserDao userDao;


    /**
     * 分页条件查询
     *
     * @param interfaceVO
     * @return
     */
    public PageInfo<InterfaceDTO> findApiList(InterfaceDTO interfaceVO) {
        Page<InterfaceDTO> pageInfo = PageHelper.startPage(interfaceVO.getPage(), 10);
        List<InterfaceDTO> result = apiDao.findApiList(interfaceVO);
        PageInfo<InterfaceDTO> info = new PageInfo<>(result);
        return info;
    }

    /**
     * 新增接口
     *
     * @param apiDTO
     * @param userId
     * @return
     */
    @Transactional
    public String insertApi(ApiDTO apiDTO, String userId) throws Exception {
        String apiId = idWorker.nextId() + "";

        apiDTO.setId(apiId);
        apiDao.save(apiDTO);

        List<HeadDTO> headDict = apiDTO.getHeadDict();

        if (!"".equals(headDict.get(0).getName()) && headDict.get(0).getName() != null) {
            apiHeadDao.save(headDict, apiId);
        }

        List<RequestDTO> requestList = apiDTO.getRequestList();
        if (!"".equals(requestList.get(0).getName()) && requestList.get(0).getName() != null) {
            apiRequestDao.save(requestList, apiId);
        }
        List<ResponseDTO> responseList = apiDTO.getResponseList();
        if (!"".equals(responseList.get(0).getName()) && responseList.get(0).getName() != null) {
            apiResponseDao.save(responseList, apiId);
        }
        userService.userLogs(userId, apiDTO.getProject_id(), apiId, Constant.OPERATION_INSERT);

        return apiId;
    }

    public ApiDTO findOne(String project_id, String api_id) {

        ApiDTO apiInfo = apiDao.findOne(project_id, api_id);


        return apiInfo;
    }

    /**
     * 删除
     *
     * @param api
     */
    @Transactional
    public void deleteApi(Api api) {
        List<String> ids = api.getIds();
        if (ids != null && ids.size() > 0) {
            apiDao.deleteApi(ids);
            apiResponseDao.deleteByInterfaceId(ids);
            apiRequestDao.deleteByInterfaceId(ids);
            apiHeadDao.deleteByInterfaceId(ids);
        }

    }

    /**
     * 更新
     *
     * @param apiDTO
     * @param userId
     */
    @Transactional
    public String updateApi(ApiDTO apiDTO, String userId) throws Exception {
        String apiId = apiDTO.getId();
        List<String> ids = new ArrayList<>();
        ids.add(apiId);
        apiDao.update(apiDTO);
        List<HeadDTO> headDict = apiDTO.getHeadDict();

        if (headDict != null && headDict.size() > 0 && !"".equals(headDict.get(0).getName()) && headDict.get(0).getName() !=
                null
                ) {
            apiHeadDao.deleteByInterfaceId(ids);

            apiHeadDao.save(headDict, apiId);

        }

        List<RequestDTO> requestList = apiDTO.getRequestList();
        if (requestList != null && requestList.size() > 0 && !"".equals(requestList.get(0).getName()) && requestList
                .get(0)
                .getName() !=
                null) {
            apiRequestDao.deleteByInterfaceId(ids);

            apiRequestDao.save(requestList, apiId);


        }
        List<ResponseDTO> responseList = apiDTO.getResponseList();
        if (responseList != null && responseList.size() > 0 && !"".equals(responseList.get(0).getName()) && responseList
                .get(0).getName() !=
                null) {
            apiResponseDao.deleteByInterfaceId(ids);

            apiResponseDao.save(responseList, apiId);


        }
        userService.userLogs(userId, apiDTO.getProject_id(), apiId, Constant.OPERATION_UPDATE);

        return apiId;
    }


    public void addHistory(ApiHistory apiHistory) {
        String apiHistoryId = idWorker.nextId() + "";

        apiHistory.setId(apiHistoryId);

        apiHistory.setOperationTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()));
        apiDao.addHistory(apiHistory);

    }

    public List<ApiHistory> hisotoryList(String interfaceId) {

        return apiDao.hisotoryList(interfaceId);
    }
}





