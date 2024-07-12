package com.example.my_blog.common;

//    返回类
public class Result<T> {

    //    返回状态码
    private Integer code;
    //    返回信息
    private String message;
    //    内容数据
    private T data;

    public Result() {
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result success(){
        Result result=new Result();
        return result;
    }
    public static Result error(){
        Result result=new Result();
        return result;
    }
    public  Result code(Integer code){
        this.setCode(code);
        return this;
    }

    public  Result message(String message){
        this.setMessage(message);
        return this;
    }

    public  Result codeAndMessage(ResultInfo resultInfo){
        this.setCode(resultInfo.getCode());
        this.setMessage(resultInfo.getMessage());
        return this;
    }
    public  Result codeAndMessage(Integer code,String message){
        this.setCode(code);
        this.setMessage(message);
        return this;
    }

    public Result data(T data){
        this.setData(data);
        return this;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
