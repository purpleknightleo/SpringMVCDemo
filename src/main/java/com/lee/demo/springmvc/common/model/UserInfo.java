package com.lee.demo.springmvc.common.model;

/**
 * 上层传入的用户信息
 *
 * Created by hzlifan on 2017/2/10.
 */
public class UserInfo {

    private Long uid;

    private String name;

    private String password;


    public UserInfo() {
    }

    public UserInfo(Long uid, String name, String password) {
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
