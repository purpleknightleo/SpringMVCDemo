package com.lee.demo.springmvc.common.model;

/**
 * 上层传入的应用信息
 *
 * Created by hzlifan on 2017/2/10.
 */
public class ApplicationInfo {

    private Long uid;

    private String type;

    public ApplicationInfo() {
    }

    public ApplicationInfo(Long uid, String type) {
        this.uid = uid;
        this.type = type;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
