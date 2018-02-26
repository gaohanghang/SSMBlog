package ssm.blog.dao;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.blog.entity.BlogType;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xp on 2017/4/14.
 * @author xp
 * @Description 博客类别dao测试类
 */
@RunWith(SpringJUnit4ClassRunner.class) //这个是指定使用的单元测试执行类，这里就指定的是SpringJUnit4ClassRunner.class；
@ContextConfiguration(locations = "classpath:spring-beans.xml")//这个指定Spring配置文件所在的路径，可以同时指定多个文件；
public class BlogTypeDaoTest {

    @Resource
    private BlogTypeDao blogTypeDao;

    @Test
    public void addBlogType() throws Exception {
        BlogType blogType = new BlogType("Mysql",10);
        int result = blogTypeDao.addBlogType(blogType);
        System.out.println(result);
    }

    @Test
    public void deleteBlogType(){
        int result = blogTypeDao.deleteBlogType(19);
        System.out.println(result);
    }

    @Test
    public void updateBlogType() {
        //先查询要更新的记录然后修改
        BlogType blogType = blogTypeDao.getById(16);
        //然后提交更新
        blogType.setTypeName("更新mysql");
        //更新
        blogTypeDao.updateBlogType(blogType);
        //查询更新后的值，并且打印
        System.out.println(blogTypeDao.getById(16));
    }

    @Test
    public void getById() {
        BlogType blogType = blogTypeDao.getById(16);
        System.out.println(blogType);
    }

    @Test
    public void listByPage(){
        Integer page = 1;   //第一页
        Integer pageSize = 2;   //一页显示两条
        Integer start = (page-1)*pageSize;
        Integer end = page*pageSize;
        List<BlogType> blogTypeList = blogTypeDao.listByPage(start,end);
        for (BlogType b : blogTypeList) {
            System.out.println(b);
        }
    }

    @Test
    public void getTotal(){
        long total = blogTypeDao.getTotal();
        System.out.println(total);
    }


}
