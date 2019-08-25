package com.xingxing.user.dao;

import com.xingxing.user.dto.ApiDTO;
import com.xingxing.user.dto.InterfaceDTO;
import com.xingxing.user.pojo.ApiHistory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApiDao {


    List<InterfaceDTO> findApiList(InterfaceDTO interfaceVO);

    void save(ApiDTO apiDTO);

    ApiDTO findOne(@Param("project_id") String project_id,@Param("api_id") String api_id);

    void deleteApi(@Param("ids") List<String> ids);

    void update(ApiDTO apiDTO);

    void addHistory(ApiHistory apiHistory);

    List<ApiHistory> hisotoryList(String interfaceId);
}
