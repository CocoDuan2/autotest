package com.xingxing.service;

import com.xingxing.PO.User;
import com.xingxing.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private IdWorker idWorker;


  /*  public void addUser(User PO) {

        PO.setId(idWorker.nextId() + "");
          userDao.save(PO);

    }*/

    public User login(User user) {

        return userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());

    }

    public User findUserById(String userId) {
        return userDao.findById(userId);
    }
}
