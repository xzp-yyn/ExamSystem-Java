package com.xzp.other.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 我数据
 *
 * @author 薛展鹏
 * @Description:
 * @date 2023/03/29
 */
@Component
public class MyData {

    public static String address;
    public static String port;
    public static String context;
    public static String resourcePath;

    @Value("${xzp.address}")
    public void setAddress(String address) {
        MyData.address = address;
    }

    @Value("${server.port}")
    public void setPort(String port) {
        MyData.port = port;
    }

    @Value("${server.servlet.context-path}")
    public void setContext(String context) {
        MyData.context = context;
    }

    @Value("${xzp.resource-path}")
    public void setResourcePath(String resourcePath) {
        MyData.resourcePath = resourcePath;
    }
}
