package com.yks.config;

import com.weibo.api.motan.config.springsupport.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {
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
     * @Description: 客户端配置
     * @author:
     * @date:
     * @return
     */

    @Bean
    @ConfigurationProperties(prefix = "motan.client")
    public BasicRefererConfigBean basicRefererConfigBean() {
        return new BasicRefererConfigBean();
    }
}
