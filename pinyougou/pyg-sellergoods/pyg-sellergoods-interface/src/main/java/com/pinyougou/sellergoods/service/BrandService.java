package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import com.pinyougou.service.BaseService;
import com.pinyougou.vo.PageResult;

import java.util.List;

public interface BrandService extends BaseService<TbBrand> {
    /**
     * 查询所有品牌信息
     * @return
     */
    List<TbBrand> queryAll();

    /**
     * 测试分页助手和通用mapper
     * @param page
     * @param rows
     * @return
     */
    List<TbBrand> testPage(Integer page, Integer rows);

    PageResult search(Integer page, Integer rows, TbBrand brand);
}
