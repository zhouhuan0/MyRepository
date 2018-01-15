package com.yks.controller;




import com.sun.istack.internal.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestController {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/add")
    public Integer add(Integer a, Integer b) {
        Integer x = a + b;
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + x);
        return x;
    }
}
