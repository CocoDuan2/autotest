package com.xingxing.PO.base;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class BaseEntity {

    private String id;
    private String status = "1";
    private String lastUpdateTime;
    private String createTime;

    private String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

    public String getLastUpdateTime() {

        return getFormat();
    }

    public String getCreateTime() {
        return getFormat();
    }
}
