package com.snail.pojo.domain;

import java.util.Date;

public class ShareCategory {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column share_category.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column share_category.category_name
     *
     * @mbggenerated
     */
    private String categoryName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column share_category.create_at
     *
     * @mbggenerated
     */
    private Date createAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column share_category.update
     *
     * @mbggenerated
     */
    private Date update;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table share_category
     *
     * @mbggenerated
     */
    public ShareCategory(Integer id, String categoryName, Date createAt, Date update) {
        this.id = id;
        this.categoryName = categoryName;
        this.createAt = createAt;
        this.update = update;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table share_category
     *
     * @mbggenerated
     */
    public ShareCategory() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column share_category.id
     *
     * @return the value of share_category.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column share_category.id
     *
     * @param id the value for share_category.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column share_category.category_name
     *
     * @return the value of share_category.category_name
     *
     * @mbggenerated
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column share_category.category_name
     *
     * @param categoryName the value for share_category.category_name
     *
     * @mbggenerated
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column share_category.create_at
     *
     * @return the value of share_category.create_at
     *
     * @mbggenerated
     */
    public Date getCreateAt() {
        return createAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column share_category.create_at
     *
     * @param createAt the value for share_category.create_at
     *
     * @mbggenerated
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column share_category.update
     *
     * @return the value of share_category.update
     *
     * @mbggenerated
     */
    public Date getUpdate() {
        return update;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column share_category.update
     *
     * @param update the value for share_category.update
     *
     * @mbggenerated
     */
    public void setUpdate(Date update) {
        this.update = update;
    }
}