package com.example.my_blog.dto;

import java.io.Serializable;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/12/12
 */
public class LRoleIsDisableDto implements Serializable {
    private Integer id;
    private Integer isDisable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }

    @Override
    public String toString() {
        return "LRoleIsDisableDto{" +
                "id=" + id +
                ", isDisable=" + isDisable +
                '}';
    }
}
