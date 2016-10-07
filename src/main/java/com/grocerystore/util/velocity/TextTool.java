package com.grocerystore.util.velocity;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.abdera.i18n.text.Normalizer;
import org.apache.abdera.i18n.text.Sanitizer;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextTool {

    protected static final Logger logger = LoggerFactory.getLogger(TextTool.class);

    public static final String SANITIZE_TITLE_PATTERN = "[^A-Za-z0-9\\\\-]+";
    public static final int TITLE_MAX_LENGTH = 125;

    public static Properties propertiesLoad(String fileName, Class<? extends Object> clas) {
        Properties properties = null;
        try {
            properties = new Properties();
            properties.load(new FileInputStream(fileName));
        } catch (Exception e) {
            try {
                properties = new Properties();
                ClassLoader classLoader = clas.getClassLoader();
                properties.load(classLoader.getResourceAsStream(fileName));
            } catch (IOException e1) {
            }
        }
        return properties;
    }

    public static String normalizeTitle(String title) {
        if (StringUtils.isEmpty(title)) return null;

        String title_out = stripHTML(title, "");
        if (!StringUtils.isEmpty(title_out))
            title_out = StringUtils.strip(title_out);
        title_out = StringUtils.abbreviate(title_out, TITLE_MAX_LENGTH);
        title_out = title_out.replaceAll("[\n\r]", "");

        return title_out.replaceAll("\"", "'");
    }

    public static String sanitizeTitle(String title) {
        if (StringUtils.isEmpty(title)) return null;

        String title_out = stripHTML(title, "");
        if (!StringUtils.isEmpty(title_out))
            title_out = StringUtils.strip(title_out);
        title_out = StringUtils.abbreviate(title_out, TITLE_MAX_LENGTH);

        return Sanitizer.sanitize(title_out, "_", true, Normalizer.Form.D, SANITIZE_TITLE_PATTERN);
    }

    public static String sanitizeLastPathUrl(String title, Long id, Long subId) {
        return sanitizeLastPathUrl(title, id.toString(), subId.toString());
    }

    public static String sanitizeLastPathUrl(String title, Long id) {
        return sanitizeLastPathUrl(title, id.toString());
    }

    public static String sanitizeLastPathUrl(String title, String id) {
        return sanitizeLastPathUrl(title, id, null);
    }

    public static String sanitizeLastPathUrl(String title, String id, String subId) {
        String titleSanitized = sanitizeTitle(title);
        String idSanitized = getLastPartId(id);
        String subIdSanitized = getLastPartId(subId);
        String sanitezedUrl = titleSanitized;
        if( idSanitized != null ) sanitezedUrl +=  "-" + idSanitized;
        if( subIdSanitized != null ) sanitezedUrl +=  "-" + subIdSanitized;
        return sanitezedUrl;
    }

    public static String sanatizeId(String id){
        logger.debug("TextTool sanatizeId String " + id);
        return getLastPartId(id);
    }

    private static String getLastPartId(String id){
        String idSanitized = null;
        logger.debug("TextTool getLastPartId " + id);
        if ( !StringUtils.isEmpty(id) && id.indexOf(":") > 0 )
            idSanitized = id.substring(id.lastIndexOf(":") + 1);
        else if( !StringUtils.isEmpty(id) )
            idSanitized = id;
        logger.debug("TextTool getLastPartId idSanitized " + idSanitized);
        return idSanitized;
    }

    public static String stripHTML(String text, String replace) {
        String stripped = text;
        if (text != null) stripped = text.replaceAll("\\<.*?>", replace);
        return stripped;
    }

    public static String abbreviate(String text, Integer lenght){
        if( !StringUtils.isEmpty(text) && text.length() > lenght ){
            String abbText = StringUtils.stripStart(text, null);
            abbText = StringUtils.abbreviate(abbText, lenght);
            return abbText;
        }
        return text;
    }
    
    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static String capitalize(String s) {
        return StringUtils.capitalize(StringUtils.lowerCase(s));
    }

    public static String capitalize(String s, boolean forPhrase) {
        return StringUtils.capitalize(StringUtils.lowerCase(s));
    }

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static Date uniqueDate(Date timestamp) {
        int seconds =  new Random().nextInt(60);
        return new Date(timestamp.getTime() + seconds * 1000);
    }
    
    public static String categoryCleaner(List<String> categoriesToClean,String dirty) {
        String category = "";
        if(null != categoriesToClean && 0 < categoriesToClean.size()) {
            category = StringUtils.remove(categoriesToClean.get(0), dirty);
        }
        return category;
    }
    
    public static String urlMaker(String section, String contentType, String normalizedTitle, String title, String id) {
        String url = "";
        String delimiter = "/";
        if (!StringUtils.isEmpty(section)) {
            url += section + delimiter;
        }
        url += contentType + delimiter;
        if (!StringUtils.isEmpty(normalizedTitle)) url += normalizedTitle + ".html";
        if (!StringUtils.isEmpty(title)) url += sanitizeLastPathUrl(title, id) + ".html";
        return url;
    }
    
    public static String getBrandUrlFromName(String brandName) {
        String brandUrl = "";
        if (null != brandName && !"".equals(brandName)) {
            brandUrl = brandName.toLowerCase().replace(" ", "");
        }
        return brandUrl;
    }
    
    public static String capitalizeString(String inputToCapitalize) {
        String output = "";
        if (!StringUtils.isEmpty(inputToCapitalize)) {
            output = inputToCapitalize.toUpperCase();
        }
        return output;
    }
    
    public static String getCategory(List<String> categories, Integer level) {
        String result = "";
        Integer group = 1;
        if (null != level) group = level;
        // Regex that matches all string group between 
        // literal '\' and '\' or end line
        Pattern pattern = Pattern.compile("([^/]+)");   
        if (null != categories && 0<categories.size()) {
            Matcher matcher = pattern.matcher(categories.get(0));
            int i=0;
            while (matcher.find()){
                if (group==i) result = matcher.group(group);
                i++;
            }  
        } return result;
    }
    
    public static String getTitleEscaped(String title) {
        return title.replaceAll("\"", "\\\"");
    }
    
    
}
