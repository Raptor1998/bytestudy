package com.raptor.elk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/7/26  21:11
 */
@RestController
@Slf4j
public class LogController {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello() throws InterruptedException {
        int i = 0;
        while (i<3){
            Date date = new Date();
            SimpleDateFormat slf = new SimpleDateFormat();
            String format = slf.format(date);
            log.info("hello info,{}",format);
            log.debug("hello debug,{}",format);
            log.error("hello error,{}",format);
            Thread.sleep(200);
            i++;
        }
        return "log hello";
    }
}
