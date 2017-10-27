package com.snail.dao;

import com.snail.pojo.domain.ShareContent;
import com.snail.pojo.domain.ShareContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ShareContentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table share_content
     *
     * @mbggenerated
     */
    int countByExample(ShareContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table share_content
     *
     * @mbggenerated
     */
    int deleteByExample(ShareContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table share_content
     *
     * @mbggenerated
     */
    @Delete({
        "delete from `share_content`",
        "where `id` = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table share_content
     *
     * @mbggenerated
     */
    @Insert({
        "insert into `share_content` (`id`, `create_at`, ",
        "`update_at`, `content`)",
        "values (#{id,jdbcType=INTEGER}, #{createAt,jdbcType=TIMESTAMP}, ",
        "#{updateAt,jdbcType=TIMESTAMP}, #{content,jdbcType=LONGVARCHAR})"
    })
    int insert(ShareContent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table share_content
     *
     * @mbggenerated
     */
    int insertSelective(ShareContent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table share_content
     *
     * @mbggenerated
     */
    List<ShareContent> selectByExampleWithBLOBs(ShareContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table share_content
     *
     * @mbggenerated
     */
    List<ShareContent> selectByExample(ShareContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table share_content
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "`id`, `create_at`, `update_at`, `content`",
        "from `share_content`",
        "where `id` = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("ResultMapWithBLOBs")
    ShareContent selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table share_content
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ShareContent record, @Param("example") ShareContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table share_content
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") ShareContent record, @Param("example") ShareContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table share_content
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ShareContent record, @Param("example") ShareContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table share_content
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ShareContent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table share_content
     *
     * @mbggenerated
     */
    @Update({
        "update `share_content`",
        "set `create_at` = #{createAt,jdbcType=TIMESTAMP},",
          "`update_at` = #{updateAt,jdbcType=TIMESTAMP},",
          "`content` = #{content,jdbcType=LONGVARCHAR}",
        "where `id` = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(ShareContent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table share_content
     *
     * @mbggenerated
     */
    @Update({
        "update `share_content`",
        "set `create_at` = #{createAt,jdbcType=TIMESTAMP},",
          "`update_at` = #{updateAt,jdbcType=TIMESTAMP}",
        "where `id` = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ShareContent record);
}