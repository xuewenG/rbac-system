package cn.edu.hfut.rbac.backend.util.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author xuewenG
 * @date 2019/8/12 13:05
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message<T> {
    private String code;
    private String msg;
    private T data;

    @Override
    public String toString() {
        return "Message{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
