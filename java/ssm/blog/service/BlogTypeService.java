package ssm.blog.service;

import ssm.blog.entity.BlogType;
import ssm.blog.entity.PageBean;

import java.awt.*;
import java.awt.print.PageFormat;
import java.util.List;

/**
 * Created by ghang on 2018/2/14
 * @author 高行行
 * @Description 博客类别service接口
 */
public interface BlogTypeService {

    // 分页查询
    PageBean<BlogType> listByPage(PageBean<BlogType> pageBean);

    // 添加博客类别
    public Integer addBlogType(BlogType blogType);

    // 更新博客类别
    public Integer updateBlogType(BlogType blogType);

    // 删除博客类别
    public Integer deleteBlogType(Integer id);

    public List<BlogType> getBlogTypeData();

}
