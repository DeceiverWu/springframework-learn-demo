package com.deceiver.io;

import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Deceiver
 * Date: 2018-09-09
 * Time: 16:57
 */
public class ResourceLoader {

    /**
     * 给定一个位置， 使用累加器的资源加载URL，并创建一个“资源URL”对象，便于获取输入流
     */
    public ResourceUrl getResource(String location) {
        URL url = this.getClass().getClassLoader().getResource(location);
        return new ResourceUrl(url);
    }
}
