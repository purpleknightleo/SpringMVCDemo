package com.lee.demo.springmvc.common.model;

/**
 * 用户DTO
 *
 * Created by hzlifan on 2017/2/5.
 */
public class UserDTO {

    private Long uid;

    private String name;

    public UserDTO() {
    }

    public UserDTO(Long uid, String name) {
        this.uid = uid;
        this.name = name;
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

}
