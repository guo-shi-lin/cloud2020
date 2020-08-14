package com.atguigu.myrule;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ：Guo Shi Lin
 * @date ： 2020/8/14 17:03
 * @description：自定义Ribbon负载均衡算法，使用随机访问
 * @modified By：
 * @version: 1.0
 */
@Configuration
public class MyRule {
   @Bean
   public IRule myIRule() {
       return new RandomRule();
   }
}
