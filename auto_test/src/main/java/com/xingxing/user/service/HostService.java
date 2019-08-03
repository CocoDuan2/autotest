package com.xingxing.user.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingxing.user.dao.HostDao;
import com.xingxing.user.dto.HostDTO;
import com.xingxing.user.pojo.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.util.Strings;
import util.IdWorker;

import java.util.List;
import java.util.Map;

@Service
public class HostService {

    @Autowired(required = false)
    HostDao hostDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 分页查询配置host信息
     *
     * @param project_id
     * @param page
     * @param name
     * @return
     */
    public PageInfo getHostPageList(String project_id, Integer page, Integer size, String name) {
        PageHelper.startPage(page, size);
        List<Map> maps = hostDao.hostTotal(project_id, name);
        PageInfo<Map> mapPageInfo = new PageInfo<>(maps);
        return mapPageInfo;
    }

    /**
     * 删除
     *
     * @param hostId
     */
    public void hostDelete(HostDTO hostDTO) {
        hostDao.hostDelete(hostDTO);
    }

    /**
     * 更新
     *
     * @param configuration
     */
    public void hostUpdate(Configuration configuration) {
        String id = configuration.getId();
        if (Strings.isNullOrEmpty(id)) {
            configuration.setId(idWorker.nextId() + "");
            configuration.setStatus("1");
            hostDao.insertHost(configuration);
        } else {
            hostDao.hostUpdate(configuration);
        }
    }

    public Configuration selectById(String id) {
        return hostDao.selectById(id);
    }


}
