package com.xingxing.user.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ProjectInfoDTO implements Serializable {
    private Date LastUpdateTime;
    /**
     * 接口数量
     */
    private Integer apiCount;
    private Date createTime;
    private String description;
    /**
     * 动态数量
     */
    private Integer dynamicCount;
    private String id;
    /**
     * 成员数量
     */
    private Integer memberCount;
    private String name;
    private String status;
    private String type;
    private String user;
    private String version;
    private String project_id;
    private List<String> ids;
}
