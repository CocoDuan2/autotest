package com.xingxing.user.pojo;

import lombok.Data;
import net.sf.oval.constraint.NotNull;

import javax.persistence.Id;

@Data
public class ApiHistory {

    @NotNull(message = "接口id不能为空")
    @Id
    private String id;
    @NotNull(message = "项目id不能为空")

    private String interfaceId;
    private String requestType;
    private String requestAddress;
    private String httpCode;
    private String operationTime;


}
