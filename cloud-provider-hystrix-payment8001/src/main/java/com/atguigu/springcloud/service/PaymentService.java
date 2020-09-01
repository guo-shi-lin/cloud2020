package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

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
    public String paymentInfo_ok(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_ok: " + id + "😄";
    }

    public String paymentFeignTimeout(Integer id) {
        int number = 3;
        try {
            TimeUnit.SECONDS.sleep(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_timeout: " + id + "😄" + "耗时(秒)"+number;
    }
}
