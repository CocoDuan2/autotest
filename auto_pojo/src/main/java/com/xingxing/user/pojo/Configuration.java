package com.xingxing.user.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Configuration implements Serializable {
    public String id;
    public String name;
    public String host;
    public String port;
    public String description;
    public String projectId;
    public String status;
}
