package com.grocerystore.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@Entity
@Table(name="image")
public class Image {

    @Id
    @Column(name="id", unique=true, nullable=false)
    private long id;

    @Size(min=3, max=150)
    @Column(name = "title", nullable=false)
    private String title;

    @Size(min=3, max=20)
    @Column(name = "media_type", nullable=true)
    private String mediaType;

    @Size(min=3, max=100)
    @Column(name = "abs_path", nullable=true)
    private String absPath;

    @Size(min=3, max=200)
    @Column(name = "extension", nullable=false)
    private String extension;

    @Type(type="timestamp")
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @Transient
    private String    createdAtFormat;

    @Type(type="timestamp")
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @Transient
    private String    updatedAtFormat;

    @Column(name = "status", nullable=false, columnDefinition="int default '1'")
    private int status; // default 1

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

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getAbsPath() {
        return absPath;
    }

    public void setAbsPath(String absPath) {
        this.absPath = absPath;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAtFormat() {
        return createdAtFormat;
    }

    public void setCreatedAtFormat(String createdAtFormat) {
        this.createdAtFormat = createdAtFormat;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAtFormat() {
        return updatedAtFormat;
    }

    public void setUpdatedAtFormat(String updatedAtFormat) {
        this.updatedAtFormat = updatedAtFormat;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Image [id=" + id + ", title=" + title + ", mediaType="
                + mediaType + ", absPath=" + absPath + ", extension="
                + extension + ", createdAt=" + createdAt + ", createdAtFormat="
                + createdAtFormat + ", updatedAt=" + updatedAt
                + ", updatedAtFormat=" + updatedAtFormat + ", status=" + status
                + "]";
    }

}
