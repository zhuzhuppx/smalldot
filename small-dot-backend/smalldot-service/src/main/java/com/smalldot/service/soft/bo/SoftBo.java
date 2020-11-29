package com.smalldot.service.soft.bo;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class SoftBo {

    private String id;

    /**
     * soft_name 名称
     */
    @NotBlank(message="软件名称不能为空")
    private String softName;

    /**
     * soft_desc 说明
     */
    @NotBlank(message="软件说明不能为空")
    private String softDesc;

    /**
     * website 官网
     */
    @NotBlank(message="官网不能为空")
    private String website;

    /**
     * url 下载地址
     */
    @NotBlank(message="下载地址不能为空")
    private String url;

    /**
     * icon 图标
     */
    @NotBlank(message="图标不能为空")
    private String icon;
    private List<SoftImgBo> imgs;

    private SoftCategoryBo category;
    @NotBlank(message="类别不能为空")
    private String categoryId;

    public SoftCategoryBo getCategory() {
        return category;
    }

    public void setCategory(SoftCategoryBo category) {
        this.category = category;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public List<SoftImgBo> getImgs() {
        return imgs;
    }

    public void setImgs(List<SoftImgBo> imgs) {
        this.imgs = imgs;
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
}
