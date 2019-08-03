package com.xingxing.user.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseDTO implements Serializable {
    private String name;
    private String value;
    /**
     * 描述
     */
    private String description;

    /**
     * 必返回?
     */
    private String required;

    /**
     * 参数类型
     */
    private String _type;

}
