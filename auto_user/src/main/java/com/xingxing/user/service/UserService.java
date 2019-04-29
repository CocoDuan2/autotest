package com.xingxing.user.service;

import com.xingxing.user.User;
import com.xingxing.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

@Service
public class UserService {

    @Autowired
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
}
