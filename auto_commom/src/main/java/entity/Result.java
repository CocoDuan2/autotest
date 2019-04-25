package entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 响应结果封装的实体类
 */
@Data
public class Result implements Serializable{

    private boolean flag;
    private Integer code;
    private String msg;
    private Object data;

    public Result() {

    }

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    public Result(boolean flag, Integer code, String msg, Object data) {
        this.flag = flag;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


}
