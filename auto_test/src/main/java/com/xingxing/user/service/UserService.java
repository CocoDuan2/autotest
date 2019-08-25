package com.xingxing.user.service;

import com.xingxing.user.dto.UserOperationLogDTO;
import com.xingxing.user.pojo.User;
import com.xingxing.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

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

    /**
     * 用户日志
     *  @param httpServletRequest
     * @param s
     * @param project_id
     * @param id
     */
    @Transactional
    public void userLogs(String userId, String project_id, String operationId,String operationType) throws Exception {

        UserOperationLogDTO userOperationLogDTO = new UserOperationLogDTO();
        userOperationLogDTO.setOperationId(operationId);
        userOperationLogDTO.setProjectId(project_id);
        userOperationLogDTO.setUserId(userId);
        userOperationLogDTO.setOperationType(operationType);
        userOperationLogDTO.setOperationTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()));
        userDao.insertUserLog(userOperationLogDTO);
    }
}
