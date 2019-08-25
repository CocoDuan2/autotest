package com.xingxing.user.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OldApiAddCaseDTO implements Serializable {
    private String project_id;
    private String case_id;
    private List<String> api_ids;
}
