package com.yks.config;

import com.weibo.api.motan.config.springsupport.AnnotationBean;
import com.weibo.api.motan.config.springsupport.BasicServiceConfigBean;
import com.weibo.api.motan.config.springsupport.ProtocolConfigBean;
import com.weibo.api.motan.config.springsupport.RegistryConfigBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerConfig {
    /**
     * 声明Annotation用来指定需要解析的包名
     * @return
     */
    @Bean
    public AnnotationBean annotationBean(){
        return new AnnotationBean();
    }

    /**
     * @return
     * @Description: 协议配置
     * @author:
     * @date:
     */
    @Bean(name = "motanServer")
    @ConfigurationProperties(prefix = "motan.protocol")
    public ProtocolConfigBean protocolConfigBean() {
       return new ProtocolConfigBean();
    }

    /**
     * @return
     * @Description: 注册中心配置
     * @author:
     * @date:
     */
    @Bean(name = "registry")
    @ConfigurationProperties(prefix = "motan.registry")
    public RegistryConfigBean registryConfigBean() {
       return new RegistryConfigBean();
    }

    /**
     * @Description: 服务端配置
     * @author:
     * @date:
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "motan.server")
    public BasicServiceConfigBean basicServiceConfigBean() {
       return new BasicServiceConfigBean();
    }
}
