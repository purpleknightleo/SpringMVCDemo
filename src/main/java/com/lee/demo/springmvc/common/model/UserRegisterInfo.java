package com.lee.demo.springmvc.common.model;

/**
 * 上层传入的用户注册信息
 *
 * Created by hzlifan on 2017/2/10.
 */
public class UserRegisterInfo {

    private Long uid;

    private String name;

    private String password;

    private String applicationType;

    public UserRegisterInfo() {
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

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

}
