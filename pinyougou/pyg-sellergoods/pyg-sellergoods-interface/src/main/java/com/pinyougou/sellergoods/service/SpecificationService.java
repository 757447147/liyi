package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.service.BaseService;
import com.pinyougou.vo.PageResult;
import com.pinyougou.vo.Specification;

import java.util.List;
import java.util.Map;

public interface SpecificationService extends BaseService<TbSpecification> {
    /**
     * 分页条件查询
     * @param page
     * @param rows
     * @param tbSpecification
     * @return
     */
    PageResult search(Integer page, Integer rows, TbSpecification tbSpecification);

    /**
     * 新增规格
     * @param specification
     */
    void add(Specification specification);

    /**
     * 根据id查询规格信息
     * @param id
     * @return
     */
    Specification findOne(Long id);

    /**
     * 保存修改规格信息
     * @param specification
     */
    void update(Specification specification);

    void delete(Long[] ids);

    List<Map<String,String>> selectOptionList();
}
