package com.example.my_blog.dto;

import java.io.Serializable;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/10/18
 */
public class LSettingNoticeDto implements Serializable {
    private Integer id;
    private String webNotice;
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWebNotice() {
        return webNotice;
    }

    public void setWebNotice(String webNotice) {
        this.webNotice = webNotice;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "LSettingNoticeDto{" +
                "id=" + id +
                ", webNotice='" + webNotice + '\'' +
                '}';
    }
}
