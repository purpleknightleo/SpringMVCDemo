package com.lee.demo.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import com.lee.demo.springmvc.common.model.UserRegisterInfo;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lee.demo.springmvc.common.model.UserDTO;
import com.lee.demo.springmvc.service.UserService;
import com.lee.demo.springmvc.utils.PackUtil;

/**
 * 用户相关控制类
 *
 * Created by hzlifan on 2017/2/7.
 */
@Controller
@RequestMapping(value = "/usr")
public class UserInfoController {

    private static final Logger logger = Logger.getLogger(UserInfoController.class);

    @Autowired
    private UserService         userService;

    /**
     * 用户注册，并开通指定应用
     *
     * @param userRegisterInfo
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody Map<String, Object> register(@RequestBody UserRegisterInfo userRegisterInfo) {
        Long uid = userRegisterInfo.getUid();
        logger.info("register user, uid = " + uid);
        try {
            if (uid == null || StringUtils.isBlank(userRegisterInfo.getName())
                || StringUtils.isBlank(userRegisterInfo.getPassword())
                || StringUtils.isBlank(userRegisterInfo.getApplicationType())) {
                PackUtil.genErrorResponse(310, "param error");
            }
            userService.addUser(userRegisterInfo);
            return PackUtil.genSuccessResponse();
        } catch (Exception e) {
            logger.error("fail to register user, uid = " + uid, e);
        }
        return PackUtil.genErrorResponse(300, "register error");
    }

    /**
     * 根据uid获取用户信息
     *
     * @param uid
     * @return
     */
    @RequestMapping(value = "/getinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody Map<String, Object> getUserInfo(@RequestBody Long uid) {
        logger.info("get user info, uid = " + uid);
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            if (uid == null) {
                PackUtil.genErrorResponse(310, "param error");
            }
            UserDTO userDTO = userService.getUserInfo(uid);
            if (userDTO != null) {
                map.put("name", userDTO.getName());
            } else {
                return PackUtil.genErrorResponse(400, "user not exist");
            }
            return PackUtil.genSuccessResponse(map);
        } catch (Exception e) {
            logger.error("fail to get user info, uid = " + uid, e);
        }
        return PackUtil.genErrorResponse(300, "query error");
    }

}
