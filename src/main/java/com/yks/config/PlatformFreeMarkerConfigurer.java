package com.yks.config;

import com.jagregory.shiro.freemarker.ShiroTags;
import freemarker.template.Configuration;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/** FreeMarker模板添加shiro标签
 *  @author zhouhuan 
 *  @since JDK1.8
 *  @date 2018年1月25日
 */
@Component
public class PlatformFreeMarkerConfigurer implements InitializingBean {

    @Autowired
    private Configuration configuration;

    /**
     * 创建shiro权限标签
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        // 加上这句后，可以在页面上使用shiro标签
        configuration.setSharedVariable("shiro", new ShiroTags());
    }
}
