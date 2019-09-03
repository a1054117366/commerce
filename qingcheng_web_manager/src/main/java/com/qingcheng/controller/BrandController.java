package com.qingcheng.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.goods.Brand;
import com.qingcheng.entity.Result;
import com.qingcheng.service.goods.BrandService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author wxy
 * @date 2019/9/2
 * @time 18:16
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    @GetMapping("/findAll")//get请求
    public List<Brand> findAll() {
        return brandService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Brand> findPage(int page, int size) {
        return brandService.findPage(page, size);
    }

    @PostMapping("/findList")//post请求
    public List<Brand> findList(@RequestBody Map<String, Object> searchMap) {//@RequestBody将前端传输过来的json串解析成Map数据
        return brandService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Brand> findPage(@RequestBody Map<String, Object> searchMap, int page, int size) {
        return brandService.findPage(searchMap, page, size);
    }

    @GetMapping("/findById")
    public Brand findById(Integer id) {
        return brandService.findById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Brand brand) {//@RequestBody将前端传输过来的json串解析成pojo
        Integer code = brandService.add(brand);
        return code < 1 ? new Result(1, "商品新增失败") : new Result(0, "商品新增成功");
    }

    @PostMapping("/update")
    public Result update(@RequestBody Brand brand){
        Integer code = brandService.update(brand);
        return code < 1 ? new Result(1, "商品修改失败") : new Result(0, "商品修改成功");
    }
    
    @GetMapping("/delete")
    public Result delete(Integer id){
        Integer code = brandService.delete(id);
        return code < 1 ? new Result(1, "商品删除失败") : new Result(0, "商品删除成功");
    }
}
