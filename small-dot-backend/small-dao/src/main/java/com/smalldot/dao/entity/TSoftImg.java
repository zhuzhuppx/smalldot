package com.smalldot.dao.entity;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
/**
 * <p>
 * t_soft_img 软件图片表
 * </p>
 *
 * @author siyuan.zhu
 * @since 2020-02-24
 */
public class TSoftImg implements Serializable {

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
     * img_url 图片链接
     */
    private String imgUrl;

    /**
     * soft_id
     */
    private String softId;

    /**
     * img_desc 图片描述
     */
    private String imgDesc;

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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSoftId() {
        return softId;
    }

    public void setSoftId(String softId) {
        this.softId = softId;
    }

    public String getImgDesc() {
        return imgDesc;
    }

    public void setImgDesc(String imgDesc) {
        this.imgDesc = imgDesc;
    }

    @Override
    public String toString() {
        return "TSoftImg{" +
        ", revision=" + revision +
        ", createdBy=" + createdBy +
        ", createdTime=" + createdTime +
        ", updatedBy=" + updatedBy +
        ", updatedTime=" + updatedTime +
        ", id=" + id +
        ", imgUrl=" + imgUrl +
        ", softId=" + softId +
        ", imgDesc=" + imgDesc +
        "}";
    }
}
