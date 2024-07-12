package com.example.my_blog.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/12/29
 */
public class LMessageVo implements Serializable {
    private Integer id;

    private String nickname;

    private String messageQq;

    private String messageContent;

    private String ipSource;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

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

    public String getIpSource() {
        return ipSource;
    }

    public void setIpSource(String ipSource) {
        this.ipSource = ipSource;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        return "LMessageVo{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", messageQq='" + messageQq + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", ipSource='" + ipSource + '\'' +
                ", createTime=" + createTime +
                ", bgcolor='" + bgcolor + '\'' +
                ", fontcolor='" + fontcolor + '\'' +
                '}';
    }
}
