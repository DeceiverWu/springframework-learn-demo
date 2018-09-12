package com.deceiver.io;

import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Deceiver
 * Date: 2018-09-09
 * Time: 16:56
 */
public interface Resource {

    InputStream getInputstream() throws Exception;
}
