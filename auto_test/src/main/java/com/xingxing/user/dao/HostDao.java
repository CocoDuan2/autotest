package com.xingxing.user.dao;

import com.xingxing.user.dto.HostDTO;
import com.xingxing.user.pojo.Configuration;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HostDao {


    List<Map> hostTotal(@Param("project_id") String project_id, @Param("name") String name);


    @Delete("<script>" +
            "delete from tb_configuration where id in" +
            "<foreach collection='ids' open='(' item='id' separator=',' close=')'> #{id}</foreach>" +
            "and project_id = #{project_id}" +
            "</script>")
    void hostDelete(HostDTO hostDTO);


    void hostUpdate(Configuration configuration);

    void insertHost(Configuration configuration);

    Configuration selectById(String id);
}
