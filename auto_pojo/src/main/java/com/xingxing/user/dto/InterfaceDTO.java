package com.xingxing.user.dto;

import lombok.Data;
import net.sf.oval.constraint.NotNull;

import javax.persistence.Id;
import java.io.Serializable;

@Data
public class InterfaceDTO implements Serializable {

    private String id;

    @NotNull(message = "项目id不能为空")
    private String project_id;

    private String groupId;

    private String name;

    private String requestType;
    private String apiAddress;
    private String mockStatus;

    private String userName;
    private String operationTime;
    private String apiGroupLevelFirst_id;
    private Integer page;
}


