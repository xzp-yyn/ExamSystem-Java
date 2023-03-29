package com.xzp.other.utils;
/**
 * 生成Token的工具类：  
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Random;

/**
 * 令牌处理器
 * 生成Token的工具类
 *
 * @author 薛展鹏
 * @date 2023/03/29
 */
public class TokenProcessor {

    private TokenProcessor(){};
    private static final TokenProcessor instance = new TokenProcessor();

    public static TokenProcessor getInstance() {
        return instance;
    }

    /**
     * 生成Token  
     * @return
     */
    public String makeToken() {
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] md5 =  md.digest(token.getBytes());
            Encoder encoder = Base64.getEncoder();
            return new String(encoder.encode(md5));
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block  
            e.printStackTrace();
        }
        return null;
    }
}
