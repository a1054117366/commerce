package com.qingcheng.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qingcheng.dao.BrandMapper;
import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.goods.Brand;
import com.qingcheng.service.goods.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * @author wxy
 * @date 2019/9/2
 * @time 17:03
 */
@Service
public class BrandServiceImpl implements BrandService {

    public BrandServiceImpl(){

    }

    @Autowired
    private BrandMapper brandMapper;

    /**
     * 查询所有Brand内容
     * @return
     */
    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 当前页
     * @param size 每页显示条数
     * @return
     */
    @Override
    public PageResult<Brand> findPage(int page, int size) {
        //通过分页插件查询总条数，及每页显示的内容
        PageHelper.startPage(page, size);
        Page<Brand> brands = (Page<Brand>) brandMapper.selectAll();
        return new PageResult<Brand>(brands.getTotal(),brands.getResult());
    }

    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    @Override
    public List<Brand> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return brandMapper.selectByExample(example);
    }

    @Override
    public PageResult<Brand> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Brand> brands = (Page<Brand>)brandMapper.selectByExample(example);
        return new PageResult<>(brands.getTotal(),brands.getResult() );
    }

    /**
     * 构建条件查询
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (searchMap!=null){
            //名称条件
            if (searchMap.get("name")!=null&&!"".equals(searchMap.get("name"))){
                criteria.andLike("name", "%"+searchMap.get("name")+"%");
            }
            //首字母
            if (searchMap.get("letter")!=null&&"".equals(searchMap.get("letter"))){
                criteria.andEqualTo("letter", searchMap.get("letter"));
            }
        }
        return example;
    }

}
