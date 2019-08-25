package com.xingxing.user.dao;

import com.xingxing.user.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


public interface UserDao {


    @Select("select * from tb_user where username = #{username} and password = #{password}")
    public User findByUsernameAndPassword(@Param("username") String username, @Param("password")String password);

    @Select("select * from tb_user where id = #{userId}")
    User findById(String userId);

    @Select("SELECT\n" +
            "\tu.id,\n" +
            "\tu.username,\n" +
            "\tu.email userEmail,\n" +
            "\tu.mobile userPhone,\n" +
            "\tr.NAME permissionType \n" +
            "FROM\n" +
            "\ttb_project_user pu\n" +
            "\tINNER JOIN tb_user u ON u.id = pu.user_id\n" +
            "\tINNER JOIN tb_user_role ur ON u.id = ur.user_id\n" +
            "\tINNER JOIN tb_role r ON r.id = ur.role_id \n" +
            "WHERE\n" +
            "\tpu.project_id = #{project_id}")
    List<Map<String,Object>> selectProjectMember(String project_id);
}

