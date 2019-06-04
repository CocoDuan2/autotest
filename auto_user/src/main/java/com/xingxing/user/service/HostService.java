package com.xingxing.user.service;


import com.github.pagehelper.PageInfo;
import com.xingxing.user.dao.HostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HostService {

    @Autowired
    HostDao hostDao;

    public PageInfo hostTotal(String project_id, Integer page, String name) {
     List<Map<String,Object>> maps = hostDao.hostTotal(project_id,name);

        return null;

    }
}
