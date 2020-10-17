package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author ：Guo Shi Lin
 * @date ： 2020/9/1 16:58
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Service
public class PaymentService {

    /**
     * 服务降级
     **/
    public String paymentInfo_ok(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_ok: " + id + "😄";
    }

    @HystrixCommand(fallbackMethod = "paymentFeignTimeoutHandle", commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    public String paymentFeignTimeout(Integer id) {
        int age = 10/0;
        int number = 2;
        try {
            TimeUnit.SECONDS.sleep(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_timeout: " + id + "😄" + "耗时(秒)"+number;
    }

    public String paymentFeignTimeoutHandle(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "系统繁忙，请稍后再试: " + id + "😭";
    }


    /**
     * 服务熔断
     **/
    @HystrixCommand(fallbackMethod = "paymentFusing_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String paymentFusing(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("id不能为负数。。。");
        }
        String UUID = IdUtil.simpleUUID();
        return "调用成功：" + UUID;
    }

    public String paymentFusing_fallback(@PathVariable("id") Integer id) {
        return "调用失败，id不能为负数";
    }
}
