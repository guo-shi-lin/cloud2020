package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ：Guo Shi Lin
 * @date ： 2020/10/12 17:01
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator paymentRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_atguigu", f -> f.path("/guonei").uri("http://news.baidu.com/guonei"));
        routes.route("path_route_atguigu1", f -> f.path("/finance").uri("http://news.baidu.com/finance"));
        return routes.build();
    }
}
