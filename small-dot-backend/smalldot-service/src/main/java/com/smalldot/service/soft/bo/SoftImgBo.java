package com.smalldot.service.soft.bo;

public class SoftImgBo {

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
}
