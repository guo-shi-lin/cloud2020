package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.OrderHystrixService;
import org.springframework.stereotype.Component;

/**
 * @Author ：Guo Shi Lin
 * @date ： 2020/9/27 10:14
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Component
public class OrderFallbackServiceImpl implements OrderHystrixService {
    @Override
    public String payment_OK(Integer id) {
        return "fail，请充实。";
    }

    @Override
    public String payment_Timeout(Integer id) {
        return "fail，请充实。";
    }
}
