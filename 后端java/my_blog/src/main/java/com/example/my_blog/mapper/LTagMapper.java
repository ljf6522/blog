package com.example.my_blog.mapper;

import com.example.my_blog.model.LTag;
import com.example.my_blog.model.LTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LTagMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table l_tag
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    int countByExample(LTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table l_tag
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    int deleteByExample(LTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table l_tag
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table l_tag
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    int insert(LTag record);

    LTag ifRepeatTag(String tagName);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table l_tag
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    int insertSelective(LTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table l_tag
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    List<LTag> selectByExample(LTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table l_tag
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    LTag selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table l_tag
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    int updateByExampleSelective(@Param("record") LTag record, @Param("example") LTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table l_tag
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    int updateByExample(@Param("record") LTag record, @Param("example") LTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table l_tag
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    int updateByPrimaryKeySelective(LTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table l_tag
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    List<LTag> selectTagsBySearch(String search);

    int updateByPrimaryKey(LTag record);

//    获取文章时需拿到的标签列
    List<LTag> selectTagsByArticleId(Integer articleId);

    int deleteAllTag(List<Integer> ids);
}