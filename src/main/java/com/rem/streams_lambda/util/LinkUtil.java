package com.rem.streams_lambda.util;

import java.net.HttpURLConnection;
import java.net.URL;

public class LinkUtil {

    public static int getResponseCode(String link) {
        URL url;
        HttpURLConnection conn = null;
        int responseCode = -1;
        try {
            url = new URL(link);
            conn = (HttpURLConnection) url.openConnection();
            responseCode = conn.getResponseCode();

        } catch (Exception e) {

        } finally {
            if (null != conn) {
                conn.disconnect();
            }
        }
        return responseCode;
    }
}
