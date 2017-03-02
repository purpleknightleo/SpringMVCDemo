package com.lee.demo.springmvc.common.dao;

import com.lee.demo.springmvc.common.dao.domain.UserDO;
import com.lee.demo.springmvc.common.model.UserInfo;

/**
 * 用户DAO接口
 *
 * Created by hzlifan on 2017/2/7.
 */
public interface UserDAO {

    public UserDO getUserByUid(Long uid);

    public void addUser(UserInfo userInfo);

}
