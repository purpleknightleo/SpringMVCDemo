package com.lee.demo.springmvc.service;

import com.lee.demo.springmvc.common.model.UserDTO;
import com.lee.demo.springmvc.common.model.UserRegisterInfo;

/**
 * 用户服务接口
 *
 * Created by hzlifan on 2017/2/7.
 */
public interface UserService {

    public UserDTO getUserInfo(Long uid);

    public void addUser(UserRegisterInfo userRegisterInfo);

}
