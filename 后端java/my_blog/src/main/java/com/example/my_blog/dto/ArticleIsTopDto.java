package com.example.my_blog.dto;

import java.io.Serializable;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/9/21
 */
public class ArticleIsTopDto implements Serializable {
    private Integer id;

    private Integer isTop;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "ArticleIsTopDtl{" +
                "id=" + id +
                ", isTop=" + isTop +
                '}';
    }
}
