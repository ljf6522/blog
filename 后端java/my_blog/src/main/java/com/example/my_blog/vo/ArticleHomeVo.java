package com.example.my_blog.vo;

import com.example.my_blog.model.LCategory;
import com.example.my_blog.model.LTag;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ArticleHomeVo  implements Serializable {
    private Integer id;

    private String articleCover;

    private String articleTitle;

    private String articleText;

//    置顶
    private Integer isTop;

//    推荐
    private Integer isRecommend;

    private LCategory lCategory;

    private List<LTag> lTags;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArticleCover() {
        return articleCover;
    }

    public void setArticleCover(String articleCover) {
        this.articleCover = articleCover;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    public LCategory getlCategory() {
        return lCategory;
    }

    public void setlCategory(LCategory lCategory) {
        this.lCategory = lCategory;
    }

    public List<LTag> getlTags() {
        return lTags;
    }

    public void setlTags(List<LTag> lTags) {
        this.lTags = lTags;
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
        return "ArticleHomeVo{" +
                "id=" + id +
                ", articleCover='" + articleCover + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleText='" + articleText + '\'' +
                ", isTop=" + isTop +
                ", isRecommend=" + isRecommend +
                ", lCategory=" + lCategory +
                ", lTags=" + lTags +
                ", createTime=" + createTime +
                '}';
    }
}
