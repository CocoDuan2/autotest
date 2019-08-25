package com.xingxing.user.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserOperationLogDTO implements Serializable {
    private String id;
    private String projectId;
    private String userId;
    private String operationType;
    private String operationId;
    private String operationTime;
    private String operationUri;
}
