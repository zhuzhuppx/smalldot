package com.smalldot.dao.entity;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
/**
 * <p>
 * 类别表 
 * </p>
 *
 * @author siyuan.zhu
 * @since 2020-03-01
 */
public class TSoftCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 乐观锁
     */
    @TableField("REVISION")
    private String revision;

    /**
     * 创建人
     */
    @TableField("CREATED_BY")
    private String createdBy;

    /**
     * 创建时间
     */
    @TableField("CREATED_TIME")
    private LocalDateTime createdTime;

    /**
     * 更新人
     */
    @TableField("UPDATED_BY")
    private String updatedBy;

    /**
     * 更新时间
     */
    @TableField("UPDATED_TIME")
    private LocalDateTime updatedTime;

    /**
     * id
     */
    private String id;

    /**
     * category_name
     */
    private String categoryName;

    /**
     * category_desc
     */
    private String categoryDesc;

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    @Override
    public String toString() {
        return "TSoftCategory{" +
        ", revision=" + revision +
        ", createdBy=" + createdBy +
        ", createdTime=" + createdTime +
        ", updatedBy=" + updatedBy +
        ", updatedTime=" + updatedTime +
        ", id=" + id +
        ", categoryName=" + categoryName +
        ", categoryDesc=" + categoryDesc +
        "}";
    }
}
