package com.xingxing.user.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Case implements Serializable {
    public String id;
    public String case_name;
    public String description;
    public String group_id;
    public String project_id;
    public Integer page;
    public String userName;
    public String operationTime;

    private List<String> ids;

}
