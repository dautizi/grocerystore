package com.grocerystore.model.configuration;

import javax.servlet.http.HttpServletRequest;

import com.grocerystore.controller.util.StringUtil;
import com.grocerystore.util.Constraint;

public class Log {

    public static final String LOG_ID = "logId";
    public static final String LOG_STATUS = "logStatus";
    public static final String LOG_IP_ADDRESS = "logIpAddress";
    public static final String LOG_PAGE_TYPE = "logPageType";
    public static final String ASS = "as";
    public static final String CITY = "city";
    public static final String COUNTRY = "country";
    public static final String COUNTRY_CODE = "countryCode";
    public static final String ISP = "isp";
    public static final String LATITUDE = "lat";
    public static final String LONGITUDE = "lon";
    public static final String ORG = "org";
    public static final String QUERY = "query";
    public static final String REGION = "region";
    public static final String REGION_NAME = "regionName";
    public static final String STATUS = "status";
    public static final String TIMEZONE = "timezone";
    public static final String ZIP = "zip";

    private Integer id;
    private String  ipAddress;
    private int     proxyAddress;
    private String  visitDate;
    private String  ipInfo;
    private String  abbrCountry;
    private String  country;
    private String  abbrRegion;
    private String  region;
    private String  city;
    private String  zipCode;
    private String  latitude;
    private String  longitude;
    private String  area;
    private String  metro;
    private String  timezone;
    private String  isp;
    private String  org;
    private String  ass;
    private int     active;
    private String  googleUrl;
    private String  query;
    private String  pageType;

    public Log() {}

    public Log(String ipAddress, int proxyAddress, String visitDate, int active) {
        this.ipAddress = ipAddress;
        this.proxyAddress = proxyAddress;
        this.visitDate = visitDate;
        this.active = active;
    }

    public Log(String ipAddress, int proxyAddress, String visitDate, String ipInfo) {
        this.ipAddress = ipAddress;
        this.proxyAddress = proxyAddress;
        this.visitDate = visitDate;
        this.ipInfo = ipInfo;

        StringUtil.enrichmentByInfo(this);
    }

    public static String getIp(HttpServletRequest request) {
        String ipAddress = request.getHeader(Constraint.PARAM_X_FORWARDED);
        // get IP
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getIpAddress() {
        return ipAddress;
    }
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    public int getProxyAddress() {
        return proxyAddress;
    }
    public void setProxyAddress(int proxyAddress) {
        this.proxyAddress = proxyAddress;
    }
    public String getVisitDate() {
        return visitDate;
    }
    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }
    public String getIpInfo() {
        return ipInfo;
    }
    public void setIpInfo(String ipInfo) {
        this.ipInfo = ipInfo;
    }
    public String getAbbrCountry() {
        return abbrCountry;
    }
    public void setAbbrCountry(String abbrCountry) {
        this.abbrCountry = abbrCountry;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getAbbrRegion() {
        return abbrRegion;
    }
    public void setAbbrRegion(String abbrRegion) {
        this.abbrRegion = abbrRegion;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public String getMetro() {
        return metro;
    }
    public void setMetro(String metro) {
        this.metro = metro;
    }
    public String getGoogleUrl() {
        return googleUrl;
    }
    public void setGoogleUrl(String googleUrl) {
        this.googleUrl = googleUrl;
    }
    public String getTimezone() {
        return timezone;
    }
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
    public String getIsp() {
        return isp;
    }
    public void setIsp(String isp) {
        this.isp = isp;
    }
    public String getOrg() {
        return org;
    }
    public void setOrg(String org) {
        this.org = org;
    }
    public String getAss() {
        return ass;
    }
    public void setAss(String ass) {
        this.ass = ass;
    }
    public int getActive() {
        return active;
    }
    public void setActive(int active) {
        this.active = active;
    }
    public String getQuery() {
        return query;
    }
    public void setQuery(String query) {
        this.query = query;
    }
    public String getPageType() {
        return pageType;
    }
    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    @Override
    public String toString() {
        return "Log [id=" + id + ", ipAddress=" + ipAddress + ", proxyAddress="
                + proxyAddress + ", visitDate=" + visitDate + ", ipInfo="
                + ipInfo + ", abbrCountry=" + abbrCountry + ", country="
                + country + ", abbrRegion=" + abbrRegion + ", region=" + region
                + ", city=" + city + ", zipCode=" + zipCode + ", latitude="
                + latitude + ", longitude=" + longitude + ", area=" + area
                + ", metro=" + metro + ", timezone=" + timezone + ", isp=" + isp
                + ", org=" + org + ", ass=" + ass + ", active=" + active
                + ", googleUrl=" + googleUrl + ", query=" + query + ", pageType="
                + pageType + "]";
    }

}
