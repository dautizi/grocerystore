package com.grocerystore.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="image_item")
public class ItemImage {

    private static final long serialVersionUID = -7988799579036225110L;

    @Id
    @Column(name="id", unique=true, nullable=false)
    private long id;

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

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="images") // id_item as foreign key
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

    @Override
    public String toString() {
        return "ItemImage [id=" + id + ", title=" + title + ", alt=" + alt
                + ", cssClass=" + cssClass + ", mediaType=" + mediaType
                + ", mediaPath=" + mediaPath + ", mediaUrl=" + mediaUrl
                + ", prg=" + prg + ", status=" + status + ", item=" + item
                + "]";
    }

}
