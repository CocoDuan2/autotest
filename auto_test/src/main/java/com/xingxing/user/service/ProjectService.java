package com.xingxing.user.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Strings;
import com.xingxing.user.dao.ProjectDao;
import com.xingxing.user.dto.ProjectInfoDTO;
import com.xingxing.user.pojo.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProjectService {


    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 若不存在主键则新增,存在则更新,新增,更新,删除复用接口
     *
     * @param project
     */
    public void addProject(Project project) {
        if (Strings.isNullOrEmpty(project.getId())) {
            project.setId(idWorker.nextId() + "");
        } else {
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            project.setLastUpdateTime(format);
        }
        projectDao.save(project);


    }

    public Page<Project> getProjectPageList(Project project, Integer page, Integer size) {

        //分页并查询

        Page<Project> pageInfo = PageHelper.startPage(page, size);
        List<Project> projectList;
        if (Strings.isNullOrEmpty(project.getProjectName())) {
            projectList = projectDao.findAll();
        } else {
            projectList = projectDao.findByProjectName(project.getProjectName());
        }


        //获取分页信息演示, 实际项目中一般会封装为自己的返回体。
        int pageNum = pageInfo.getPageNum();
        int pageSize = pageInfo.getPageSize();
        long total = pageInfo.getTotal();

        List<Project> result = pageInfo.getResult();

        return pageInfo;

    }


    public void delProject(List<String> ids) {
        projectDao.delProject(ids);

    }

    /**
     *  项目详情
     * @param project_id
     * @return
     */
    public ProjectInfoDTO projectInfo(String project_id) {
        ProjectInfoDTO projectInfoDTO = projectDao.projectInfo(project_id);

        Integer apiCount = projectDao.apiCount(project_id);
        projectInfoDTO.setApiCount(apiCount);

        //Integer dynamicCount = projectDao.dynamicCount(project_id);
        projectInfoDTO.setDynamicCount(0);

        //Integer memberCount = projectDao.memberCount(project_id);
        projectInfoDTO.setMemberCount(0);
        return projectInfoDTO;
    }
}
