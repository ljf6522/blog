package com.example.my_blog.dto;

import com.example.my_blog.model.LCategory;
import com.example.my_blog.model.LTag;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class LArticleDto implements Serializable {

    private Integer userId;

    private Integer id;

    private Integer categoryId;

    private String articleCover;

    private String articleTitle;

    private Integer articleType;

    private Integer isTop;

    private Integer isDelete;

    private Integer isRecommend;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private Integer zan;

    private Integer reading;

    private String articleText;

    private Integer lCategory;

    private List<LTag> lTags;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "LArticleDto{" +
                "id="+id+
                "userId=" + userId +
                ", categoryId=" + categoryId +
                ", articleCover='" + articleCover + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleType=" + articleType +
                ", isTop=" + isTop +
                ", isDelete=" + isDelete +
                ", isRecommend=" + isRecommend +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", zan=" + zan +
                ", reading=" + reading +
                ", articleText='" + articleText + '\'' +
                ", lCategory=" + lCategory +
                ", lTags=" + lTags +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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

    public Integer getArticleType() {
        return articleType;
    }

    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getZan() {
        return zan;
    }

    public void setZan(Integer zan) {
        this.zan = zan;
    }

    public Integer getReading() {
        return reading;
    }

    public void setReading(Integer reading) {
        this.reading = reading;
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    public Integer getlCategory() {
        return lCategory;
    }

    public void setlCategory(Integer lCategory) {
        this.lCategory = lCategory;
    }

    public List<LTag> getlTags() {
        return lTags;
    }

    public void setlTags(List<LTag> lTags) {
        this.lTags = lTags;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }




}
