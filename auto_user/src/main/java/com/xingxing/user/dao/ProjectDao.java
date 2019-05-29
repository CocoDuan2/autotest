package com.xingxing.user.dao;


import com.xingxing.user.pojo.Project;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProjectDao {

    @Select("select * from tb_project") // 查询所有
    public List<Project> findAll();


    @Insert("INSERT INTO tb_project (id,project_name,version,type,description,status,last_update_time,create_time) " +
            "VALUES (#{id,jdbcType=VARCHAR},#{projectName,jdbcType=VARCHAR},#{version,jdbcType=VARCHAR},#{type,jdbcType=VARCHAR},#{description,jdbcType=VARCHAR},#{status,jdbcType=VARCHAR}," +
            "#{lastUpdateTime,jdbcType=TIMESTAMP},#{createTime,jdbcType=TIMESTAMP})")
    int save(Project project);

}
