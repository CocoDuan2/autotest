package com.xingxing.user.service;


import com.xingxing.user.dao.ProjectDao;
import com.xingxing.user.pojo.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

@Service
public class ProjectService {


    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private IdWorker idWorker;

    public Project addProject(Project project) {

        project.setId(idWorker.nextId() + "");

        return projectDao.save(project);


    }

    public Page<Project> getProjectPageList(Project project, Integer pageNo, Integer size) {

        Example<Project> of = Example.of(project);
        Pageable pageable = new PageRequest(pageNo-1,size);
        Page<Project> all = projectDao.findAll(of, pageable);


        return all;
    }
}
