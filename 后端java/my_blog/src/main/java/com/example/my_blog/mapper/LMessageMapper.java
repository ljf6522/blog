package com.example.my_blog.mapper;

import com.example.my_blog.model.LMessage;
import com.example.my_blog.model.LMessageExample;
import java.util.List;

import com.example.my_blog.vo.LMessageVo;
import org.apache.ibatis.annotations.Param;

public interface LMessageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table l_message
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    int countByExample(LMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table l_message
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    int deleteByExample(LMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table l_message
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table l_message
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    int insert(LMessage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table l_message
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    int insertSelective(LMessage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table l_message
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    List<LMessage> selectByExample(LMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table l_message
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    LMessage selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table l_message
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    int updateByExampleSelective(@Param("record") LMessage record, @Param("example") LMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table l_message
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    int updateByExample(@Param("record") LMessage record, @Param("example") LMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table l_message
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    int updateByPrimaryKeySelective(LMessage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table l_message
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    int updateByPrimaryKey(LMessage record);

    List<LMessageVo> getMessageVoList();
}