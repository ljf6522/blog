package com.example.my_blog.common;

// 枚举了一些常用操作码

public enum ResultInfo {

    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    GLOBAL_ERROR(101,"系统繁忙"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403,"没有权限"),
    VALIDATE_FAILED(404, "参数检验失败");


    private Integer code;
    private String message;


    ResultInfo(Integer code, String message){
        this.code=code;
        this.message=message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
