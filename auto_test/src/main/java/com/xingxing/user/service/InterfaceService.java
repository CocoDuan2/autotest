package com.xingxing.user.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingxing.user.dao.InterfaceDao;
import com.xingxing.user.pojo.Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

@Service
public class InterfaceService {

    @Autowired
    private InterfaceDao interfaceDao;

    @Autowired
    private IdWorker idWorker;


    public Page<Interface> getInterfacePageList(Interface i, Integer page, Integer size) {


        //分页并查询

        Page<Interface> pageInfo = PageHelper.startPage(page, size);


        List<Interface> interfaceList = interfaceDao.findAll(i.getName(), i.getProjectId(), i.getGroupId());


        return pageInfo;
    }


    public void deleteByIds(List<String> ids) {

        interfaceDao.delByIds(ids);

    }
}
