package ssm.blog.service.impl;

import org.springframework.stereotype.Service;
import ssm.blog.dao.BlogTypeDao;
import ssm.blog.entity.BlogType;
import ssm.blog.entity.PageBean;
import ssm.blog.service.BlogTypeService;

import javax.annotation.Resource;
import javax.xml.ws.ServiceMode;
import java.util.List;

/**
 * Create by ghang on 2018/2/14
 * @author 高行行
 * @Description 博客类别service接口实现类
 */
@Service
public class BlogTypeServiceImpl implements BlogTypeService{

    @Resource
    private BlogTypeDao blogTypeDao;


    public PageBean<BlogType> listByPage(PageBean<BlogType> pageBean) {
        //查询分页结果
        pageBean.setResult(blogTypeDao.listByPage(pageBean.getStart(),pageBean.getEnd()));
        //查询记录总数
        pageBean.setTotal(blogTypeDao.getTotal());
        return pageBean;
    }

    public Long getTotal(){
        return blogTypeDao.getTotal();
    }

    public Integer addBlogType(BlogType blogType) {
        return blogTypeDao.addBlogType(blogType);
    }

    public Integer updateBlogType(BlogType blogType) {
        return blogTypeDao.updateBlogType(blogType);
    }

    public Integer deleteBlogType(Integer id) {
        return blogTypeDao.deleteBlogType(id);
    }

    public List<BlogType> getBlogTypeData() {
        return blogTypeDao.getBlogTypeData();
    }
}
