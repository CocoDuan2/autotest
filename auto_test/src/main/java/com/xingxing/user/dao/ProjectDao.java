package com.xingxing.user.dao;


import com.xingxing.user.dto.ProjectInfoDTO;
import com.xingxing.user.pojo.Project;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProjectDao {

    @Select("select * from tb_project where status = '1'")
    public List<Project> findAll();


    @Insert("INSERT INTO tb_project (id,project_name,version,type,description,status,last_update_time,create_time) " +
            "VALUES (#{id,jdbcType=VARCHAR},#{projectName,jdbcType=VARCHAR},#{version,jdbcType=VARCHAR},#{type,jdbcType=VARCHAR},#{description,jdbcType=VARCHAR},#{status,jdbcType=VARCHAR}," +
            "#{lastUpdateTime,jdbcType=TIMESTAMP},#{createTime,jdbcType=TIMESTAMP})" +
            "ON DUPLICATE KEY UPDATE project_name = #{projectName},type = #{type},description = #{description},status = #{status},last_update_time = #{lastUpdateTime}")
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

    @Select("select IFNULL(count(id),0) from tb_interface where project_id = #{project_id}")
    Integer apiCount(String project_id);

    @Select("")
    Integer dynamicCount(String project_id);

    @Select("")
    Integer memberCount(String project_id);
}
