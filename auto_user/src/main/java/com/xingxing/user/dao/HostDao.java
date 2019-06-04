package com.xingxing.user.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface HostDao {

    @Select("<script>" +
            "select * from tb_configuration where project_id =#{project_id}" +
            "<if test = 'name' != null and 'nam' != ''> and name = #{name} </if>" +
            "</script>")
    List<Map<String,Object>> hostTotal(@Param("project_id") String project_id, @Param("name") String name);
}
