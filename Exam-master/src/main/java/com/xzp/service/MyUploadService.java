package com.xzp.service;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.Map;

/**
 * 我上传服务
 *
 * @author 薛展鹏
 * @Description:
 * @date 2023/03/29
 */
public interface MyUploadService {

    /**
     * 阿里云上传
     * @param inputStream
     * @param dirName
     * @param fileName
     * @return
     */
    String aliyunUpdate(InputStream inputStream, String dirName, String fileName);

    /**
     * 上传OSS
     * @param req
     * @param dirName
     * @return
     */
    Map<String,String> uploadOSS(HttpServletRequest req, String dirName);

    /**
     * 上传本地
     * @param req
     * @param dirName
     * @return
     */
    Map<String, String> uploadLocal(HttpServletRequest req, String dirName);

}
