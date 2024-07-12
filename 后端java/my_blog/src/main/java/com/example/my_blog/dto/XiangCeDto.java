package com.example.my_blog.dto;

import java.io.Serializable;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/10/8
 */
public class XiangCeDto implements Serializable {
    private Integer id;
    private Integer xcDelete;
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getXcDelete() {
        return xcDelete;
    }

    public void setXcDelete(Integer xcDelete) {
        this.xcDelete = xcDelete;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "XiangCeDto{" +
                "id=" + id +
                ", xcDelete=" + xcDelete +
                '}';
    }
}
