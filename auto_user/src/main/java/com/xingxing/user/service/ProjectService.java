package com.xingxing.user.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingxing.user.Project;
import com.xingxing.user.dao.ProjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

@Service
public class ProjectService {


    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private IdWorker idWorker;

    /*public Project addProject(Project project) {

        project.setId(idWorker.nextId() + "");

        return projectDao.save(project);


    }*/

    public Page<Project> getProjectPageList(Project project, Integer page, Integer size) {

        //分页并查询

        Page<Project> pageInfo = PageHelper.startPage(page, size);
        List<Project> projectList = projectDao.findAll();

        //获取分页信息演示, 实际项目中一般会封装为自己的返回体。
        int pageNum = pageInfo.getPageNum();
        int pageSize = pageInfo.getPageSize();
        long total = pageInfo.getTotal();

        List<Project> result = pageInfo.getResult();

        return pageInfo;

    }
}
