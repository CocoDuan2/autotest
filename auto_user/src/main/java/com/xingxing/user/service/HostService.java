package com.xingxing.user.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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

    /**
     * 分页查询配置host信息
     *
     * @param project_id
     * @param page
     * @param name
     * @return
     */
    public PageInfo hostTotal(String project_id, Integer page, String name) {
        PageHelper.startPage(page, 10);
        List<Map<String, Object>> maps = hostDao.hostTotal(project_id, name);
        PageInfo<Map<String, Object>> mapPageInfo = new PageInfo<>(maps);
        return mapPageInfo;
    }
}
