package com.yks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class App4 {
    public static void main(String[] args) {
        SpringApplication.run(App4.class, args);
    }
}
