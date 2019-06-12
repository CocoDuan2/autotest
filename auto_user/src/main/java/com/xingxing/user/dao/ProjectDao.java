package com.xingxing.user.dao;


import com.xingxing.user.dto.ProjectInfoDTO;
import com.xingxing.user.pojo.Project;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProjectDao {

    @Select("select * from tb_project where and status = '1'")
    public List<Project> findAll();


    int save(Project project);


    @Select("select * from tb_project where project_name = #{projectName} and status = '1'")
    List<Project> findByProjectName(String projectName);


    @Delete("<script>" +
            "delete from tb_project where id in" +
            "<foreach collection='ids' open='(' item='id' separator=',' close=')'> #{id}</foreach>" +
            "</script>")
    void delProject(List<String> ids);


    @Select("SELECT id,project_name name,version,type,description,`status`,last_update_time LastUpdateTime,create_time createTime " +
            "FROM tb_project where id = #{project_id}")
    ProjectInfoDTO projectInfo(String project_id);

    @Select("select count(id) from tb_interface where project_id = #{project_id}")
    Integer apiCount(String project_id);

    @Select("select count(id) from tb_user_operation_log where project_id = #{project_id}")
    Integer dynamicCount(String project_id);

    @Select("select count(id) from tb_project_user where project_id = #{project_id}")
    Integer memberCount(String project_id);
}
