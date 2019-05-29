package com.xingxing.user.pojo;

import lombok.Data;
import net.sf.oval.constraint.NotNull;

import javax.persistence.Id;


@Data
public class Interface {

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
    private String requestParamterType;
    private String httpType;

}
