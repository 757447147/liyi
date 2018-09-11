package com.pinyougou.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import com.pinyougou.vo.PageResult;
import com.pinyougou.vo.ResultInfo;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
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

    /**
     * 分页查询
     * @param page
     * @param rows
     * @return
     */
    @GetMapping("findPage")
    public PageResult findPage(@RequestParam(value = "page",defaultValue = "1") Integer page,
                               @RequestParam(value = "rows",defaultValue = "5") Integer rows){

        return brandService.findPage(page,rows);
    }

    /**
     * 新增品牌
     * @param brand
     * @return
     */
    @PostMapping("add")
    public ResultInfo add(@RequestBody TbBrand brand){
        try {
            brandService.add(brand);
            return ResultInfo.ok("新增成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultInfo.fail("新增失败");
    }

    /**
     * 根据id查询品牌
     * @param id
     * @return
     */
    @GetMapping("findOne")
    public TbBrand findOne(Long id){
        return brandService.findOne(id);
    }

    /**
     * 更新品牌
     * @param brand
     * @return
     */
    @PostMapping("update")
    public ResultInfo update(@RequestBody TbBrand brand){
        try {
            brandService.update(brand);
            return ResultInfo.ok("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultInfo.fail("修改失败");
    }

    /**
     *分页条件模糊查询
     * @param ids
     * @return
     */
    @GetMapping("delete")
    public ResultInfo delete(Long[] ids){
        try {
            brandService.deleteByIds(ids);
            return ResultInfo.ok("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultInfo.fail("删除失败");
    }

    @PostMapping("search")
    public PageResult search(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "rows",defaultValue = "10") Integer rows,
                             @RequestBody TbBrand brand){
        return brandService.search(page, rows, brand);
    }
}
