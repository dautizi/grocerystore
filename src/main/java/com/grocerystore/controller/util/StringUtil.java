package com.grocerystore.controller.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grocerystore.model.configuration.Log;

public class StringUtil {

    protected static final Logger logger = LoggerFactory.getLogger(StringUtil.class);

    public static Log enrichmentByInfo(Log log) {
        if ((log != null) && (!(StringUtils.isEmpty(log.getIpInfo())))) {
            String info = log.getIpInfo();
            logger.debug("#enrichmentByInfo info value: " + info);
            String[] tokens = info.split(",");
            logger.debug("no. tokens:" + tokens.length);

            log.setAbbrCountry(tokens[1].replace("\"", ""));
            logger.debug("AbbrCountry= " + tokens[1]);
            log.setCountry(tokens[2].replace("\"", ""));
            logger.debug("Country= " + tokens[2]);
            
            log.setAbbrRegion(tokens[3].replace("\"", ""));
            logger.debug("AbbrRegion= " + tokens[3]);
            
            log.setRegion(tokens[4].replace("\"", ""));
            logger.debug("Region= " + tokens[4]);
            
            log.setCity(tokens[5].replace("\"", ""));
            logger.debug("City= " + tokens[5]);
                
            log.setZipCode(tokens[6].replace("\"", ""));
            logger.debug("ZipCode= " + tokens[6]);
                
            log.setLatitude(tokens[7].replace("\"", ""));
            logger.debug("Latitude= " + tokens[7]);
                
            log.setLongitude(tokens[8].replace("\"", ""));
            logger.debug("Longitude= " + tokens[8]);
                
            log.setArea(tokens[9].replace("\"", ""));
            logger.debug("Area= " + tokens[9]);
                
            log.setMetro(tokens[10].replace("\"", ""));
            logger.debug("Metro= " + tokens[10]);
        } else {
            log.setAbbrCountry("");
            log.setCountry("");
            log.setAbbrRegion("");
            log.setRegion("");
            log.setCity("");
            log.setZipCode("");
            log.setLatitude("");
            log.setLatitude("");
            log.setArea("");
            log.setMetro("");
        }
        return log;
    }

    public static List<String> stringSplitter(String toSplit) {
        List<String> list = null;
        if ( !StringUtils.isEmpty(toSplit) ) {
            String[] tokens = toSplit.split(",");
            if ( tokens != null && tokens.length > 0 ) {
                list = new ArrayList<String>();
                for (String token : tokens) {
                    list.add(token);
                }
            }
        }
        return list;
    }

    public static int fromStringToInt(String intValueInString) {
        int result = 0;
        if (!StringUtils.isEmpty(intValueInString)) {
            try {
                result = Integer.parseInt(intValueInString);
            } catch (Exception ex) {
                logger.error("Error in parsing String to get an int value: " + intValueInString);
            }
        }
        return result;
    }

}
