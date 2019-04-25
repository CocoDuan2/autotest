package com.xingxing.user.dao;

import com.xingxing.user.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 *
 */

public interface UserDao extends JpaRepository<User, String>, JpaSpecificationExecutor<String> {
    

   User findByUsernameAndPassword(String username, String password);
}

