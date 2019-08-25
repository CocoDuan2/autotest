package com.xingxing.user.pojo;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
public class Group implements Serializable {

    public String id;
    public String name;
    public String project_id;
    public Integer group_type;

}
