package com.xingxing.user.pojo;

import lombok.Data;
import net.sf.oval.constraint.NotNull;

import java.util.List;

@Data
public class Api {

    @NotNull(message = "Api id不能为空")
    private List<String> ids;


    @NotNull(message = "项目id 不能为空")
    private String project_id;
}

