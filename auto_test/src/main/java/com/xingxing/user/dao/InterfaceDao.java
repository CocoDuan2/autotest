package com.xingxing.user.dao;

import com.xingxing.user.pojo.Interface;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InterfaceDao {


    List<Interface> findAll(@Param("name") String name, @Param("projectId") String projectId, @Param("groupId")
            String groupId);


    void delByIds(List<String> ids);

}
