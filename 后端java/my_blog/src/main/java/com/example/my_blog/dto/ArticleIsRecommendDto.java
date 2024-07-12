package com.example.my_blog.dto;

import java.io.Serializable;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/9/21
 */
public class ArticleIsRecommendDto implements Serializable {
    private Integer id;

    private Integer isRecommend;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "ArticleIsRecommendDtl{" +
                "id=" + id +
                ", isRecommend=" + isRecommend +
                '}';
    }
}
