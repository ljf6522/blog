package com.example.my_blog.model;

import java.io.Serializable;

public class LArticleTag implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column l_article_tag.id
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column l_article_tag.article_id
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    private Integer articleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column l_article_tag.tag_id
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    private Integer tagId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table l_article_tag
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column l_article_tag.id
     *
     * @return the value of l_article_tag.id
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column l_article_tag.id
     *
     * @param id the value for l_article_tag.id
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column l_article_tag.article_id
     *
     * @return the value of l_article_tag.article_id
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column l_article_tag.article_id
     *
     * @param articleId the value for l_article_tag.article_id
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public LArticleTag setArticleId(Integer articleId) {
        this.articleId = articleId;
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column l_article_tag.tag_id
     *
     * @return the value of l_article_tag.tag_id
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public Integer getTagId() {
        return tagId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column l_article_tag.tag_id
     *
     * @param tagId the value for l_article_tag.tag_id
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public LArticleTag setTagId(Integer tagId) {
        this.tagId = tagId;
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table l_article_tag
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", articleId=").append(articleId);
        sb.append(", tagId=").append(tagId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}