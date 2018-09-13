package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.service.BaseService;
import com.pinyougou.vo.PageResult;

import java.util.List;
import java.util.Map;

public interface TypeTemplateService extends BaseService<TbTypeTemplate> {
    /**
     * 查询所有模板列表
     * @return
     */
    List<TbTypeTemplate> findAll();

    /**
     * 条件分页查询模板列表
     * @param page
     * @param rows
     * @param tbTypeTemplate
     * @return
     */
    PageResult search(Integer page, Integer rows, TbTypeTemplate tbTypeTemplate);

}
