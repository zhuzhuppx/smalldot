package com.smalldot.dao.model;

import java.util.Date;

/**
 * 
 *
 * @author zhuzhu
 * @date 2020-11-29
 */
public class RPoems {
    /**
     * id
     */
    private Long id;

    /**
     * 乐观锁
     */
    private Integer revision;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新人
     */
    private String updatedBy;

    /**
     * 更新时间
     */
    private Date updatedTime;

    /**
     * 名称
     */
    private String name;

    /**
     * 作者
     */
    private String author;

    /**
     * 作者标识
     */
    private Long authorId;

    /**
     * 年代
     */
    private String year;

    /**
     * 年代标识
     */
    private String yearId;

    /**
     * 类别
     */
    private String category;

    /**
     * 类别ID
     */
    private Long categoryId;

    /**
     * 富文本
     */
    private String richtxt;

    public RPoems(Long id, Integer revision, String createdBy, Date createdTime, String updatedBy, Date updatedTime, String name, String author, Long authorId, String year, String yearId, String category, Long categoryId) {
        this.id = id;
        this.revision = revision;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.updatedBy = updatedBy;
        this.updatedTime = updatedTime;
        this.name = name;
        this.author = author;
        this.authorId = authorId;
        this.year = year;
        this.yearId = yearId;
        this.category = category;
        this.categoryId = categoryId;
    }

    public RPoems(Long id, Integer revision, String createdBy, Date createdTime, String updatedBy, Date updatedTime, String name, String author, Long authorId, String year, String yearId, String category, Long categoryId, String richtxt) {
        this.id = id;
        this.revision = revision;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.updatedBy = updatedBy;
        this.updatedTime = updatedTime;
        this.name = name;
        this.author = author;
        this.authorId = authorId;
        this.year = year;
        this.yearId = yearId;
        this.category = category;
        this.categoryId = categoryId;
        this.richtxt = richtxt;
    }

    public RPoems() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getYearId() {
        return yearId;
    }

    public void setYearId(String yearId) {
        this.yearId = yearId == null ? null : yearId.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getRichtxt() {
        return richtxt;
    }

    public void setRichtxt(String richtxt) {
        this.richtxt = richtxt == null ? null : richtxt.trim();
    }
}