package com.example.my_blog.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class LToolType implements Serializable {
    private Integer id;
    private String typeName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    private List<LTool> tools;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<LTool> getTools() {
        return tools;
    }

    public void setTools(List<LTool> tools) {
        this.tools = tools;
    }

    @Override
    public String toString() {
        return "LToolType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", createTime=" + createTime +
                ", tools=" + tools +
                '}';
    }
}
