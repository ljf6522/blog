package com.example.my_blog.vo;

import com.example.my_blog.model.LArticle;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class LCategoryVo implements Serializable {
    private Integer id;

    private String categoryName;

    private String categoryImage;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    private List<ArticleRecommendVO> lArticles;

    private static final long serialVersionUID = 1L;


    @Override
    public String toString() {
        return "LCategoryVo{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", categoryImage='" + categoryImage + '\'' +
                ", createTime=" + createTime +
                ", lArticles=" + lArticles +
                '}';
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<ArticleRecommendVO> getlArticles() {
        return lArticles;
    }

    public void setlArticles(List<ArticleRecommendVO> lArticles) {
        this.lArticles = lArticles;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
