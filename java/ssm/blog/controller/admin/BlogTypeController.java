package ssm.blog.controller.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ssm.blog.entity.BlogType;
import ssm.blog.entity.PageBean;
import ssm.blog.service.BlogTypeService;
import ssm.blog.util.ResponseUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by ghang on 2018/2/14.
 *
 * @author 高行行
 * @Description 博客分类控制器
 */
@Controller  //代表这是一个控制器bean
@RequestMapping(value = "/admin/blogType") //类级别的请求路径 我们使用admin代表这是后台管理blogType代表管理博客类别
public class BlogTypeController {

    @Resource
    private BlogTypeService blogTypeService;

    // 分页查询博客类别
    @RequestMapping("/list")  //就是请求这个分页方法的路径
    public String listBlogType(
            @RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            HttpServletResponse response) throws Exception {
        //定义分页bean
        PageBean<BlogType> pageBean = new PageBean<BlogType>(Integer.parseInt(page), Integer.parseInt(rows));
        //拿到分页结果已经记录总数的pageBean
        pageBean = blogTypeService.listByPage(pageBean);
        //使用阿里巴巴的fastJson创建JSONObject();
        JSONObject result = new JSONObject();
        //通过fastJson序列化list为jsonArray
        String jsonArray = JSON.toJSONString(pageBean.getResult());
        JSONArray array = JSONArray.parseArray(jsonArray);
        //将序列化结果放入json对象中
        result.put("rows", array);
        result.put("total", pageBean.getTotal());

        //使用自定义工具类向response中写入数据
        ResponseUtil.write(response, result);
        return null;
    }

    // 添加和更新博客类别
    @RequestMapping("/save")
    public String save(BlogType blogType, HttpServletResponse response)
            throws Exception {

        int resultTotal = 0; // 接收返回结果记录数
        if (blogType.getId() == null) { // 说明是第一次插入
            resultTotal = blogTypeService.addBlogType(blogType);
        } else { // 有id表示修改
            resultTotal = blogTypeService.updateBlogType(blogType);
        }

        JSONObject result = new JSONObject();
        if (resultTotal > 0) {
            result.put("success", true);
        } else {
            result.put("success", false);
        }
        ResponseUtil.write(response, result);
        return null;
    }

    // 博客类别信息删除
    /*
    通过required=false或者true来要求@RequestParam配置的前端参数是否一定要传
    required=false表示不传的话，会给参数赋值为null，required=true就是必须要有
     */
    @RequestMapping(value = "/delete")
    public String deleteBlog(
            @RequestParam(value = "ids", required = false) String ids,
            HttpServletResponse response) throws Exception {
        //分割字符串得到id数组
        String[] idsStr = ids.split(",");
        JSONObject result = new JSONObject();
        for (int i = 0; i < idsStr.length; i++) {
            int id = Integer.parseInt(idsStr[i]);
            //其实在这里我们要判断该博客类别下面是否有博客 如果有就禁止删除博客类别，等我们完成博客对应的操作再来完善
            blogTypeService.deleteBlogType(id);
        }
        result.put("success",true);
        ResponseUtil.write(response,result);
        return null;
    }

}
