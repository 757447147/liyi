package com.pinyougou.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.sellergoods.service.TypeTemplateService;
import com.pinyougou.vo.PageResult;
import com.pinyougou.vo.ResultInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("typeTemplate")
public class TypeTemplateController {

    @Reference
    private TypeTemplateService typeTemplateService;

    /**
     * 查询所有模板列表
     * @return
     */
    @GetMapping("findAll")
    public List<TbTypeTemplate> findAll(){
        return typeTemplateService.findAll();
    }

    /**
     * 分页条件查询模块列表
     * @param page
     * @param rows
     * @param tbTypeTemplate
     * @return
     */
    @PostMapping("search")
    public PageResult search(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "rows",defaultValue = "10") Integer rows,
                             @RequestBody TbTypeTemplate tbTypeTemplate){
       return typeTemplateService.search(page,rows,tbTypeTemplate);
    }

    /**
     * 批量删除模板
     * @param ids
     * @return
     */
    @GetMapping("delete")
    public ResultInfo delete(Long[] ids){
        try {
            typeTemplateService.deleteByIds(ids);
            return ResultInfo.ok("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultInfo.fail("删除失败");
    }

    /**
     * 根据id查询模板信息，并返回给前端显示
     * @param id
     * @return
     */
    @GetMapping("findOne")
    public TbTypeTemplate findOne(Long id){
        return typeTemplateService.findOne(id);
    }

    /**
     * 更新模板信息
     * @param tbTypeTemplate
     * @return
     */
    @PostMapping("update")
    public ResultInfo update(@RequestBody TbTypeTemplate tbTypeTemplate){
        try {
            typeTemplateService.update(tbTypeTemplate);
            return ResultInfo.ok("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultInfo.fail("修改失败");
    }
    @PostMapping("add")
    public ResultInfo add(@RequestBody TbTypeTemplate tbTypeTemplate){
        try {
            typeTemplateService.add(tbTypeTemplate);
            return ResultInfo.ok("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultInfo.fail("添加失败");
    }
}
