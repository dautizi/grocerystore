package com.grocerystore.model.configuration;

import org.springframework.beans.factory.BeanNameAware;

public class Config implements BeanNameAware {

    private String id;
    private String title;
    private String name;
    private String twitterName;
    private String baseUrl;
    private String adminBaseUrl;
    private String staticBaseUrl;
    private String icon;
    private String gigyaComments;
    private String gigyaApiKey;
    private String updateTime;

    private String mapLatitude;
    private String mapLongitude;
    private String mapZoom;
    private String mapApiKey;

    private String recaptchaSiteKey;
    private String recaptchaSecretKey;

    private String geolocationWS;

    public void setBeanName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTwitterName() {
        return twitterName;
    }

    public void setTwitterName(String twitterName) {
        this.twitterName = twitterName;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getAdminBaseUrl() {
        return adminBaseUrl;
    }

    public void setAdminBaseUrl(String adminBaseUrl) {
        this.adminBaseUrl = adminBaseUrl;
    }

    public String getGigyaComments() {
        return gigyaComments;
    }

    public void setGigyaComments(String gigyaComments) {
        this.gigyaComments = gigyaComments;
    }

    public String getGigyaApiKey() {
        return gigyaApiKey;
    }

    public void setGigyaApiKey(String gigyaApiKey) {
        this.gigyaApiKey = gigyaApiKey;
    }

    public String getStaticBaseUrl() {
        return staticBaseUrl;
    }

    public void setStaticBaseUrl(String staticBaseUrl) {
        this.staticBaseUrl = staticBaseUrl;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getMapLatitude() {
        return mapLatitude;
    }

    public void setMapLatitude(String mapLatitude) {
        this.mapLatitude = mapLatitude;
    }

    public String getMapLongitude() {
        return mapLongitude;
    }

    public void setMapLongitude(String mapLongitude) {
        this.mapLongitude = mapLongitude;
    }

    public String getGeolocationWS() {
        return geolocationWS;
    }

    public void setGeolocationWS(String geolocationWS) {
        this.geolocationWS = geolocationWS;
    }

    public String getMapZoom() {
        return mapZoom;
    }

    public void setMapZoom(String mapZoom) {
        this.mapZoom = mapZoom;
    }

    public String getRecaptchaSiteKey() {
        return recaptchaSiteKey;
    }

    public void setRecaptchaSiteKey(String recaptchaSiteKey) {
        this.recaptchaSiteKey = recaptchaSiteKey;
    }

    public String getRecaptchaSecretKey() {
        return recaptchaSecretKey;
    }

    public void setRecaptchaSecretKey(String recaptchaSecretKey) {
        this.recaptchaSecretKey = recaptchaSecretKey;
    }

    public String getMapApiKey() {
        return mapApiKey;
    }

    public void setMapApiKey(String mapApiKey) {
        this.mapApiKey = mapApiKey;
    }

    @Override
    public String toString() {
        return "Config [id=" + id + ", title=" + title + ", name=" + name
                + ", twitterName=" + twitterName + ", baseUrl=" + baseUrl
                + ", adminBaseUrl=" + adminBaseUrl + ", staticBaseUrl="
                + staticBaseUrl + ", icon=" + icon + ", gigyaComments="
                + gigyaComments + ", gigyaApiKey=" + gigyaApiKey
                + ", updateTime=" + updateTime + ", mapLatitude=" + mapLatitude
                + ", mapLongitude=" + mapLongitude + ", mapZoom=" + mapZoom
                + ", mapApiKey=" + mapApiKey + ", recaptchaSiteKey="
                + recaptchaSiteKey + ", recaptchaSecretKey="
                + recaptchaSecretKey + ", geolocationWS=" + geolocationWS + "]";
    }

}
