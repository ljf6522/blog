package com.example.my_blog.vo;

import com.example.my_blog.model.LArticle;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class LTagVo implements Serializable {
    private Integer id;

    private String tagName;

    private String tagColor;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    private Integer articleLang;

    private List<ArticleRecommendVO> articleList;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagColor() {
        return tagColor;
    }

    public void setTagColor(String tagColor) {
        this.tagColor = tagColor;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getArticleLang() {
        return articleLang;
    }

    public void setArticleLang(Integer articleLang) {
        this.articleLang = articleLang;
    }

    public List<ArticleRecommendVO> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<ArticleRecommendVO> articleList) {
        this.articleList = articleList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "LTagVo{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                ", tagColor='" + tagColor + '\'' +
                ", createTime=" + createTime +
                ", articleLang=" + articleLang +
                ", articleList=" + articleList +
                '}';
    }
}
