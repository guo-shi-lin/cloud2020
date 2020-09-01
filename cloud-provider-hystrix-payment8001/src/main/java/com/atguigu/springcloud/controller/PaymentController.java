package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ：Guo Shi Lin
 * @date ： 2020/9/1 17:04
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String payment_OK(@PathVariable Integer id) {
        String result = paymentService.paymentInfo_ok(id);
        log.info("*****result：" + result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String payment_Timeout(@PathVariable Integer id) {
        String result = paymentService.paymentFeignTimeout(id);
        log.info("*****result：" + result);
        return result;
    }
}
