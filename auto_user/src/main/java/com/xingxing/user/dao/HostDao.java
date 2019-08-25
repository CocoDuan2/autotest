package com.xingxing.user.dao;

import com.xingxing.user.pojo.Configuration;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HostDao {


    List<Map<String, Object>> hostTotal(@Param("project_id") String project_id, @Param("name") String name);

    @Delete("delete from tb_configuration where id = #{hostId}")
    void hostDelete(@Param("hostId") String hostId);


    void hostUpdate(Configuration configuration);

    void insertHost(Configuration configuration);

    Configuration selectById(String id);
}
