package com.smalldot.dao.model;

import java.util.Date;

/**
 * 
 *
 * @author zhuzhu
 * @date 2020-11-29
 */
public class RCategory {
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
     * 备注
     */
    private String reamark;

    public RCategory(Long id, Integer revision, String createdBy, Date createdTime, String updatedBy, Date updatedTime, String name, String reamark) {
        this.id = id;
        this.revision = revision;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.updatedBy = updatedBy;
        this.updatedTime = updatedTime;
        this.name = name;
        this.reamark = reamark;
    }

    public RCategory() {
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

    public String getReamark() {
        return reamark;
    }

    public void setReamark(String reamark) {
        this.reamark = reamark == null ? null : reamark.trim();
    }
}