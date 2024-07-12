package com.example.my_blog.vo;


import java.io.Serializable;

/**
 * 文章上下篇
 *
 * @author ican
 */

public class ArticlePaginationVO implements Serializable {

    /**
     * 文章id
     */

    private Integer id;

    /**
     * 文章缩略图
     */

    private String articleCover;

    /**
     * 文章标题
     */
    private String articleTitle;

    private String articleText;

    private static final long serialVersionUID = 1L;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    @Override
    public String toString() {
        return "ArticlePaginationVO{" +
                "id=" + id +
                ", articleCover='" + articleCover + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                '}';
    }
}
