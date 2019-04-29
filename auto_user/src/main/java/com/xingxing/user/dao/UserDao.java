package com.xingxing.user.dao;

import com.xingxing.user.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;



public interface UserDao {


    @Select("select * from auto_uesr where username = #{usernem} and password = #{password}")
    public User findByUsernameAndPassword(String username, String password);

    @Select("select * from auto_uesr where id = #{userId}")
    User findById(String userId);
}

