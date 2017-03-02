package com.lee.demo.springmvc.common.dao.domain;

/**
 * 用户开通的应用DO
 *
 * Created by hzlifan on 2017/2/10.
 */
public class ApplicationDO {

    private Long uid;

    private String type;

    public ApplicationDO() {
    }

    public ApplicationDO(Long uid, String type) {
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
