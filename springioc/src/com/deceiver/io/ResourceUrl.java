package com.deceiver.io;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Deceiver
 * Date: 2018-09-09
 * Time: 16:58
 */
public class ResourceUrl implements Resource {

    private final URL url;

    public ResourceUrl(URL url) {
        this.url = url;
    }


    @Override
    public InputStream getInputstream() throws Exception {
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        return urlConnection.getInputStream();
    }
}
