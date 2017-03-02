package com.lee.demo.springmvc.common.dao.impl;

import com.lee.demo.springmvc.common.dao.ApplicationDAO;
import com.lee.demo.springmvc.common.dao.BaseDAO;
import com.lee.demo.springmvc.common.dao.domain.ApplicationDO;
import com.lee.demo.springmvc.common.model.ApplicationInfo;
import com.lee.demo.springmvc.utils.BeanUtil;
import org.springframework.stereotype.Repository;

/**
 * Created by hzlifan on 2017/2/10.
 */
@Repository
public class ApplicationDAOImpl extends BaseDAO<ApplicationDO> implements ApplicationDAO {

    private static final String NAMESPACE = "com.lee.demo.springmvc.common.dao.domain.ApplicationDO";

    @Override
    public void insertRecord(ApplicationInfo applicationInfo) {
        executeInsert(NAMESPACE + ".insertRecord",
            BeanUtil.copyProperties(new ApplicationDO(), applicationInfo));
    }

}
