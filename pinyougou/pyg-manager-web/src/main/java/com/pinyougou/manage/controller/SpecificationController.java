package com.pinyougou.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.sellergoods.service.SpecificationService;
import com.pinyougou.vo.PageResult;
import com.pinyougou.vo.ResultInfo;
import com.pinyougou.vo.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("specification")
public class SpecificationController {
    @Reference
    private SpecificationService specificationService;

    /**
     * 分页条件查询
     * @param page
     * @param rows
     * @param tbSpecification
     * @return
     */
    @PostMapping("search")
    public PageResult search(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "rows",defaultValue = "10") Integer rows,
                             @RequestBody TbSpecification tbSpecification){
        return specificationService.search(page,rows,tbSpecification);
    }

    /**
     * 新增规格
     * @param specification
     * @return
     */
    @PostMapping("add")
    public ResultInfo add(@RequestBody Specification specification){
        try {
            specificationService.add(specification);
            return ResultInfo.ok("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultInfo.fail("添加失败");
    }

    /**
     * 根据id查询规格信息，并回显
     * @param id
     * @return
     */
    @GetMapping("findOne")
    public Specification findOne(Long id){
        return specificationService.findOne(id);
    }

    /**
     * 保存修改后的规格信息
     * @param specification
     * @return
     */
    @PostMapping("update")
    public ResultInfo update(@RequestBody Specification specification){
        try {
            specificationService.update(specification);
            return ResultInfo.ok("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultInfo.fail("修改失败");
    }

    /**
     * 删除所选择的规格
     * @param ids
     * @return
     */
    @GetMapping("delete")
    public ResultInfo delete(Long[] ids){
        try {
            specificationService.delete(ids);
            return ResultInfo.ok("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultInfo.fail("删除失败");
    }

    /**
     * 查询规格列表
     * @return
     */
    @GetMapping("selectOptionList")
    public List<Map<String,String>> selectOptionList(){
        return specificationService.selectOptionList();
    }
}
