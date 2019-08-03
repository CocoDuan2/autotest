package com.xingxing.user.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RequestDTO implements Serializable {
    private String name;
    private String value;
    /**
     * 描述
     */
    private String description;
    /**
     * 必填?
     */
    private String required;
    /**
     * 输入限制
     */
    private String restrict;
    /**
     * 参数类型
     */
    private String _type;
}
