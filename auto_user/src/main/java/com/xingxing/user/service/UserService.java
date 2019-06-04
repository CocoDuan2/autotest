package com.xingxing.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingxing.user.pojo.User;
import com.xingxing.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired(required = false)
    private UserDao userDao;

    @Autowired
    private IdWorker idWorker;


  /*  public void addUser(User user) {

        user.setId(idWorker.nextId() + "");
          userDao.save(user);

    }*/

    public User login(User user) {

        return userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());

    }

    public User findUserById(String userId) {
        return userDao.findById(userId);
    }

    public PageInfo projectMember(String project_id, Integer page) {
        List<Map<String, Object>> maps = userDao.selectProjectMember(project_id);
        PageHelper.startPage(page,10);
        PageInfo pageInfo = new PageInfo(maps);

        return  pageInfo;

    }
}
