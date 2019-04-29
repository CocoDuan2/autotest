package com.xingxing.user.dao;


import com.xingxing.user.Project;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProjectDao {

    @Select("select * from tb_project") // 查询所有
    public List<Project> findAll();



}
