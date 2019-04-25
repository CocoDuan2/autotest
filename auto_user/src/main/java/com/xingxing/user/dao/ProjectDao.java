package com.xingxing.user.dao;

import com.xingxing.user.pojo.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProjectDao extends JpaRepository<Project,String>,JpaSpecificationExecutor<String>{

}
