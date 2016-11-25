package com.grocerystore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="image_item")
public class ItemImage {

    @Id
    @Column(name="id", unique=true, nullable=false)
    private long id;

    @Column(name = "id_item", columnDefinition="long default '0'", nullable=false)
    private long idItem;

    @Column(name = "id_image", columnDefinition="long default '0'", nullable=false)
    private long idImage;

    @Size(min=3, max=150)
    @Column(name = "title", nullable = false)
    private String title;

    @Size(min=3, max=100)
    @Column(name = "alt", nullable = true)
    private String alt;

    @Size(min=3, max=100)
    @Column(name = "css_class", nullable = true)
    private String cssClass;

    @Size(min=3, max=20)
    @Column(name = "media_type", nullable = true)
    private String mediaType;

    @Size(min=3, max=100)
    @Column(name = "media_path", nullable = true)
    private String mediaPath;

    @Size(min=3, max=200)
    @Column(name = "media_url", nullable = false)
    private String mediaUrl;

    @Column(name = "prg", nullable = false, columnDefinition="int default '1'")
    private int prg;

    @Column(name = "status", nullable = false, columnDefinition="int default '1'")
    private int status; // default 1

    @ManyToOne
    @JoinColumn(name="id", referencedColumnName="id", insertable=false, updatable=false)
    private Item item;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
    public long getIdItem() {
        return idItem;
    }
    public void setIdItem(long idItem) {
        this.idItem = idItem;
    }
    public long getIdImage() {
        return idImage;
    }
    public void setIdImage(long idImage) {
        this.idImage = idImage;
    }

    @Override
    public String toString() {
        return "ItemImage [id=" + id + ", idItem=" + idItem + ", idImage="
                + idImage + ", title=" + title + ", alt=" + alt + ", cssClass="
                + cssClass + ", mediaType=" + mediaType + ", mediaPath="
                + mediaPath + ", mediaUrl=" + mediaUrl + ", prg=" + prg
                + ", status=" + status + ", item=" + item + "]";
    }
}
