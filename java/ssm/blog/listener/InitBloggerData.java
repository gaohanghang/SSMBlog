package ssm.blog.listener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import ssm.blog.entity.BlogType;
import ssm.blog.service.BlogTypeService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

/**
 * @Author xp
 * @Description 监听程序初始化
 * @Date 2018/2/23
 */
public class InitBloggerData implements ServletContextListener, ApplicationContextAware {
    /*
    实现一个用于自定义监听器 实现要实现ServletContextListener接口
    由于我们要获取spring容器 所以我们还要实现ApplicationContextAware接口 并且实现对应的方法。
    然后通过spring容器获取的我们的BlogTypeService对象
    获取到博客类型列表blogTypeList 并且把它存到我们的application中
    这样我们的自定义监听器就配置ok 但是还没有完成。
     */

    private static ApplicationContext applicationContext;

    public void contextInitialized(ServletContextEvent sce) {
        //先获取servlet上下文
        ServletContext application = sce.getServletContext();
        //同上，获取博客类别信息service
        BlogTypeService blogTypeService = applicationContext.getBean(BlogTypeService.class);
        List<BlogType> blogTypeList = blogTypeService.getBlogTypeData();
        application.setAttribute("blogTypeList", blogTypeList);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub

    }

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        InitBloggerData.applicationContext = applicationContext;
    }

}

