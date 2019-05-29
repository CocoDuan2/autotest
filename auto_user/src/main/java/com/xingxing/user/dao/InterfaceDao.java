package com.xingxing.user.dao;

import com.xingxing.user.vo.InterfaceVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface InterfaceDao {


    List<InterfaceVO> findAll(@Param("projectId") String projectId,@Param("groupId") String groupId);
}
