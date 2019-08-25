package com.xingxing.user.dao;

import com.xingxing.user.dto.OldApiAddCaseDTO;
import com.xingxing.user.pojo.Case;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CaseDao {
    List<Case> findCaseList(Case ca);

    void insertCas(Case ca);

    void updateCase(Case ca);

    void delCase(@Param("ids") List<String> id);

    List<Map> apiList(@Param("id")String id);

    void addOldApi(OldApiAddCaseDTO ca);
}
