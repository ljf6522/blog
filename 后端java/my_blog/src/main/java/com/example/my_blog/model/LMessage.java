package com.example.my_blog.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class LMessage implements Serializable {

    private Integer id;


    private String nickname;


    private String messageQq;

    private String messageContent;

    private String ipAddress;

    private String ipSource;

    private Integer isCheck;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    private Date updateTime;

    private String bgcolor;

    private String fontcolor;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMessageQq() {
        return messageQq;
    }

    public void setMessageQq(String messageQq) {
        this.messageQq = messageQq;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIpSource() {
        return ipSource;
    }

    public void setIpSource(String ipSource) {
        this.ipSource = ipSource;
    }

    public Integer getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Integer isCheck) {
        this.isCheck = isCheck;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getBgcolor() {
        return bgcolor;
    }

    public void setBgcolor(String bgcolor) {
        this.bgcolor = bgcolor;
    }

    public String getFontcolor() {
        return fontcolor;
    }

    public void setFontcolor(String fontcolor) {
        this.fontcolor = fontcolor;
    }

    @Override
    public String toString() {
        return "LMessage{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", messageQq='" + messageQq + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", ipSource='" + ipSource + '\'' +
                ", isCheck=" + isCheck +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", bgcolor='" + bgcolor + '\'' +
                ", fontcolor='" + fontcolor + '\'' +
                '}';
    }
}