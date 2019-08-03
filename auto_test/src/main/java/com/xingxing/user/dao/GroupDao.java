package com.xingxing.user.dao;

import com.xingxing.user.pojo.Group;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface GroupDao {

    @Select("select * from tb_api_group where project_id = #{project_id}")
    List<Map> findAll(@Param("project_id") String project_id);


    @Insert("INSERT INTO tb_api_group (id,name,project_id) " +
            "VALUES (#{id,jdbcType=VARCHAR},#{name,jdbcType=VARCHAR},#{project_id,jdbcType=VARCHAR})")
    void addGroup(Group group);


    @Update("UPDATE tb_api_group SET NAME = #{name} where id= #{id} and project_id =#{project_id}")
    void updateGroup(Group group);

    @Delete("delete from tb_api_group where id =#{id} and  project_id =#{project_id}")
    void deleteGroup(Group group);
}
