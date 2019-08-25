package com.xingxing.user.dao;

import com.xingxing.user.dto.HeadDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApiHeadDao {
    void save(@Param("headDict") List<HeadDTO> headDict, @Param("apiId") String apiId);

    void deleteByInterfaceId(@Param("ids") List<String> ids);
}
