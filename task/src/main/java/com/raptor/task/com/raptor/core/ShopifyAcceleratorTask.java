package com.raptor.task.com.raptor.core;

import com.raptor.task.com.raptor.annotation.Schedule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Slf4j
@Component
@Schedule(taskName = "cg.raptor.access_shopify_accelerator")
public class ShopifyAcceleratorTask implements Task {


    @Override
    public void execTask(List<String> args) {
        System.out.println("cronjob is running......");

    }



}
