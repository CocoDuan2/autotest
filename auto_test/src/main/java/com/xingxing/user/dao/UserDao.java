package com.xingxing.user.dao;

import com.xingxing.user.dto.UserOperationLogDTO;
import com.xingxing.user.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface UserDao {


    @Select("select * from tb_user where username = #{username} and password = #{password}")
    public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    @Select("select * from tb_user where id = #{userId}")
    User findById(String userId);

    @Insert("insert into tb_user_operation_log(project_id,user_id,operation_id,operation_time,operation_type) values" +
            "(#{projectId}," +
            "#{userId}," +
            "#{operationId},#{operationTime},#{operationType})")
    void insertUserLog(UserOperationLogDTO userOperationLogDTO);

}

