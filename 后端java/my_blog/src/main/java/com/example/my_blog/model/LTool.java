package com.example.my_blog.model;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

public class LTool implements Serializable {
    private Integer id;
    private String toolName;
    private String toolLogo;
    private String toolIntroduce;
    private String toolLink;
    private Integer type;
    private Integer ifDelete;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public String getToolLogo() {
        return toolLogo;
    }

    public void setToolLogo(String toolLogo) {
        this.toolLogo = toolLogo;
    }

    public String getToolIntroduce() {
        return toolIntroduce;
    }

    public void setToolIntroduce(String toolIntroduce) {
        this.toolIntroduce = toolIntroduce;
    }

    public String getToolLink() {
        return toolLink;
    }

    public void setToolLink(String toolLink) {
        this.toolLink = toolLink;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIfDelete() {
        return ifDelete;
    }

    public void setIfDelete(Integer ifDelete) {
        this.ifDelete = ifDelete;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "LTool{" +
                "id=" + id +
                ", toolName='" + toolName + '\'' +
                ", toolLogo='" + toolLogo + '\'' +
                ", toolIntroduce='" + toolIntroduce + '\'' +
                ", toolLink='" + toolLink + '\'' +
                ", type=" + type +
                ", ifDelete=" + ifDelete +
                ", createTime=" + createTime +
                '}';
    }
}
