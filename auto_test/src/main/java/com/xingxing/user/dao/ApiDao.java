package com.xingxing.user.dao;

import com.xingxing.user.dto.ApiDTO;
import com.xingxing.user.dto.InterfaceDTO;

import java.util.List;

public interface ApiDao {


    List<InterfaceDTO> findApiList(InterfaceDTO interfaceVO);

    void save(ApiDTO apiDTO);
}
