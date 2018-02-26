package ssm.blog.dao;

import org.springframework.stereotype.Repository;
import ssm.blog.entity.Blogger;

/**
 * Created by ghang on 2018/2/12.
 * 博主dao接口
 */
@Repository //注册为持久层的bean
public interface BloggerDao {
    /**
     * 查询博主信息
     * @return
     */
    Blogger getBloggerData();
}
