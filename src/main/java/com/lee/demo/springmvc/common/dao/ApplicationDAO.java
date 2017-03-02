package com.lee.demo.springmvc.common.dao;

import com.lee.demo.springmvc.common.model.ApplicationInfo;

/**
 * 用户应用DAO接口
 *
 * Created by hzlifan on 2017/2/10.
 */
public interface ApplicationDAO {

    /**
     * 插入记录
     *
     * @param applicationInfo
     */
    public void insertRecord(ApplicationInfo applicationInfo);

}
