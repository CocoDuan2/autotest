package com.xingxing.user.pojo;

import com.xingxing.user.base.BaseEntity;
import lombok.Data;
import net.sf.oval.constraint.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
public class Project extends BaseEntity {


    @NotNull(message = "项目id不能为空")
    @Id
    private String id;

    @NotNull(message = "项目名不能为空")
    private String projectName;

    @NotNull(message = "版本不能为空")
    private String version;

    @NotNull(message = "属性不能为空")
    private String type;


    private String description;




}
