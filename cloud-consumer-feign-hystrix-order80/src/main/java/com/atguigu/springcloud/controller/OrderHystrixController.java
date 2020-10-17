package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.OrderHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ：Guo Shi Lin
 * @date ： 2020/9/4 15:20
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_global_fallbackMethod")
public class OrderHystrixController {

    @Autowired
    private OrderHystrixService orderHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String payment_OK(@PathVariable Integer id) {
        String result = orderHystrixService.payment_OK(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand
    public String payment_Timeout(@PathVariable Integer id) {
        int age = 10/0;
        String result = orderHystrixService.payment_Timeout(id);
        return result;
    }

    public String payment_global_fallbackMethod() {
        return "global异常处理,请稍后再试。。。。";
    }
}
