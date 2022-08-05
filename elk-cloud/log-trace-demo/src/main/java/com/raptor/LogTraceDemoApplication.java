package com.raptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/7/28  15:14
 */
@EnableDiscoveryClient
@SpringBootApplication
@ServletComponentScan
public class LogTraceDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogTraceDemoApplication.class, args);
    }
}
