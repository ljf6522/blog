package com.example.my_blog.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/9/15
 */
public class RecentCommentVO {
    private Integer id;

    private String cmNickname;

    private String cmQq;

    private String cmText;

    //    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date cmTime;

    private Integer articleId;

    private String articleTitle;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCmNickname() {
        return cmNickname;
    }

    public void setCmNickname(String cmNickname) {
        this.cmNickname = cmNickname;
    }

    public String getCmQq() {
        return cmQq;
    }

    public void setCmQq(String cmQq) {
        this.cmQq = cmQq;
    }

    public String getCmText() {
        return cmText;
    }

    public void setCmText(String cmText) {
        this.cmText = cmText;
    }

    public Date getCmTime() {
        return cmTime;
    }

    public void setCmTime(Date cmTime) {
        this.cmTime = cmTime;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    @Override
    public String toString() {
        return "RecentCommentVO{" +
                "id=" + id +
                ", cmNickname='" + cmNickname + '\'' +
                ", cmQq='" + cmQq + '\'' +
                ", cmText='" + cmText + '\'' +
                ", cmTime=" + cmTime +
                ", articleId=" + articleId +
                ", articleTitle='" + articleTitle + '\'' +
                '}';
    }
}
