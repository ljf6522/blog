package com.example.my_blog.model;

import java.io.Serializable;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/9/18
 */
public class LWebSetting implements Serializable {
    private Integer id;
    private String webNotice;
    private String webName;
    private String webHomeImage;
    private String webSignature;
    private String webXcbgi;
    private String webSbbgi;
    private String webLybgi;
    private String webFriendbgi;
    private String webToolbgi;
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

    public String getWebHomeImage() {
        return webHomeImage;
    }

    public void setWebHomeImage(String webHomeImage) {
        this.webHomeImage = webHomeImage;
    }

    public String getWebSignature() {
        return webSignature;
    }

    public void setWebSignature(String webSignature) {
        this.webSignature = webSignature;
    }

    public String getWebXcbgi() {
        return webXcbgi;
    }

    public void setWebXcbgi(String webXcbgi) {
        this.webXcbgi = webXcbgi;
    }

    public String getWebSbbgi() {
        return webSbbgi;
    }

    public void setWebSbbgi(String webSbbgi) {
        this.webSbbgi = webSbbgi;
    }

    public String getWebLybgi() {
        return webLybgi;
    }

    public void setWebLybgi(String webLybgi) {
        this.webLybgi = webLybgi;
    }

    public String getThemeColor() {
        return themeColor;
    }

    public void setThemeColor(String themeColor) {
        this.themeColor = themeColor;
    }

    public String getWebFriendbgi() {
        return webFriendbgi;
    }

    public void setWebFriendbgi(String webFriendbgi) {
        this.webFriendbgi = webFriendbgi;
    }

    public String getWebToolbgi() {
        return webToolbgi;
    }

    public void setWebToolbgi(String webToolbgi) {
        this.webToolbgi = webToolbgi;
    }

    @Override
    public String toString() {
        return "LWebSetting{" +
                "id=" + id +
                ", webNotice='" + webNotice + '\'' +
                ", webName='" + webName + '\'' +
                ", webHomeImage='" + webHomeImage + '\'' +
                ", webSignature='" + webSignature + '\'' +
                ", webXcbgi='" + webXcbgi + '\'' +
                ", webSbbgi='" + webSbbgi + '\'' +
                ", webLybgi='" + webLybgi + '\'' +
                ", webFriendbgi='" + webFriendbgi + '\'' +
                ", themeColor='" + themeColor + '\'' +
                '}';
    }
}
