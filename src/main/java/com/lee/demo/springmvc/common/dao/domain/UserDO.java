package com.lee.demo.springmvc.common.dao.domain;

/**
 * 用户DO
 *
 * Created by hzlifan on 2017/2/7.
 */
public class UserDO {

    private Long uid;

    private String name;

    private String password;

    public UserDO() {

    }

    public UserDO(Long uid, String name, String password) {
        this.uid = uid;
        this.name = name;
        this.password = password;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
