package ssm.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ghang on 2018/2/12
 * 博主控制器
 */
@Controller //注册为控制器bean
@RequestMapping(value = "/blog")    //请求路径
public class BloggerController {

    @ResponseBody   //返回json数据
    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
}
