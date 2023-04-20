package com.xzp.other.utils;
/**
 * 生成Token的工具类：  
 */

import cn.hutool.core.codec.Base62;

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
        return Base62.encode(token);
    }
}
