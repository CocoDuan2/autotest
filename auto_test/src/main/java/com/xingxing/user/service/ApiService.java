package com.xingxing.user.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingxing.user.dao.APIRequestDao;
import com.xingxing.user.dao.APIResponseDao;
import com.xingxing.user.dao.ApiDao;
import com.xingxing.user.dao.ApiHeadDao;
import com.xingxing.user.dto.*;
import com.xingxing.user.pojo.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.List;

@Service
public class ApiService {
    @Autowired
    private IdWorker idWorker;

    @Autowired
    ApiDao apiDao;

    @Autowired
    ApiHeadDao apiHeadDao;

    @Autowired
    APIRequestDao apiRequestDao;

    @Autowired
    APIResponseDao apiResponseDao;


    public Page<InterfaceDTO> findApiList(InterfaceDTO interfaceVO) {
        Page<InterfaceDTO> pageInfo = PageHelper.startPage(interfaceVO.getPage(), 10);
        List<InterfaceDTO> result = apiDao.findApiList(interfaceVO);
        //PageInfo<InterfaceDTO> info = new PageInfo<>(result);
        return pageInfo;
    }

    @Transactional
    public void addApi(ApiDTO apiDTO) {
        String apiId = idWorker.nextId() + "";
        apiDTO.setId(apiId);
        apiDao.save(apiDTO);
        List<HeadDTO> headDict = apiDTO.getHeadDict();
        if (headDict != null && headDict.size() > 0) {
            apiHeadDao.save(headDict, apiId);
        }
        List<RequestDTO> requestList = apiDTO.getRequestList();
        if (requestList != null && requestList.size() > 0) {
            apiRequestDao.save(requestList, apiId);
        }
        List<ResponseDTO> responseList = apiDTO.getResponseList();
        if (responseList != null && responseList.size() > 0) {
            apiResponseDao.save(responseList, apiId);
        }
    }
}
