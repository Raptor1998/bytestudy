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
 * @created 2022/7/27  23:25
 */
@RestController
@Slf4j
public class Hello2Controller {
    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public String hello() throws InterruptedException {
        int i = 0;
        while (i<3){
            Date date = new Date();
            SimpleDateFormat slf = new SimpleDateFormat();
            String format = slf.format(date);
            log.info("hello2 info,{}",format);
            log.debug("hello2 debug,{}",format);
            log.error("hello2 error,{}",format);
            Thread.sleep(200);
            i++;
        }
        return "log hello2";
    }
}
