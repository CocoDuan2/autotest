package com.xingxing.user.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class HeadDTO implements Serializable {
    private String name;
    private String value;
}
