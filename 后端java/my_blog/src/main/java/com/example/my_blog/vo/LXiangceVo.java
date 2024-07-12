package com.example.my_blog.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class LXiangceVo implements Serializable {

    private Integer id;

    private String xcImages;

    private String xcText;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date xcCtime;

    private Integer xcType;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getXcImages() {
        return xcImages;
    }

    public void setXcImages(String xcImages) {
        this.xcImages = xcImages;
    }

    public String getXcText() {
        return xcText;
    }

    public void setXcText(String xcText) {
        this.xcText = xcText;
    }

    public Date getXcCtime() {
        return xcCtime;
    }

    public void setXcCtime(Date xcCtime) {
        this.xcCtime = xcCtime;
    }

    public Integer getXcType() {
        return xcType;
    }

    public void setXcType(Integer xcType) {
        this.xcType = xcType;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "LXiangceVo{" +
                "id=" + id +
                ", xcImages='" + xcImages + '\'' +
                ", xcText='" + xcText + '\'' +
                ", xcCtime=" + xcCtime +
                ", xcType=" + xcType +
                '}';
    }
}
