package com.xingxing.user.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingxing.user.constant.Constant;
import com.xingxing.user.dao.CaseDao;
import com.xingxing.user.dto.InterfaceDTO;
import com.xingxing.user.dto.OldApiAddCaseDTO;
import com.xingxing.user.pojo.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;
import java.util.Map;

@Service
public class CaseService {

    @Autowired
    CaseDao caseDao;

    @Autowired
    private IdWorker idWorker;


    @Autowired
    UserService userService;

    public PageInfo<Case> findAll(Case ca) {

        Page<Case> pageInfo = PageHelper.startPage(ca.getPage(), 10);
        List<Case> result = caseDao.findCaseList(ca);
        PageInfo<Case> info = new PageInfo<>(result);
        return info;
    }

    public void insertCas(Case ca, String userId) throws Exception {
        String id = idWorker.nextId() + "";
        ca.setId(id);
        caseDao.insertCas(ca);
        userService.userLogs(userId, ca.getProject_id(), id, Constant.OPERATION_INSERT);
    }

    public void updateCase(Case ca, String userId) throws Exception {
        caseDao.updateCase(ca);
        userService.userLogs(userId, ca.getProject_id(), ca.getId(), Constant.OPERATION_UPDATE);
    }

    public void delCase(Case ca, String userId) throws Exception {
        caseDao.delCase(ca.getIds());

    }

    public PageInfo<Map> apiList(Case ca, String userId) {

        Page<Case> pageInfo = PageHelper.startPage(ca.getPage(), 10);
        List<Map> list = caseDao.apiList(ca.getId());
        PageInfo<Map> info = new PageInfo<>(list);

        return info;
    }

    public void addOldApi(OldApiAddCaseDTO ca, String userId) throws Exception {
        caseDao.addOldApi(ca);
        userService.userLogs(userId, ca.getProject_id(), ca.getCase_id(), Constant.OPERATION_UPDATE);

    }
}
