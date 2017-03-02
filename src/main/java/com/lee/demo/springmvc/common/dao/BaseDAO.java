package com.lee.demo.springmvc.common.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * 基础DAO抽象类
 *
 * Created by hzlifan on 2017/2/7.
 */
public abstract class BaseDAO<T> {

    @Autowired
    private SqlSessionTemplate sessionTemplate;

    public BaseDAO() {
    }

    /**
     * 批量查询
     *
     * @param sql             sql
     * @param parameterObject 参数对象
     * @return 查询结果列表
     */
    protected List<T> queryForList(String sql, Object parameterObject) {
        return sessionTemplate.selectList(sql, parameterObject);
    }

    /**
     * 单条数据查询
     *
     * @param sql             sql
     * @param parameterObject 参数
     * @return 返回结果
     */
    protected T queryForObject(String sql, Object parameterObject) {
        return sessionTemplate.selectOne(sql, parameterObject);
    }

    /**
     * 修改语句
     *
     * @param sql             sql
     * @param parameterObject 参数
     * @return 影响行数
     * @throws DataAccessException 异常
     */
    protected int executeUpdate(String sql,
                                Object parameterObject) throws DataAccessException {
        return sessionTemplate.update(sql, parameterObject);
    }

    /**
     * 统计
     *
     * @param sql             sql
     * @param parameterObject 参数
     * @return 统计结果
     */
    protected int queryCount(String sql, Object parameterObject) {
        Object obj = (Object) sessionTemplate.selectOne(sql, parameterObject);
        return (obj != null) ? Integer.valueOf(obj.toString()) : 0;
    }

    /**
     * 插入语句
     *
     * @param sql             sql
     * @param parameterObject 参数
     * @return
     */
    protected Object executeInsert(String sql, Object parameterObject) {
        return sessionTemplate.insert(sql, parameterObject);
    }

    /**
     * 物理删除
     *
     * @param sql   sql
     * @param parameterObject 参数
     * @return 删除条数
     * @throws DataAccessException 异常
     */
    protected int executeDelete(String sql,
                                Object parameterObject) throws DataAccessException {
        return sessionTemplate.delete(sql, parameterObject);
    }

    /**
     * Getter method for property <tt>sessionTemplate</tt>.
     *
     * @return property value of sessionTemplate
     */
    public SqlSessionTemplate getSessionTemplate() {
        return sessionTemplate;
    }

    /**
     * Setter method for property <tt>sessionTemplate</tt>.
     *
     * @param sessionTemplate value to be assigned to property sessionTemplate
     */
    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }

}
