package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.server.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author ：Guo Shi Lin
 * @date ： 2020/10/21 11:07
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }
}
