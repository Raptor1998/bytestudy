package com.raptor.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/7/28  19:52
 */
@Component
@FeignClient(value = "log-trace-demo")
public interface LogService {

    @GetMapping(value = "/log/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id);
}
