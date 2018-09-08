package com.pinyougou.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import com.pinyougou.vo.PageResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("brand")
public class BrandController {

    @Reference
    private BrandService brandService;
    /**
     * 测试mybatis的分页助手pagehelper和通用mapper
     */
    @GetMapping("testPage")
    public List<TbBrand> testPage(Integer page,Integer rows){
        return brandService.testPage(page,rows);
    }

    /**
     * 查询所有品牌信息
     * @return
     */
    @GetMapping("findAll")
    public List<TbBrand> quertAll(){

        /*return brandService.queryAll();*/
        return brandService.findAll();
    }

    @GetMapping("findPage")
    public PageResult findPage(@RequestParam(value = "page",defaultValue = "1") Integer page,
                               @RequestParam(value = "rows",defaultValue = "5") Integer rows){

        return brandService.findPage(page,rows);
    }
}
