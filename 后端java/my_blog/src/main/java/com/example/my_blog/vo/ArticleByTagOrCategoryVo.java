package com.example.my_blog.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ArticleByTagOrCategoryVo implements Serializable {
    /**
     * 文章id
     */
    private Integer id;

    /**
     * 文章标题
     */
    private String articleTitle;

    private String articleCover;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    private Integer zan;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleCover() {
        return articleCover;
    }

    public void setArticleCover(String articleCover) {
        this.articleCover = articleCover;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getZan() {
        return zan;
    }

    public void setZan(Integer zan) {
        this.zan = zan;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "ArticleByTagOrCategoryVo{" +
                "id=" + id +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleCover='" + articleCover + '\'' +
                ", createTime=" + createTime +
                ", zan=" + zan +
                '}';
    }
}
