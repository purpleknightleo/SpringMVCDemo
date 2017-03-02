package com.lee.demo.springmvc.service.impl;

import com.lee.demo.springmvc.common.dao.ApplicationDAO;
import com.lee.demo.springmvc.common.dao.UserDAO;
import com.lee.demo.springmvc.common.dao.domain.UserDO;
import com.lee.demo.springmvc.common.model.ApplicationInfo;
import com.lee.demo.springmvc.common.model.UserDTO;
import com.lee.demo.springmvc.common.model.UserInfo;
import com.lee.demo.springmvc.common.model.UserRegisterInfo;
import com.lee.demo.springmvc.utils.BeanUtil;
import com.lee.demo.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

/**
 * 用户服务实现类
 *
 * Created by hzlifan on 2017/2/7.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO        userDAO;

    @Autowired
    private ApplicationDAO applicationDAO;

    @Override
    public UserDTO getUserInfo(Long uid) {
        UserDO userDO = userDAO.getUserByUid(uid);
        return (UserDTO) BeanUtil
            .copyProperties(new UserDTO(), userDO, new String[] { "password" });
    }

    @Transactional( isolation= Isolation.REPEATABLE_READ,
            propagation= REQUIRED )
    @Override
    public void addUser(UserRegisterInfo userRegisterInfo) {
        Long uid = userRegisterInfo.getUid();
        /** 下面两步是一个事务 */
        userDAO.addUser(new UserInfo(userRegisterInfo.getUid(), userRegisterInfo.getName(),
            userRegisterInfo.getPassword()));  // 添加用户
        applicationDAO
            .insertRecord(new ApplicationInfo(uid, userRegisterInfo.getApplicationType()));  // 开通指定应用
    }

}
