package com.chong.mcspcorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebMvc
@ComponentScan({"com.chong.mcspcorderservice","com.chong.common"})
public class McSpcOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(McSpcOrderServiceApplication.class, args);
    }

}
