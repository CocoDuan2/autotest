package com.xingxing.user.service;

import com.xingxing.user.dao.GroupDao;
import com.xingxing.user.pojo.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.util.Strings;
import util.IdWorker;

import java.util.List;
import java.util.Map;


@Service
public class GroupService {

    @Autowired(required = false)
    GroupDao groupDao;


    @Autowired
    private IdWorker idWorker;


    public List<Map> findGroupList(String project_id) {

        List<Map> list = groupDao.findAll(project_id);

        return list;
    }

    public void addGroup(Group group) {

        if (Strings.isNullOrEmpty(group.getId())){
            group.setId(idWorker.nextId() + "");
            groupDao.addGroup(group);
        }else {
            groupDao.updateGroup(group);
        }



    }

    public void deleteGroup(Group group) {
        groupDao.deleteGroup(group);
    }
}
