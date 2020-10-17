package com.atguigu.springcloud.service;

import com.atguigu.springcloud.service.impl.OrderFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author ：Guo Shi Lin
 * @date ： 2020/9/19 11:25
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = OrderFallbackServiceImpl.class)
public interface OrderHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String payment_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String payment_Timeout(@PathVariable("id") Integer id);
}
