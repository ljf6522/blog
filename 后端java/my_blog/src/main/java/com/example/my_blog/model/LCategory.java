package com.example.my_blog.model;

import java.io.Serializable;
import java.util.Date;

public class LCategory implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column l_category.id
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column l_category.category_name
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    private String categoryName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column l_category.category_image
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    private String categoryImage;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column l_category.create_time
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column l_category.update_time
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table l_category
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column l_category.id
     *
     * @return the value of l_category.id
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column l_category.id
     *
     * @param id the value for l_category.id
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column l_category.category_name
     *
     * @return the value of l_category.category_name
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column l_category.category_name
     *
     * @param categoryName the value for l_category.category_name
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column l_category.category_image
     *
     * @return the value of l_category.category_image
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public String getCategoryImage() {
        return categoryImage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column l_category.category_image
     *
     * @param categoryImage the value for l_category.category_image
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column l_category.create_time
     *
     * @return the value of l_category.create_time
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column l_category.create_time
     *
     * @param createTime the value for l_category.create_time
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column l_category.update_time
     *
     * @return the value of l_category.update_time
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column l_category.update_time
     *
     * @param updateTime the value for l_category.update_time
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table l_category
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
        sb.append(", categoryName=").append(categoryName);
        sb.append(", categoryImage=").append(categoryImage);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}