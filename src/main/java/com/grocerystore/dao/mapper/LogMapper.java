package com.grocerystore.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.grocerystore.model.configuration.Log;

public class LogMapper implements RowMapper {

    private static Logger logger = Logger.getLogger(LogMapper.class);

    public Object mapRow(ResultSet rs, int arg1) throws SQLException {

        Log log = new Log();
        log.setId(rs.getInt("id"));
        log.setIpAddress(rs.getString("ip_address"));
        log.setProxyAddress(rs.getInt("proxy_address"));
        log.setVisitDate(rs.getString("visit_date"));
        log.setAbbrCountry(rs.getString("abbr_country"));
        log.setCountry(rs.getString("country"));
        log.setAbbrRegion(rs.getString("abbr_region"));
        log.setRegion(rs.getString("region"));
        log.setCity(rs.getString("city"));
        log.setZipCode(rs.getString("zipcode"));
        log.setLatitude(rs.getString("latitude"));
        log.setLongitude(rs.getString("longitude"));
        log.setArea(rs.getString("area"));
        log.setMetro(rs.getString("metro"));
        log.setTimezone(rs.getString("timezone"));
        log.setIsp(rs.getString("isp"));
        log.setOrg(rs.getString("org"));
        log.setAss(rs.getString("ass"));
        log.setActive(rs.getInt("active"));
        log.setQuery(rs.getString("query"));
        log.setPageType(rs.getString("page_type"));

        return log;
    }

}