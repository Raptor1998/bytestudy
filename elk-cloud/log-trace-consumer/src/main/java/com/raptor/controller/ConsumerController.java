package com.raptor.controller;

import com.raptor.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/7/28  19:59
 */
@RestController
@Slf4j
public class ConsumerController {

    private LogService logService;

    @Autowired
    public ConsumerController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/consumer/hello/{id}")
    public String hello(@PathVariable int id){
        log.info("我是消费者......");
        System.out.println(id);
        String payment = logService.getPayment(id);
        log.info("我是消费者，请求结果：{}",payment);
        return payment;
    }
}
