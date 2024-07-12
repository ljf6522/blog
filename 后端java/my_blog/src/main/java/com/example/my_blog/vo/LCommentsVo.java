package com.example.my_blog.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/9/10
 */
public class LCommentsVo implements Serializable {
    private Integer id;

    private String cmNickname;

    private String cmEmail;

    private String cmQq;

    private String cmText;

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date cmTime;

    private Integer cmZan;

//    private Boolean cmDelete;

    private Integer articleId;

    private Integer cmParents;

    private List<LCommentsVo> lCommentsVos;

    public List<LCommentsVo> getlCommentsVos() {
        return lCommentsVos;
    }

    public void setlCommentsVos(List<LCommentsVo> lCommentsVos) {
        this.lCommentsVos = lCommentsVos;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCmNickname() {
        return cmNickname;
    }

    public void setCmNickname(String cmNickname) {
        this.cmNickname = cmNickname;
    }

    public String getCmEmail() {
        return cmEmail;
    }

    public void setCmEmail(String cmEmail) {
        this.cmEmail = cmEmail;
    }

    public String getCmQq() {
        return cmQq;
    }

    public void setCmQq(String cmQq) {
        this.cmQq = cmQq;
    }

    public String getCmText() {
        return cmText;
    }

    public void setCmText(String cmText) {
        this.cmText = cmText;
    }

    public Date getCmTime() {
        return cmTime;
    }

    public void setCmTime(Date cmTime) {
        this.cmTime = cmTime;
    }

    public Integer getCmZan() {
        return cmZan;
    }

    public void setCmZan(Integer cmZan) {
        this.cmZan = cmZan;
    }

//    public Boolean getCmDelete() {
//        return cmDelete;
//    }
//
//    public void setCmDelete(Boolean cmDelete) {
//        this.cmDelete = cmDelete;
//    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getCmParents() {
        return cmParents;
    }

    public void setCmParents(Integer cmParents) {
        this.cmParents = cmParents;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "LCommentsVo{" +
                "id=" + id +
                ", cmNickname='" + cmNickname + '\'' +
                ", cmEmail='" + cmEmail + '\'' +
                ", cmQq='" + cmQq + '\'' +
                ", cmText='" + cmText + '\'' +
                ", cmTime=" + cmTime +
                ", cmZan=" + cmZan +
                ", articleId=" + articleId +
                ", cmParents=" + cmParents +
                ", lCommentsVos=" + lCommentsVos +
                '}';
    }
}
