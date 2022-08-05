package com.raptor.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/7/28  15:18
 */
@RestController
@RefreshScope
@Slf4j
public class LogController {
    @Value("${server.port}")
    private String serverPort;

    @Value("${cloud.name}")
    private String cloudName;

    @GetMapping(value = "/log/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        log.info("我是log2......");
        String s = cloudName + " nacos registry, serverPort: " + serverPort + "\t id" + id;
        log.info("我是log2，返回结果：{}",s);
        return s;
    }
}
