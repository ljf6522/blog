package com.example.my_blog.dto;

import java.io.Serializable;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/9/21
 */
public class ArticleDeleteDto implements Serializable {
    private Integer id;

    private Integer isDelete;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "ArticleDeleteVo{" +
                "id=" + id +
                ", isDelete=" + isDelete +
                '}';
    }
}
