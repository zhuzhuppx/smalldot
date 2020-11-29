package com.smalldot.dao.entity;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
/**
 * <p>
 * t_soft_data 软件信息表
 * </p>
 *
 * @author siyuan.zhu
 * @since 2020-03-01
 */
public class TSoftData implements Serializable {

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
     * ID
     */
    @TableId("ID")
    private String id;

    /**
     * soft_name
     */
    private String softName;

    /**
     * soft_desc
     */
    private String softDesc;

    /**
     * website
     */
    private String website;

    /**
     * url
     */
    private String url;

    /**
     * icon
     */
    private String icon;

    /**
     * category_id
     */
    private String categoryId;

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

    public String getSoftName() {
        return softName;
    }

    public void setSoftName(String softName) {
        this.softName = softName;
    }

    public String getSoftDesc() {
        return softDesc;
    }

    public void setSoftDesc(String softDesc) {
        this.softDesc = softDesc;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "TSoftData{" +
        ", revision=" + revision +
        ", createdBy=" + createdBy +
        ", createdTime=" + createdTime +
        ", updatedBy=" + updatedBy +
        ", updatedTime=" + updatedTime +
        ", id=" + id +
        ", softName=" + softName +
        ", softDesc=" + softDesc +
        ", website=" + website +
        ", url=" + url +
        ", icon=" + icon +
        ", categoryId=" + categoryId +
        "}";
    }
}
