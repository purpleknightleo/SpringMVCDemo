package com.lee.demo.springmvc.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 响应包工具类
 *
 * Created by hzlifan on 2017/2/7.
 */
public class PackUtil {

    /**
     * 生成正确结果
     *
     * @return
     */
    public static Map<String, Object> genSuccessResponse() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 200);
        return map;
    }

    /**
     * 生成正确结果
     *
     * @param mapRet
     * @return
     */
    public static Map<String, Object> genSuccessResponse(Map<String, Object> mapRet) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 200);
        map.put("ret", mapRet);
        return map;
    }

    /**
     * 生成正确结果
     *
     * @param mapRet
     * @param code
     * @return
     */
    public static Map<String, Object> genSuccessResponse(Map<String, Object> mapRet, int code) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
        map.put("ret", mapRet);
        return map;
    }

    /**
     * 生成错误结果
     *
     * @param code
     * @param msg
     * @return
     */
    public static Map<String, Object> genErrorResponse(int code, String msg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
        map.put("msg", msg);
        return map;
    }

}
