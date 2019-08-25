package com.xingxing.user.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class ApiDTO implements Serializable {
    private String id;
    /**
     * 接口地址
     */
    private String apiAddress;
    /**
     * 分组ID
     */
    private String apiGroupLevelFirst_id;
    /**
     * mock内容
     */
    private String data;
    /**
     *
     */
    private String description;
    /**
     * 请求头集
     */
    List<HeadDTO> headDict;
    /**
     * http/https
     */
    private String httpType;
    /**
     * mock
     */
    private String mockCode;
    /**
     * mock
     */
    private String mockStatus;
    /**
     * 接口名
     */
    private String name;
    /**
     * 项目ID
     */
    private String project_id;
    /**
     * 请求参数集
     */
    List<RequestDTO> requestList;
    /**
     * 请求参数方式
     */
    private String requestParameterType;
    /**
     * 请求方式
     */
    private String requestType;
    /**
     * 响应结果集
     */
    List<ResponseDTO> responseList;
    /**
     * 是否启用
     */
    private String status;

}
