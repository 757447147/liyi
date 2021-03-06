package com.pinyougou.service;

import com.pinyougou.vo.PageResult;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {
    /**
     * 根据主键id查询
     * @param id
     * @return 实体类对象
     */
    public T findOne(Serializable id);

    /**
     * 查询所有
     * @param
     * @return 实体类对象集合
     */
    public List<T> findAll();

    /**
     * 根据条件查询，对象的属性不为null，则当做查询条件
     * @param t
     * @return 实体类对象集合
     */
    public List<T> findByWhere(T t);

    /**
     * 分页查询
     * @param page
     * @param rows
     * @return 分页实体类对象
     */
    public PageResult findPage(Integer page,Integer rows);

    /**
     * 根据条件分页查询
     * @param page
     * @param rows
     * @param t
     * @return
     */
    public PageResult findPage(Integer page,Integer rows,T t);

    /**
     * 新增
     * @param t
     */
    public void add(T t);

    /**
     * 根据主键id批量删除
     * @param ids
     */
    public void deleteByIds(Serializable[] ids);

    /**
     * 根据主键修改对象
     * @param t
     */
    public void update(T t);
}
