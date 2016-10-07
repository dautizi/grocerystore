package com.grocerystore.model;

public class ItemImage {

    private Integer id;
    private String idItem;
    private String title;
    private String alt;
    private String cssClass;
    private String mediaType;
    private String mediaPath;
    private String mediaUrl;

    private int prg;
    private int status;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getIdItem() {
        return idItem;
    }
    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAlt() {
        return alt;
    }
    public void setAlt(String alt) {
        this.alt = alt;
    }
    public String getCssClass() {
        return cssClass;
    }
    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }
    public String getMediaType() {
        return mediaType;
    }
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }
    public String getMediaPath() {
        return mediaPath;
    }
    public void setMediaPath(String mediaPath) {
        this.mediaPath = mediaPath;
    }
    public String getMediaUrl() {
        return mediaUrl;
    }
    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }
    public int getPrg() {
        return prg;
    }
    public void setPrg(int prg) {
        this.prg = prg;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ItemImage [id=" + id + ", idItem=" + idItem + ", title=" + title
                + ", alt=" + alt + ", cssClass=" + cssClass + ", mediaType="
                + mediaType + ", mediaPath=" + mediaPath + ", mediaUrl="
                + mediaUrl + ", prg=" + prg + ", status=" + status + "]";
    }

}
