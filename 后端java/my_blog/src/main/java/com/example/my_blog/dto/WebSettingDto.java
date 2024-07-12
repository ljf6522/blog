package com.example.my_blog.dto;

import java.io.Serializable;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/10/15
 */
public class WebSettingDto implements Serializable {
    private Integer id;
    private String webNotice;
    private String webName;
    private String webSignature;
    private String themeColor;
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

    public String getWebName() {
        return webName;
    }

    public void setWebName(String webName) {
        this.webName = webName;
    }

    public String getWebSignature() {
        return webSignature;
    }

    public void setWebSignature(String webSignature) {
        this.webSignature = webSignature;
    }

    public String getThemeColor() {
        return themeColor;
    }

    public void setThemeColor(String themeColor) {
        this.themeColor = themeColor;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "WebSettingDto{" +
                "id=" + id +
                ", webNotice='" + webNotice + '\'' +
                ", webName='" + webName + '\'' +
                ", webSignature='" + webSignature + '\'' +
                ", themeColor='" + themeColor + '\'' +
                '}';
    }
}
