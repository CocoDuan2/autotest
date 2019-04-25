package com.xingxing.user.pojo;

import lombok.Data;
import net.sf.oval.constraint.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tb_project")
public class Project implements Serializable{

    @Id
    private String id;

    @NotNull(message = "项目名不能为空")
    private String project_name;


    private String version;
    private String type;
    private String description;

    @NotNull(message = "项目状态不能为空")
    private String status;
    private String lastPpdateTime;
    private String createTime;


}
