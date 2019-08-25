package com.xingxing.user.dao;

import com.xingxing.user.dto.RequestDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface APIRequestDao {
    void save(@Param("requestList") List<RequestDTO> requestList, @Param("apiId") String apiId);

    void deleteByInterfaceId(@Param("ids") List<String> ids);
}
