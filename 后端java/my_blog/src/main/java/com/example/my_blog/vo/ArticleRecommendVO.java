package com.example.my_blog.vo;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 推荐文章
 **/

public class ArticleRecommendVO  implements Serializable {

    /**
     * 文章id
     */
    private Integer id;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章缩略图
     */
    private String articleCover;

    private String articleText;

    /**
     * 发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;


    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "ArticleRecommendVO{" +
                "id=" + id +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleCover='" + articleCover + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}