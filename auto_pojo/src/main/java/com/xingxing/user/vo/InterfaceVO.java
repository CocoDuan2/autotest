package com.xingxing.user.vo;

import net.sf.oval.constraint.NotNull;

import javax.persistence.Id;

public class InterfaceVO {

    @NotNull(message = "接口id不能为空")
    @Id
    private String id;
    @NotNull(message = "项目id不能为空")
    private String projectId;
    private String groupId;
    @NotNull(message = "接口名不能为空")
    private String name;
    private String requestType;
    private String apiAddress;
    private String mockStatus;

    private String userName;
    private String operationTime;
}


