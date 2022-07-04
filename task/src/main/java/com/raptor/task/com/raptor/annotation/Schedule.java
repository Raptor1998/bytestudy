package com.raptor.task.com.raptor.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Schedule {

    /**
     * 任务名称
     */
    String taskName();
}
