package com.xingxing.user.dto;

import lombok.Data;
import net.sf.oval.constraint.NotNull;

import javax.persistence.Id;
import java.util.List;

@Data
public class HostDTO {

    @NotNull(message = "HOST id不能为空")
    private List<String> ids;
    

    @NotNull(message = "项目id不能为空")
    private String project_id;
}
