package com.xingxing.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ProjectInfoDTO implements Serializable {
    private Date LastUpdateTime;
    private Integer apiCount;//接口数量
    private Date createTime;
    private String description;
    private Integer dynamicCount;//动态数量
    private String id;
    private Integer memberCount;//成员数量
    private String name;
    private String status;
    private String type;
    private String user;
    private String version;
}
