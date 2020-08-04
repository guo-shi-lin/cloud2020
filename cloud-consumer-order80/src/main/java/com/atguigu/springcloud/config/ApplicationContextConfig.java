package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author ：Guo Shi Lin
 * @date ： 2020/6/5 15:34
 * @description：配置文件 使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
 * @modified By：
 * @version: 1.0
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
