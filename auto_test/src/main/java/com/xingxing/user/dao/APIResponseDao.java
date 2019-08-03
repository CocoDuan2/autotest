package com.xingxing.user.dao;

import com.xingxing.user.dto.ResponseDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface APIResponseDao {
    void save(@Param("responseList") List<ResponseDTO> responseList, @Param("apiId") String apiId);
}
