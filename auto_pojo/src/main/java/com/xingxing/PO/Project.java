package com.xingxing.PO;

import com.xingxing.PO.base.BaseEntity;
import lombok.Data;
import net.sf.oval.constraint.NotNull;

@Data
public class Project extends BaseEntity {


    @NotNull(message = "项目名不能为空")
    private String projectName;

    @NotNull(message = "版本不能为空")
    private String version;

    @NotNull(message = "属性不能为空")
    private String type;


    private String description;

    // @NotNull(message = "项目状态不能为空")


}
