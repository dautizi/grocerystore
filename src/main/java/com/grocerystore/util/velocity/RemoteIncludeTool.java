package com.grocerystore.util.velocity;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RemoteInclude Tool
 */
public class RemoteIncludeTool {

    protected static final Logger logger = LoggerFactory.getLogger(RemoteIncludeTool.class);

    public String get(String url) {
        String content =  null;

        byte[] resource = null;
        try {
            resource = getHTML(url);
        } catch (Exception e) {
            logger.warn("Remote include external request to: " + url + " failed or timed out. Will return a null resource. " + e);
        }

        if (resource != null && resource.length > 0) {
            try {
                content = new String(resource, "UTF-8");
            } catch (Exception e) {
                logger.warn("Failed to encode " + resource);
            }
        }

        if (content == null) content = StringUtils.EMPTY;
        return content;
    }

    public String get(String content, String search, String replace) {
        return content.replaceAll(search, replace);
    }

    public String get(String urlResource, String defaultUrlResource) {
        String content = this.get(urlResource);
        if (content == null) content = this.get(defaultUrlResource);
        if (content == null) content = StringUtils.EMPTY;
        return content;
    }

    public static byte[] getHTML(String urlToRead) throws Exception {
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        // conn.setDoOutput(true);
        InputStream is = conn.getInputStream();
        byte[] bytes = IOUtils.toByteArray(is);
        return bytes;
    }

}
